package br.com.sevencomm.carros4.data.repositories;

import br.com.sevencomm.carros4.domain.models.EntradaSaida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntradaSaidaRepository extends JpaRepository<EntradaSaida,Long> {
}
