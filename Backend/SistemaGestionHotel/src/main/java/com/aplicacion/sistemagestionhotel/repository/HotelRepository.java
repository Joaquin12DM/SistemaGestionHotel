package com.aplicacion.sistemagestionhotel.repository;

import com.aplicacion.sistemagestionhotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
