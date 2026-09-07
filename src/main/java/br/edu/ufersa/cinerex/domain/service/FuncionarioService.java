package br.edu.ufersa.cinerex.domain.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.ufersa.cinerex.domain.entity.Funcionario;
import br.edu.ufersa.cinerex.domain.exception.FuncionarioJaExisteException;
import br.edu.ufersa.cinerex.domain.exception.FuncionarioNaoExisteException;
import br.edu.ufersa.cinerex.domain.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    // CREATE
    public Funcionario criarFuncionario(String cpf, String nome, String login, String senha, BigDecimal salario) {
        Funcionario novoFuncionario = new Funcionario(cpf, nome, login, senha, salario);
        if (funcionarioRepository.existsByCpf(cpf))
            throw new FuncionarioJaExisteException("Funcionario com CPF fornecido ja existe");
        if (funcionarioRepository.existsByLogin(login))
            throw new FuncionarioJaExisteException("Funcionario com login fornecido ja existe");
        return funcionarioRepository.save(novoFuncionario);
    }

    // READ
    public List<Funcionario> listar() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> buscarPorId(Long id) {
        Objects.requireNonNull(id, "ID nao pode ser null");
        return funcionarioRepository.findById(id);
    }

    // UPDATE
    public Funcionario atualizarFuncionario(Long id, String cpf, String nome, String login, String senha, BigDecimal salario) {
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
        Optional<Funcionario> funcionarioComCpf = funcionarioRepository.findByCpf(cpf);
        Optional<Funcionario> funcionarioComLogin = funcionarioRepository.findByLogin(login);
        if (funcionarioOptional.isEmpty())
            throw new FuncionarioNaoExisteException("Funcionario com ID fornecido nao existe");
        if (funcionarioComCpf.isPresent() && !funcionarioComCpf.get().getId().equals(id))
            throw new FuncionarioJaExisteException("Funcionario com CPF fornecido ja existe");
        if (funcionarioComLogin.isPresent() && !funcionarioComLogin.get().getId().equals(id))
            throw new FuncionarioJaExisteException("Funcionario com Login fornecido ja existe");
        Funcionario funcionario = funcionarioOptional.get();
        funcionario.alterarCpf(cpf);
        funcionario.alterarNome(nome);
        funcionario.alterarLogin(login);
        funcionario.alterarSenha(senha);
        funcionario.alterarSalario(salario);
        return funcionarioRepository.save(funcionario);
    }

    // DELETE
    public void deletarPorId(Long id) {
        Objects.requireNonNull(id, "ID nao pode ser null");
        if (!funcionarioRepository.existsById(id))
            throw new FuncionarioNaoExisteException("Funcionario com ID fornecido nao existe");
        funcionarioRepository.deleteById(id);
    }
}
