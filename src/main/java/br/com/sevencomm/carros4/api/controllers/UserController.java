package br.com.sevencomm.carros4.api.controllers;


import br.com.sevencomm.carros4.api.DTOs.SignUpDTO;
import br.com.sevencomm.carros4.domain.models.User;
import br.com.sevencomm.carros4.domain.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService _userService;

    public UserController(UserService userService){
        _userService = userService;
    }

    @GetMapping("/findUserById")
    public ResponseEntity findUserById(@RequestParam Long id){
        Optional<User> user = _userService.findUserById(id);
        try {
            return ResponseEntity.ok(user);
        }catch (Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/listUsers")
    public ResponseEntity listUsers(){
        List<User> users = _userService.listUsers();

        return ResponseEntity.ok(users);
    }

    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestBody SignUpDTO signUp){
        try {
            return ResponseEntity.ok(_userService.signUp(signUp));
        }catch (Exception ex){
            return  ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
