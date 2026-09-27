package br.edu.ufersa.cinerex.features.filme;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import br.edu.ufersa.cinerex.features.filme.dto.FilmeResponse;
import br.edu.ufersa.cinerex.features.filme.dto.RequestPostFilme;
import br.edu.ufersa.cinerex.features.filme.dto.RequestPutFilme;
import br.edu.ufersa.cinerex.shared.exceptions.RecursoNaoEncontrado;
import jakarta.validation.Valid;

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
@RequestMapping("/api/v1/filme")
@Validated
class FilmeController {

    private final FilmeApplicationService applicationService;

    public FilmeController(FilmeApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Void> postFilme(@Valid @RequestBody RequestPostFilme requestPostFilme) {
        Long idCriado = applicationService.criar(requestPostFilme);
        URI location = URI.create("/api/v1/filme/" + idCriado);
        return ResponseEntity.created(location).build();
    }

    // READ
    @GetMapping
    public ResponseEntity<List<FilmeResponse>> getFilmes() {
        return ResponseEntity.ok(applicationService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeResponse> getFilme(@PathVariable Long id) {
        Optional<FilmeResponse> filmeResponseOptional = applicationService.encontrar(id);
        if (filmeResponseOptional.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(filmeResponseOptional.get());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Void> putFilme(@PathVariable Long id, @Valid @RequestBody RequestPutFilme requestPutFilme) {
        try {
            applicationService.atualizarTotal(id, requestPutFilme);
        } catch (RecursoNaoEncontrado ex) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilme(@PathVariable Long id) {
        try {
            applicationService.removerFilme(id);
        } catch (RecursoNaoEncontrado ex) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}