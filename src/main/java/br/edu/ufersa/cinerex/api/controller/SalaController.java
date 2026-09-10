package br.edu.ufersa.cinerex.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sala")
public class SalaController {
    // CREATE

    @PostMapping
    public ResponseEntity<Void> criarSala(@RequestBody Object sala) {
        return null;
    }

    // READ

    @GetMapping
    public List<Object> getSalas() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSala() {
        return null;
    }

    // UPDATE

    @PutMapping("/{id}")
    public ResponseEntity<Object> putSala(@RequestBody Object sala) {
        return null;
    }

    // DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSala(Long id) {
        return null;
    }
}
