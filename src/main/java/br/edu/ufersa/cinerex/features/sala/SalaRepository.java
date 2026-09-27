package br.edu.ufersa.cinerex.features.sala;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SalaRepository extends JpaRepository<Sala, Long>{
    boolean existsByNumero(Integer numero);
}
