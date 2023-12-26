package com.mentoriaprogramacao.userMS.domain.service.userService;

import com.mentoriaprogramacao.userMS.adapter.dto.UpdatePasswordRequest;
import com.mentoriaprogramacao.userMS.domain.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> getAllUsers();
    UserEntity getUser(String email);
    UserEntity saveUser(UserEntity user);
    UserEntity getUserById(Long id);

    UserEntity getUserByEmail(String name);

    UserEntity updateUser(Long id, UserEntity user);

    void deleteUser(Long id);

    UserEntity updatePassword(String email, UpdatePasswordRequest request);
}
