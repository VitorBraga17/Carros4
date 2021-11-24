package br.com.sevencomm.carros4.data.repositories;

import br.com.sevencomm.carros4.domain.models.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroRepository extends JpaRepository<Registro,Long> {
}
