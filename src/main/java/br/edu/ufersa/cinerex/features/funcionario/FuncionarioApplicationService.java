package br.edu.ufersa.cinerex.features.funcionario;

import br.edu.ufersa.cinerex.features.funcionario.dto.FuncionarioResponse;
import br.edu.ufersa.cinerex.features.funcionario.dto.RequestPostFuncionario;
import br.edu.ufersa.cinerex.features.funcionario.dto.RequestPutFuncionario;
import br.edu.ufersa.cinerex.shared.exceptions.RecursoNaoEncontrado;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class FuncionarioApplicationService {
    private final FuncionarioRepository repository;
    private final FuncionarioMapper mapper;

    public FuncionarioApplicationService(FuncionarioRepository repository, FuncionarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Long criar(RequestPostFuncionario requestPostFuncionario) {
        Funcionario funcionario = mapper.toEntity(requestPostFuncionario);
        Funcionario criado = repository.save(funcionario);
        return criado.getId();
    }

    public List<FuncionarioResponse> listar() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public Optional<FuncionarioResponse> encontrar(long id) {
        return repository.findById(id).map(mapper::toResponse);
    }

    public void atualizarTotal(long id, RequestPutFuncionario mudancas) {
        Optional<Funcionario> funcionarioOptional = repository.findById(id);
        if (funcionarioOptional.isEmpty())
            throw new RecursoNaoEncontrado("Funcionario com id " + id + " nao encontrado");
        Funcionario funcionario = funcionarioOptional.get();
        funcionario.alterarNome(mudancas.nome());
        funcionario.alterarLogin(mudancas.login());
        funcionario.alterarSenha(mudancas.senha());
        funcionario.alterarSalario(mudancas.salario());
        repository.save(funcionario);
    }

    public void removerFuncionario(long id) {
        Optional<Funcionario> funcionarioOptional = repository.findById(id);
        if (funcionarioOptional.isEmpty())
            throw new RecursoNaoEncontrado("Funcionario com id " + id + " nao encontrado");
        repository.deleteById(id);
    }
}
