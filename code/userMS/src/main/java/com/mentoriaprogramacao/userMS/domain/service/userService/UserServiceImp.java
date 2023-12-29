package com.mentoriaprogramacao.userMS.domain.service.userService;

import com.mentoriaprogramacao.userMS.adapter.dto.UpdatePasswordRequest;
import com.mentoriaprogramacao.userMS.domain.entity.UserEntity;
import com.mentoriaprogramacao.userMS.domain.service.exceptions.UserAlreadyExistsException;
import com.mentoriaprogramacao.userMS.domain.service.exceptions.UserNotFoundException;
import com.mentoriaprogramacao.userMS.domain.service.sequenceGenerator.SequenceGeneratorService;
import com.mentoriaprogramacao.userMS.port.outbound.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private UserRepository userRepository;

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

        user.setId(sequenceGeneratorService.generateSequence(UserEntity.SEQUENCE_NAME));

        return this.userRepository.save(user);

    }

    @Override
    public UserEntity getUserById(Long id){
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
    public UserEntity updateUser(Long id, UserEntity userRequest) {
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
    public void deleteUser(Long id) {
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
