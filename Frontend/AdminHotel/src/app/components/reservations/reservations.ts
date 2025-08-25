import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule, AbstractControl, ValidationErrors } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ReservaService } from '../../services/reserva.service';
import { Router, RouterModule } from '@angular/router';
import { ReservaCliente } from '../../models/Reserva-Cliente';
import { HttpErrorResponse } from '@angular/common/http';
import { Habitacion } from '../../models/habitacion.model';
import { HabitacionService } from '../../services/habitacion.service';

@Component({
  selector: 'app-reservations',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  templateUrl: './reservations.html',
  styleUrls: ['./reservations.css']
})
export class Reservations implements OnInit {
  reservaForm!: FormGroup;
  noches = 0;
  total = 0;
  saving = false;
  errorMsg = '';
  successMsg = '';

  habitacionesHoy: Habitacion[] = [];

  habitaciones: Habitacion[] = [];

  selectedHabitacion?: Habitacion;

  // fechas mínimas (ISO YYYY-MM-DD)
  minDate = this.todayIso();

  constructor(
    private fb: FormBuilder,
    private reservaService: ReservaService,
    private habitacionService: HabitacionService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.initForm();

    // cargar sólo las habitaciones disponibles para HOY
    this.loadDisponiblesHoy();


    this.reservaForm.get('idHabitacion')?.valueChanges.subscribe((id) => {
      this.onIdHabitacionChange(id);
    });


    this.reservaForm.get('fechaEntrada')?.valueChanges.subscribe((fechaEntrada: string) => {

      this.setFechaSalidaMin(fechaEntrada);
      this.calcularTotales();
    });

    this.reservaForm.get('fechaSalida')?.valueChanges.subscribe(() => this.calcularTotales());
  }

  private initForm(): void {
    this.reservaForm = this.fb.group({

      numeroHabitacion: ['', [Validators.required]],


      idHabitacion: [null, [Validators.required, Validators.min(1)]],

      nombre: ['', Validators.required],
      apellido: ['', Validators.required],
      dni: ['', Validators.required],
      telefono: [''],
      email: ['', [Validators.email]],
      fechaEntrada: ['', [Validators.required, this.fechaNoAnteriorValidator.bind(this)]],
      fechaSalida: ['', [Validators.required]],
      estado: ['PENDIENTE', Validators.required]
    }, { validators: this.fechaSalidaNoAnteriorAEntradaValidator });
  }

  // Valida que fechaEntrada no sea anterior a hoy
  private fechaNoAnteriorValidator(control: AbstractControl): ValidationErrors | null {
    const val = control.value;
    if (!val) return null;
    const fecha = new Date(val);
    const hoy = new Date(this.minDate);
    hoy.setHours(0,0,0,0);
    if (fecha < hoy) {
      return { fechaAnterior: true };
    }
    return null;
  }

  // Valida que fechaSalida >= fechaEntrada
  private fechaSalidaNoAnteriorAEntradaValidator(group: AbstractControl): ValidationErrors | null {
    const entrada = group.get('fechaEntrada')?.value;
    const salida = group.get('fechaSalida')?.value;
    if (!entrada || !salida) return null;
    const dEntrada = new Date(entrada);
    const dSalida = new Date(salida);
    if (dSalida < dEntrada) {
      return { salidaAnteriorEntrada: true };
    }
    return null;
  }


  loadDisponiblesHoy(): void {
    const hoy = this.todayIso();
    console.log('Solicitando disponibles para:', hoy);
    this.habitacionService.getDisponiblesByFecha(hoy).subscribe({
      next: (disp) => {
        console.log('Respuesta getDisponiblesByFecha:', disp);
        
        this.habitacionesHoy = Array.isArray(disp) ? disp : [];
        this.habitaciones = [...this.habitacionesHoy];

        
        if (this.selectedHabitacion && !this.habitacionesHoy.some(h => h.idHabitacion === this.selectedHabitacion?.idHabitacion)) {
          this.clearHabitacionSelection();
        }
      },
      error: (err: HttpErrorResponse) => {
        console.error('Error cargando disponibles hoy', err);
        this.habitacionesHoy = [];
        this.habitaciones = [];
      }
    });
  }

  
  onFechaEntradaChange(fechaIso: string | null) {
    const fecha = fechaIso ?? this.minDate;
    this.habitacionService.getDisponiblesByFecha(fecha).subscribe({
      next: (hs) => {
        console.log('habitaciones recibidas para fecha:', fecha, hs);
        this.habitaciones = hs || [];
        if (this.selectedHabitacion && !this.habitaciones.some(h => h.idHabitacion === this.selectedHabitacion?.idHabitacion)) {
          this.clearHabitacionSelection();
        }
      },
      error: (err: HttpErrorResponse) => {
        console.error('Error cargando habitaciones disponibles', err);
        this.habitaciones = [];
      }
    });
  }

