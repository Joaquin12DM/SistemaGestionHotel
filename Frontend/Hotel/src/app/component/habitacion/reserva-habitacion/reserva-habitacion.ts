import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ReservaService, ReservaCliente } from '../../../servicios/reserva-service';
import { ActivatedRoute, Router } from '@angular/router';
import { Habitacion, HabitacionService } from '../../../servicios/habitacion.service';

@Component({
  selector: 'app-reserva-habitacion',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './reserva-habitacion.html',

})
export class ReservaHabitacion implements OnInit {
  reservaForm!: FormGroup;
  noches = 0;
  total = 0;
  saving = false;
  errorMsg = '';
  successMsg = '';
  habitacion?: Habitacion;
  // >>> Controlar el PopUp
  showPagoPopup = false; 
  pagoexitoso = false;
  constructor(
    private fb: FormBuilder, 
    private route: ActivatedRoute,
    private habitacionService: HabitacionService,
    private reservaService: ReservaService,
    private router: Router
  ){}

  ngOnInit(): void {
    //Prepara campos de habitacion, cliente y reserva:
     this.initForm();

      //captura el id de la URL
      const idParam = this.route.snapshot.paramMap.get('id')
      || this.route.snapshot.queryParamMap.get('id');
      
      if(idParam){
        const id= Number(idParam);
        if (!isNaN(id)){
          this.cargarHabitacion(id)
        }
      }
      //Recarcular noches y total cuando se cambien las fechas
      this.reservaForm.valueChanges.subscribe(() => this.calcularTotales());
  }

  private initForm() {
    this.reservaForm = this.fb.group({
      idHabitacion: [null, Validators.required],
      tipoHabitacion: [{ value: '', disabled: true }],
      precioPorNoche: [{ value: 0, disabled: true }],
      capacidad: [{ value: '', disabled: true }],

      nombre: ['', Validators.required],
      apellido: ['', Validators.required],
      dni: ['', Validators.required],
      telefono: [''],
      email: ['', [Validators.email]],

      fechaEntrada: ['', Validators.required],
      fechaSalida: ['', Validators.required],
    });
  }
  //funciones:
  cargarHabitacion(id: number){
    this.habitacionService.getById(id).subscribe({
      next: (h : Habitacion) => {
        this.habitacion = h;
        this.reservaForm.patchValue({
          idHabitacion: h.idHabitacion,
          tipoHabitacion: h.tipo ?? '',
          precioPorNoche: h.precioPorNoche ?? 0,
          capacidad: h.capacidad ?? ''
        });
        this.calcularTotales();
      },
            error: (err) => {
        console.error('Error al cargar habitación', err);
        this.errorMsg = 'No se pudo cargar la habitación.';
      }
    });
  }

  calcularTotales(){
    const entrada = new Date(this.reservaForm.get('fechaEntrada')?.value);
    const salida = new Date(this.reservaForm.get('fechaSalida')?.value);
    const precio = Number(this.reservaForm.get('precioPorNoche')?.value) || 0;

    if(!isNaN(entrada.getTime()) && !isNaN(salida.getTime()) && salida > entrada){
      const diff = salida.getTime() - entrada.getTime();
      this.noches = diff / (1000 * 60 * 60 * 24);
      this.total = this.noches * precio;
    } else  {
      this.noches = 0;
      this.total = 0;
    }
  }


    onSubmit() {
    this.errorMsg = '';
    this.successMsg = '';
    if (this.reservaForm.invalid) {
      this.errorMsg = 'Por favor completa los campos obligatorios.';
      return;
    }
    this.showPagoPopup = true;
  }
  confirmarPago() {
  if (this.reservaForm.invalid) {
    this.errorMsg = 'Por favor completa los campos obligatorios.';
    return;
  }

  const reserva: ReservaCliente = {
    clienteId: 0, 
    nombre: this.reservaForm.get('nombre')?.value,
    apellido: this.reservaForm.get('apellido')?.value,
    dni: this.reservaForm.get('dni')?.value,
    telefono: this.reservaForm.get('telefono')?.value,
    email: this.reservaForm.get('email')?.value,
    fechaEntrada: this.reservaForm.get('fechaEntrada')?.value,
    fechaSalida: this.reservaForm.get('fechaSalida')?.value,
    estado: 'PENDIENTE',
    idHabitacion: this.reservaForm.get('idHabitacion')?.value,
  };

  this.saving = true;
  this.reservaService.saveReserva(reserva).subscribe({
    next: () => {
      this.saving = false;
      this.pagoexitoso = true;
      this.successMsg = 'Reserva confirmada con éxito ✅';
      this.showPagoPopup = false;

      // Redirigir al home
      setTimeout(() => this.router.navigate(['']), 2000);
    },
    error: (err) => {
      this.saving = false;
      console.error('Error al confirmar reserva', err);
      this.errorMsg = 'No se pudo procesar la reserva ❌';
    }
  });
}

cancelarPago() {
  this.showPagoPopup = false;
  this.errorMsg = '';
  this.successMsg = '';
}

}
