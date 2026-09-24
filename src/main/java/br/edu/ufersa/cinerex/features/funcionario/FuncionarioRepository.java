package br.edu.ufersa.cinerex.features.funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
