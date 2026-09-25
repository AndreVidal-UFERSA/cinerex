package br.edu.ufersa.cinerex.features.ingresso;

import br.edu.ufersa.cinerex.features.ingresso.dto.IngressoCreate;
import br.edu.ufersa.cinerex.features.ingresso.dto.IngressoResponse;
import br.edu.ufersa.cinerex.features.ingresso.dto.IngressoUpdate;
import br.edu.ufersa.cinerex.shared.exceptions.RecursoNaoEncontrado;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        Optional<IngressoResponse> ingressoResponseOptional = service.encontrar(id);
        if (ingressoResponseOptional.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(ingressoResponseOptional.get());
    }


    //ATUALIZAR COMPLETAMENTE
    @PutMapping("/{id}")
    public ResponseEntity<Void> putIngresso(@PathVariable Long id, @RequestBody IngressoUpdate ingressoUpdate) {
        try {
            service.atualizarTotal(id, ingressoUpdate);
        }
        catch (RecursoNaoEncontrado ex) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngresso(@PathVariable Long id) {
        try {
            service.removerIngresso(id);
        } catch (RecursoNaoEncontrado ex) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}


