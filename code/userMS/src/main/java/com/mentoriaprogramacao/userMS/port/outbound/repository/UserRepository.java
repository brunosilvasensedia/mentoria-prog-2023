package com.mentoriaprogramacao.userMS.port.outbound.repository;

import com.mentoriaprogramacao.userMS.domain.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, Long> {

    UserEntity findFirstByEmailIgnoreCase(String email);

    boolean existsByEmail(String email);
}
