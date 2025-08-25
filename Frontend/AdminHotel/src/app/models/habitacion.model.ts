export interface HotelMini {
  idHotel?: number;
  nombreHotel?: string;
}

export interface Habitacion {
  idHabitacion?: number;
  numero: number;
  tipo: string;
  precioPorNoche: number;
  disponible: boolean;
  capacidad: number;
  descripcion?: string;
  imagenUrl?: string;
  hotel?: HotelMini;
}