package br.edu.ufersa.cinerex.features.funcionario;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class FuncionarioApplicationService {
    private final FuncionarioRepository repository;
    private final FuncionarioApplicationMapper mapper;

    public FuncionarioApplicationService(FuncionarioRepository repository, FuncionarioApplicationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Long criar(CriarFuncionarioCommand criarFuncionarioCommand) {
        Funcionario funcionario = mapper.toEntity(criarFuncionarioCommand);
        Funcionario criado = repository.save(funcionario);
        return criado.getId();
    }

    public List<FuncionarioResponse> listar() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public Optional<FuncionarioResponse> encontrar(long id) {
        return repository.findById(id).map(mapper::toResponse);
    }
}
