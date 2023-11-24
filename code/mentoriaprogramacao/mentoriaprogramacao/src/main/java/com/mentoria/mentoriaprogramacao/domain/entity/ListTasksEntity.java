package com.mentoria.mentoriaprogramacao.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("listsTasks")
public class ListTasksEntity {

    @Id
    private Integer id;
    private String name;
    private boolean deleted;
}
