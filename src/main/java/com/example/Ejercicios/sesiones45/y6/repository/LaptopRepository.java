package com.example.Ejercicios.sesiones45.y6.repository;

import com.example.Ejercicios.sesiones45.y6.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {

}