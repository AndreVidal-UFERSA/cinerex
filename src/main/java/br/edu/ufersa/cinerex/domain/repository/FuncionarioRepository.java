package br.edu.ufersa.cinerex.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufersa.cinerex.domain.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    boolean existsByLogin(String login);
    boolean existsByCpf(String cpf);
    Optional<Funcionario> findByCpf(String cpf);
    Optional<Funcionario> findByLogin(String login);
}
