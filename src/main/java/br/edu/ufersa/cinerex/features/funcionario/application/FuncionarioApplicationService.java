package br.edu.ufersa.cinerex.features.funcionario.application;

import br.edu.ufersa.cinerex.features.funcionario.domain.Funcionario;
import br.edu.ufersa.cinerex.features.funcionario.domain.FuncionarioRepository;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioApplicationService {
    private final FuncionarioRepository repository;
    private final FuncionarioMapper mapper;

    public FuncionarioApplicationService(FuncionarioRepository repository, FuncionarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Long criar(CriarFuncionarioCommand criarFuncionarioCommand) {
        Funcionario funcionario = mapper.toEntity(criarFuncionarioCommand);
        Funcionario criado = repository.save(funcionario);
        return criado.getId();
    }
}
