package com.mentoriaprogramacao.taskMS.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("listsTasks")
public class ListTasksEntity {

    @Transient
    public static final String SEQUENCE_NAME = "list_task_sequence";

    @Id
    private long id;
    private String name;
    private boolean deleted;
    @DBRef
    private List<TaskEntity> listTask;
}
