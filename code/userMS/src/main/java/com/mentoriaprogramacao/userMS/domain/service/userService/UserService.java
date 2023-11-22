package com.mentoriaprogramacao.userMS.domain.service.userService;

import com.mentoriaprogramacao.userMS.adapter.dto.UpdatePasswordRequest;
import com.mentoriaprogramacao.userMS.domain.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> getAllUsers();
    UserEntity getUser(String email);
    UserEntity saveUser(UserEntity user);
    UserEntity getUserById(String id);

    UserEntity getUserByEmail(String name);

    UserEntity updateUser(String id, UserEntity user);

    void deleteUser(String id);

    UserEntity updatePassword(String email, UpdatePasswordRequest request);
}
