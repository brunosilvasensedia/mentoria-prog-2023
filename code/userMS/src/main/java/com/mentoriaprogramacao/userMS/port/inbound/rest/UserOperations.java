package com.mentoriaprogramacao.userMS.port.inbound.rest;

import com.mentoriaprogramacao.userMS.adapter.dto.UpdatePasswordRequest;
import com.mentoriaprogramacao.userMS.domain.entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/default")
public interface UserOperations {

    @GetMapping()
    ResponseEntity<List<UserEntity>> findAllUsers();

    @GetMapping("/{id}")
    ResponseEntity<UserEntity> findUserById(@PathVariable("id") String id) throws Exception;

    @GetMapping("/email/{email}")
    ResponseEntity<UserEntity> findUserByEmail(@PathVariable("email") String email);

    @PostMapping
    ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user);

    @PutMapping("/{id}")
    ResponseEntity<UserEntity> updateUser(@PathVariable("id") String id, @RequestBody UserEntity user);

    @PatchMapping("email/{email}/update-password")
    ResponseEntity<UserEntity> updatePassword(@PathVariable("email") String email, @RequestBody UpdatePasswordRequest request);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> removeUser(@PathVariable("id") String id) throws Exception;
}
