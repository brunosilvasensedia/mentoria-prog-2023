package com.mentoriaprogramacao.taskMS.port.inbound.repository;

import com.mentoriaprogramacao.taskMS.domain.entity.ListTasksEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ListTasksRepository extends MongoRepository<ListTasksEntity, Integer> {
}