  // llamado cuando cambia el control idHabitacion (select)
  public onIdHabitacionChange(id: any) {
    if (!id) {
      this.clearHabitacionSelection();
      return;
    }
    const idNum = Number(id);
    if (isNaN(idNum)) {
      this.clearHabitacionSelection();
      return;
    }
    const encontrada = this.habitacionesHoy.find(h => Number(h.idHabitacion) === idNum);
    if (encontrada) {
      this.selectHabitacion(encontrada);
    } else {
      // la id seleccionada no está en la lista de disponibles hoy -> limpiar y avisar
      console.warn('ID seleccionada no está en disponiblesHoy:', idNum);
      this.clearHabitacionSelection();
    }
  }


  private selectHabitacion(h: Habitacion) {
    this.selectedHabitacion = h;
    this.reservaForm.patchValue({
      idHabitacion: h.idHabitacion,
      numeroHabitacion: h.numero
    }, { emitEvent: false }); 
    this.calcularTotales();
  }

  private clearHabitacionSelection() {
    this.selectedHabitacion = undefined;
    // dejamos numero en vacío y id en null
    this.reservaForm.patchValue({ idHabitacion: null, numeroHabitacion: '' }, { emitEvent: false });
    this.calcularTotales();
  }

  private setFechaSalidaMin(fechaEntradaIso: string | null) {
    const salidaControl = this.reservaForm.get('fechaSalida');
    if (!fechaEntradaIso) {
      salidaControl?.setValue('');
      return;
    }
    const salidaVal = salidaControl?.value;
    if (salidaVal && new Date(salidaVal) < new Date(fechaEntradaIso)) {
      salidaControl?.setValue('');
    }
  }

  calcularTotales(): void {
    const entradaVal = this.reservaForm.get('fechaEntrada')?.value;
    const salidaVal = this.reservaForm.get('fechaSalida')?.value;
    const entrada = entradaVal ? new Date(entradaVal) : null;
    const salida = salidaVal ? new Date(salidaVal) : null;

    if (entrada && salida && salida >= entrada) {
      const diff = salida.getTime() - entrada.getTime();
      this.noches = diff / (1000 * 60 * 60 * 24);
    } else {
      this.noches = 0;
    }

    if (this.selectedHabitacion && this.selectedHabitacion.precioPorNoche) {
      this.total = (this.selectedHabitacion.precioPorNoche as any) * this.noches;
    } else {
      this.total = 0;
    }
  }

  //  YYYY-MM-DD
  private todayIso(): string {
    const t = new Date();
    t.setHours(0,0,0,0);
    return t.toISOString().split('T')[0];
  }

  // cuando envían formulario
  onSubmit(): void {
    this.errorMsg = '';
    this.successMsg = '';

    if (this.reservaForm.invalid) {
      this.errorMsg = 'Por favor completa los campos obligatorios y revisa las fechas.';
      return;
    }

    const idHab = this.reservaForm.get('idHabitacion')?.value;
    if (!idHab) {
      this.errorMsg = 'Selecciona una habitación válida disponible hoy.';
      return;
    }

    const f = this.reservaForm.getRawValue();
    const payload: ReservaCliente = {
      clienteId: 0,
      nombre: f.nombre,
      apellido: f.apellido,
      dni: f.dni,
      telefono: f.telefono,
      email: f.email,
      fechaEntrada: f.fechaEntrada,
      fechaSalida: f.fechaSalida,
      estado: f.estado,
      idHabitacion: Number(idHab)
    };

    this.saving = true;
    this.reservaService.createReserva(payload).subscribe({
      next: () => {
        this.saving = false;
        this.successMsg = 'Reserva registrada con éxito.';
        this.reservaForm.reset({ estado: 'PENDIENTE' });
        // recargar disponibles hoy para reflejar cambio de estado
        this.loadDisponiblesHoy();
        setTimeout(() => this.router.navigate(['/dashboard']), 800);
      },
      error: (err: HttpErrorResponse) => {
        this.saving = false;
        console.error('Error creando reserva', err);
        this.errorMsg = err.error?.message || 'No se pudo crear la reserva.';
      }
    });
  }
}
