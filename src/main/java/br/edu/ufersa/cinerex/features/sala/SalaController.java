package br.edu.ufersa.cinerex.features.sala;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import br.edu.ufersa.cinerex.features.sala.dto.RequestPostSala;
import br.edu.ufersa.cinerex.features.sala.dto.RequestPutSala;
import br.edu.ufersa.cinerex.features.sala.dto.SalaResponse;
import br.edu.ufersa.cinerex.shared.exceptions.RecursoJaExiste;
import br.edu.ufersa.cinerex.shared.exceptions.RecursoNaoEncontrado;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/salas")
@Validated
class SalaController {

    private final SalaApplicationService applicationService;

    public SalaController(SalaApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Void> postSala(@Valid @RequestBody RequestPostSala requestPostSala) {
        try {
            Long idCriado = applicationService.criar(requestPostSala);
            URI location = URI.create("/api/v1/sala/" + idCriado);
            return ResponseEntity.created(location).build();
        } catch (RecursoJaExiste ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    // READ
    @GetMapping
    public ResponseEntity<List<SalaResponse>> getSalas() {
        return ResponseEntity.ok(applicationService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaResponse> getSala(@PathVariable Long id) {
        Optional<SalaResponse> salaResponseOptional = applicationService.encontrar(id);
        if (salaResponseOptional.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(salaResponseOptional.get());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Void> putSala(@PathVariable Long id, @Valid @RequestBody RequestPutSala requestPutSala) {
        try {
            applicationService.atualizarTotal(id, requestPutSala);
        } catch (RecursoNaoEncontrado ex) {
            return ResponseEntity.notFound().build();
        } catch (RecursoJaExiste ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.noContent().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSala(@PathVariable Long id) {
        try {
            applicationService.removerSala(id);
        } catch (RecursoNaoEncontrado ex) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}