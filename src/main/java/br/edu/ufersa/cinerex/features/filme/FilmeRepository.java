package br.edu.ufersa.cinerex.features.filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface FilmeRepository extends JpaRepository<Filme, Long> {
}

