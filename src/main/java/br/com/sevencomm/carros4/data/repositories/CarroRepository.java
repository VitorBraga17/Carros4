package br.com.sevencomm.carros4.data.repositories;

import br.com.sevencomm.carros4.domain.models.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarroRepository  extends JpaRepository<Carro, Long> {
    Optional<Carro> findById(Long id);
}
