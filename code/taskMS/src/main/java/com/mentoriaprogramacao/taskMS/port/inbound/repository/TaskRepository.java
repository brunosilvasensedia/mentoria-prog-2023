package com.mentoriaprogramacao.taskMS.port.inbound.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mentoriaprogramacao.taskMS.domain.entity.TaskEntity;

public interface TaskRepository extends MongoRepository<TaskEntity, Long>{
    
}
