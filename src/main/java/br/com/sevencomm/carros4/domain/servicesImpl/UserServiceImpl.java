package br.com.sevencomm.carros4.domain.servicesImpl;

import br.com.sevencomm.carros4.api.DTOs.SignUpDTO;
import br.com.sevencomm.carros4.data.repositories.UserRepository;
import br.com.sevencomm.carros4.domain.models.User;
import br.com.sevencomm.carros4.domain.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository _userRepository;

    public UserServiceImpl(UserRepository userRepository){
        _userRepository = userRepository;
    }

    public List<User> listUsers() {
        return _userRepository.findAll();
    }

    public Optional<User> findUserById(Long id) {
        Optional<User> user = _userRepository.findById(id);
        if(user.isPresent())
            return user;
        else
            throw new IllegalArgumentException("User Not Found!");
    }

    public User signUp(SignUpDTO signUp) {
        User newUser = new User();
        Optional<User> userExists;

        if(signUp.getLogin().equals("") || signUp.getLogin() == null)
            throw new IllegalArgumentException("Login field is Empty");
        if(signUp.getNome().equals("") || signUp.getNome() == null)
            throw new IllegalArgumentException("Name field is Empty");
        if(signUp.getEmail().equals("") || signUp.getEmail() == null)
            throw new IllegalArgumentException("Email field is Empty");

        userExists = _userRepository.findByLogin(signUp.getLogin());
        if(userExists.isPresent())
            throw new IllegalArgumentException("Login already Exists");
        userExists = _userRepository.findByNome(signUp.getNome());
        if(userExists.isPresent())
            throw new IllegalArgumentException("Nome already Exists");
        userExists = _userRepository.findByEmail(signUp.getEmail());
        if(userExists.isPresent())
            throw new IllegalArgumentException("Email already Exists");


        newUser.setLogin(signUp.getLogin());
        newUser.setSenha(signUp.getSenha());
        newUser.setNome(signUp.getNome());
        newUser.setEmail(signUp.getEmail());

        return _userRepository.save(newUser);
    }
}
