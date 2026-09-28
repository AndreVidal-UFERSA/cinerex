package br.edu.ufersa.cinerex.features.ingresso;

import br.edu.ufersa.cinerex.features.ingresso.dto.IngressoCreate;
import br.edu.ufersa.cinerex.features.ingresso.dto.IngressoResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/ingressos")
class IngressoController {
    private final IngressoApplicationService service;

    public IngressoController(IngressoApplicationService service){
        this.service = service;
    }

    //CREATE
    @PostMapping
    public ResponseEntity<IngressoResponse> criar(@Valid @RequestBody IngressoCreate ingressoCreate){
        IngressoResponse response = service.criar(ingressoCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // READ

    @GetMapping
    public ResponseEntity<List<IngressoResponse>> getIngresso() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngressoResponse> getIngresso(@PathVariable Long id) {
        IngressoResponse ingressoResponse = service.encontrar(id);
        return ResponseEntity.ok(ingressoResponse);

    }

    // Edita status
    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelarIngresso(@PathVariable Long id) {
        service.cancelar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/utilizar")
    public ResponseEntity<Void> utilizarIngresso(@PathVariable Long id) {
        service.utilizar(id);
        return ResponseEntity.noContent().build();
    }
}


