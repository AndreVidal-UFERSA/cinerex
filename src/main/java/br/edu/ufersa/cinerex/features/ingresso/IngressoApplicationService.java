package br.edu.ufersa.cinerex.features.ingresso;

import br.edu.ufersa.cinerex.features.ingresso.dto.IngressoCreate;
import br.edu.ufersa.cinerex.features.ingresso.dto.IngressoResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class IngressoApplicationService {
        private final IngressoRepository repository;
        private final IngressoMapper mapper;

        public IngressoApplicationService(IngressoRepository repository, IngressoMapper mapper) {
            this.repository = repository;
            this.mapper = mapper;
        }

        public Long criar(IngressoCreate ingressoCreate) {
            Ingresso ingresso = mapper.toEntity(ingressoCreate);
            Ingresso criado = repository.save(ingresso);
            return criado.getId();
        }

        public List<IngressoResponse> listar() {
            return repository.findAll().stream().map(mapper::toResponse).toList();
        }

        public Optional<IngressoResponse> encontrar(long id) {
            return repository.findById(id).map(mapper::toResponse);
        }
}
