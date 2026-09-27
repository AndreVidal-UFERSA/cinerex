package br.edu.ufersa.cinerex.features.sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SessaoRepository extends JpaRepository<Sessao, Long> {}
