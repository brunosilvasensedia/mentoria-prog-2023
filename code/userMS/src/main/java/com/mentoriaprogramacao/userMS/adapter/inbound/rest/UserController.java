package com.mentoriaprogramacao.userMS.adapter.inbound.rest;


import com.mentoriaprogramacao.userMS.adapter.dto.UpdatePasswordRequest;
import com.mentoriaprogramacao.userMS.domain.entity.UserEntity;
import com.mentoriaprogramacao.userMS.domain.service.userService.UserService;
import com.mentoriaprogramacao.userMS.port.inbound.rest.UserOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "user-ms/v1/user",  produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController implements UserOperations {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<List<UserEntity>> findAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @Override
    public ResponseEntity<UserEntity> findUserById(Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    @Override
    public ResponseEntity<UserEntity> findUserByEmail(String email) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByEmail(email));
    }

    @Override
    public ResponseEntity<UserEntity> saveUser(UserEntity user) {
        UserEntity newUser = userService.saveUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).body(newUser);
    }

    @Override
    public ResponseEntity<UserEntity> updateUser(Long id, UserEntity user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id, user));
    }

    @Override
    public ResponseEntity<UserEntity> updatePassword(String email, UpdatePasswordRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updatePassword(email, request));
    }

    @Override
    public ResponseEntity<Void> removeUser(Long id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
