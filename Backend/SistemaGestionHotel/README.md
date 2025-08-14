# Sistema de Gestión Hotel - Backend

Este proyecto es una API REST desarrollada con Spring Boot para la gestión de hoteles, habitaciones, clientes y reservas.

## Endpoints disponibles

### Cliente
- `GET /cliente` - Obtiene todos los clientes.
- `GET /cliente/{id}` - Obtiene un cliente por su ID.
- `POST /cliente/save` - Crea o actualiza un cliente.
- `DELETE /cliente/{id}` - Elimina un cliente por su ID.

### Hotel
- `GET /hotel` - Obtiene todos los hoteles.
- `GET /hotel/{id}` - Obtiene un hotel por su ID.
- `POST /hotel/save` - Crea o actualiza un hotel.
- `DELETE /hotel/{id}` - Elimina un hotel por su ID.

### Habitación
- `GET /habitacion` - Obtiene todas las habitaciones.
- `GET /habitacion/{id}` - Obtiene una habitación por su ID.
- `GET /habitacion/{fecha}` - Obtiene habitaciones que esten disponibles segun fecha.
- `POST /habitacion/save` - Crea o actualiza una habitación.
- `DELETE /habitacion/{id}` - Elimina una habitación por su ID.

### Reserva
- `GET /reserva` - Obtiene todas las reservas.
- `GET /reserva/{id}` - Obtiene una reserva por su ID.
- `POST /reserva/save` - Crea o actualiza una reserva.
- `DELETE /reserva/{id}` - Elimina una reserva por su ID.

## Notas
- Todos los endpoints aceptan y devuelven datos en formato JSON.
- Para crear o actualizar entidades, envíe el objeto correspondiente en el cuerpo de la petición.

## Ejemplo de uso
```bash
curl -X GET http://localhost:8082/cliente
```


