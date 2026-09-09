package br.edu.ufersa.cinerex.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/venda")
public class VendaController {

    // CREATE
    @PostMapping
    public ResponseEntity<Void> postVenda(@RequestBody Object postVendaRequest) {
        // TODO: Implementar a lógica de criação de venda
        return null;
    }

    // READ
    @GetMapping
    public List<Object> getVendas() {
        // TODO: Implementar a listagem de vendas
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getVenda(@PathVariable Long id) {
        // TODO: Implementar a busca de venda por ID
        return null;
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Void> putVenda(@PathVariable Long id, @RequestBody Object putVendaRequest) {
        // TODO: Implementar a atualização de venda
        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenda(@PathVariable Long id) {
        // TODO: Implementar a deleção de venda
        return null;
    }
}
