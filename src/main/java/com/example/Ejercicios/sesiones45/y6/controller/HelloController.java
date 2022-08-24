package com.example.Ejercicios.sesiones45.y6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String saludo(){
        return "Bienvenido al ejercicio 4, 5, 6 del curso";
    }
}
