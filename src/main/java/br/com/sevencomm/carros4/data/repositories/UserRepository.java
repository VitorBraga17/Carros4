package br.com.sevencomm.carros4.data.repositories;

import br.com.sevencomm.carros4.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findById(Long id);
    Optional<User> findByNome(String nome);
    Optional<User> findByLogin(String login);
    Optional<User> findByEmail(String email);

}
