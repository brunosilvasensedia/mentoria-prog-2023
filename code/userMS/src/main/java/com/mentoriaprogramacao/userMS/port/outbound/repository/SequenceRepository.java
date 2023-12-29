package com.mentoriaprogramacao.userMS.port.outbound.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mentoriaprogramacao.userMS.domain.entity.DatabaseSequence;

@Repository
public interface SequenceRepository extends MongoRepository<DatabaseSequence, String>{
    
}
