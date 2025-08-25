export interface ReservaCliente {
  clienteId?: number;
  nombre: string;
  apellido: string;
  dni: string;
  telefono?: string;
  email?: string;
  fechaEntrada: string; // "YYYY-MM-DD"
  fechaSalida: string;  // "YYYY-MM-DD"
  estado?: string;
  idHabitacion: number;
}