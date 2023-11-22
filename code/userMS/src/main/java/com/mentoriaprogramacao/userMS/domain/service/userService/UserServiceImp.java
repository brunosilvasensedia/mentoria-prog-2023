package com.mentoriaprogramacao.userMS.domain.service.userService;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mentoriaprogramacao.userMS.adapter.dto.UpdatePasswordRequest;
import com.mentoriaprogramacao.userMS.domain.entity.UserEntity;
import com.mentoriaprogramacao.userMS.domain.service.exceptions.UserAlreadyExistsException;
import com.mentoriaprogramacao.userMS.domain.service.exceptions.UserNotFoundException;
import com.mentoriaprogramacao.userMS.port.outbound.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class UserServiceImp implements UserService{

    private List<UserEntity> users;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void loadMockData() {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("users.json");

        try {
            users = objectMapper.readValue(inputStream, new TypeReference<List<UserEntity>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public UserEntity getUser(String email) {
        return null;
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserAlreadyExistsException();
        }

        user.setId(new String(UUID.randomUUID().toString()));

        return this.userRepository.save(user);

    }

    @Override
    public UserEntity getUserById(String id){
        Optional<UserEntity> userEntity = this.userRepository.findById(id);
        return userEntity.orElseThrow(() -> new UserNotFoundException());
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        UserEntity user =  this.userRepository.findFirstByEmailIgnoreCase(email);
        if(user == null) {
            throw new UserNotFoundException();
        }

        return user;
    }

    @Override
    public UserEntity updateUser(String id, UserEntity userRequest) {
        Optional<UserEntity> userEntity = this.userRepository.findById(id);

        if(userEntity.isPresent()) {
            UserEntity user = userEntity.get();
            updateData(user, userRequest);
            return this.userRepository.save(user);
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public void deleteUser(String id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public UserEntity updatePassword(String email, UpdatePasswordRequest request) {
        UserEntity user = this.userRepository.findFirstByEmailIgnoreCase(email);

        if(user == null) {
            throw new UserNotFoundException();
        } else {
            user.setPassword(request.getPassword());
            this.userRepository.save(user);
        }

        return user;
    }

    private void updateData(UserEntity user, UserEntity userRequest) {
        user.setEmail(userRequest.getEmail());
        user.setName(userRequest.getEmail());
    }
}
