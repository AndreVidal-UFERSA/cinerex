package br.edu.ufersa.cinerex.features.ingresso;

import br.edu.ufersa.cinerex.features.funcionario.CriarFuncionarioCommand;
import br.edu.ufersa.cinerex.features.ingresso.dto.IngressoCreate;
import br.edu.ufersa.cinerex.features.ingresso.dto.IngressoResponse;
import br.edu.ufersa.cinerex.features.sessao.SessaoQuery;
import br.edu.ufersa.cinerex.shared.exceptions.SessaoInexistente;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/ingresso")
class IngressoController {

    private final SessaoQuery sessaoQuery;
    private final IngressoRepository ingressoRepository;

    public IngressoController(SessaoQuery sessaoQuery, IngressoRepository ingressoRepository){
        this.sessaoQuery = sessaoQuery;
        this.ingressoRepository = ingressoRepository;
    }

    //CREATE
    @PostMapping
    public ResponseEntity<IngressoResponse> criar(
            @PathVariable Long userId,
            @RequestBody IngressoCreate dto,
            UriComponentsBuilder uriBuilder) {
        var resultado = sessaoQuery.buscar(1);
        if (resultado.isPresent()) {
            var sessao = resultado.get();
        } else {
            throw new SessaoInexistente("A sessão é inexistente");
        }
        return ResponseEntity.created(uri).body(TodoResponse.fromEntity(salvo));
    }

    // READ
    @GetMapping
    public ResponseEntity<List<IngressoResponse>> getIngresso(@PathVariable Long userId) {
        Ingresso ingresso = new Ingresso();

        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getIngresso(@PathVariable Long id) {
        // TODO: Implementar a busca de ingresso por ID
        return null;
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Void> putIngresso(@PathVariable Long id, @RequestBody Object putIngressoRequest) {
        // TODO: Implementar a atualização de ingresso
        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngresso(@PathVariable Long id) {
        // TODO: Implementar a deleção de ingresso
        return null;
    }
}


