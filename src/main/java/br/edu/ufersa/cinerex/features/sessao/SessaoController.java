package br.edu.ufersa.cinerex.features.sessao;

import br.edu.ufersa.cinerex.features.sessao.dto.RequestPostSessao;
import br.edu.ufersa.cinerex.features.sessao.dto.RequestPutSessao;
import br.edu.ufersa.cinerex.features.sessao.dto.SessaoResponse;
import br.edu.ufersa.cinerex.shared.exceptions.RecursoNaoEncontrado;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/sessoes")
@Validated
class SessaoController {
    private final SessaoApplicationService applicationService;

    public SessaoController(SessaoApplicationService applicationService) {
        this.applicationService = applicationService;
    }
    // CREATE

    @PostMapping
    public ResponseEntity<Void> putSessao(@Valid @RequestBody RequestPostSessao requestPostSessao) {
        Long idCriado = applicationService.criar(requestPostSessao);
        URI uri = URI.create("/api/v1/sessoes/" + idCriado);
        return ResponseEntity.created(uri).build();
    }

    // READ

    @GetMapping
    public List<SessaoResponse> getSessoes() {
        return applicationService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessaoResponse> getSessao(@PathVariable Long id) {
        Optional<SessaoResponse> sessaoResponse = applicationService.buscar(id);
        if (sessaoResponse.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(sessaoResponse.get());
    }

    // UPDATE

    @PutMapping("/{id}")
    public ResponseEntity<Void> putSessao(@PathVariable Long id, @Valid @RequestBody RequestPutSessao requestPutSessao) {
        try {
            applicationService.atualizarTotal(id, requestPutSessao);
            return ResponseEntity.noContent().build();
        } catch (RecursoNaoEncontrado ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSessao(@PathVariable Long id) {
        applicationService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
