package br.com.sevencomm.carros4.data.repositories;

import br.com.sevencomm.carros4.domain.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    Optional<Cliente> findById(Long id);
    void delete(Cliente cliente);
}
