package br.edu.ufersa.cinerex.features.funcionario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Funcionario findByLogin(String login);
    boolean existsByCpfOrLogin(String cpf, String login);
}
