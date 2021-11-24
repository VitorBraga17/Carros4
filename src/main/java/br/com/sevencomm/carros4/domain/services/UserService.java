package br.com.sevencomm.carros4.domain.services;

import br.com.sevencomm.carros4.api.DTOs.SignUpDTO;
import br.com.sevencomm.carros4.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> listUsers();
    Optional<User> findUserById(Long id);
    User signUp(SignUpDTO signUp);
}
