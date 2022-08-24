package com.example.Ejercicios.sesiones45.y6.controller;

import com.example.Ejercicios.sesiones45.y6.entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {
    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://127.0.0.1:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }
    @DisplayName("Probando método Rest create")
    @Test
    void createTest() {
        // Preparando la cabecera
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        // Preparando Json
        String json = """
                {
                    "procesador": "i5",
                    "memoriaRam": 18
                }
                """;

        // Creando la solicitud Http con el json y la cabecera
        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Laptop> response =
                testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);
        Laptop result = response.getBody();

        // Comprobaciones
        assertEquals(1L, result.getId());
        assertEquals("i5", result.getProcesador());
        assertEquals(18, result.getMemoriaRam());
    }

    @Test
    void deleteTest() {
        ResponseEntity<Laptop> response =
                testRestTemplate.exchange("/api/laptops/1", HttpMethod.DELETE, null, Laptop.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void deleteAll() {
    }

    @Test
    void findOneById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
    }
}