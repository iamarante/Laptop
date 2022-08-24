package com.example.Ejercicios.sesiones45.y6.controller;

import com.example.Ejercicios.sesiones45.y6.entities.Laptop;
import com.example.Ejercicios.sesiones45.y6.repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    private final Logger LOG = LoggerFactory.getLogger(LaptopController.class);
    public LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @PostMapping("/api/laptops")
    @ApiOperation("Crear una Laptop con un RequestBody")
    public ResponseEntity<Laptop> create(@ApiParam("Json parameter") @RequestBody Laptop laptop){
        if (laptop.getId() != null){
            LOG.warn("Intentando crear una laptop con id");
            ResponseEntity.badRequest().build();
        }
        LOG.info("Solicitud Rest para crear una Laptop");
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if (laptopRepository.existsById(id)){
            LOG.info("Solicitud Rest para borrar una Laptop por id");
            laptopRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            LOG.warn("Intentando borrar Laptop con id inexistente");
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/laptops")
    public void deleteAll(){
        LOG.info("Solicitud Rest para borrar todas las Laptops");
        laptopRepository.deleteAll();
    }

    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> laptopOptional = laptopRepository.findById(id);
        if (laptopOptional.isPresent()) {
            LOG.info("Solicitud Rest para buscar un libro por id");
            return ResponseEntity.ok(laptopOptional.get());
        } else {
            LOG.warn("Intentando buscar una Laptop con id inexistente");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        LOG.info("Solicitud Rest para buscar todas las laptops");
        return laptopRepository.findAll();
    }

    @PutMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if (laptop.getId() == null){
            LOG.warn("Intentando actualizar Laptop sin un id ");
            return ResponseEntity.badRequest().build();
        }

        if (!laptopRepository.existsById(laptop.getId())) {
            LOG.warn("Intentando actualizar Laptop con id inexistente");
            return ResponseEntity.notFound().build();
        }

        Laptop result = laptopRepository.save(laptop);
        LOG.info("Solicitud Rest para actualizar una Laptop por id");
        return ResponseEntity.ok(result);
    }
}
