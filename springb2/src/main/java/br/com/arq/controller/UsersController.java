package br.com.arq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.arq.model.Users;
import br.com.arq.repository.UsersRepository;

@ResponseBody
@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody Users user) {
        try {
            Users resultadoGravacao = usersRepository.save(user);
            return ResponseEntity.status(200).body(resultadoGravacao);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("error :" + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(200).body(usersRepository.findAll());
    }

}


// api