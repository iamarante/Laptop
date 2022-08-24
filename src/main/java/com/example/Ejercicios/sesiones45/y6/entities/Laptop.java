package com.example.Ejercicios.sesiones45.y6.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String procesador;
    private Integer memoriaRam;

    public Laptop() {
    }

    public Laptop(Long id, String procesador, Integer memoriaRam) {
        this.id = id;
        this.procesador = procesador;
        this.memoriaRam = memoriaRam;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public Integer getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(Integer memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", procesador='" + procesador + '\'' +
                ", memoriaRam=" + memoriaRam +
                '}';
    }
}
