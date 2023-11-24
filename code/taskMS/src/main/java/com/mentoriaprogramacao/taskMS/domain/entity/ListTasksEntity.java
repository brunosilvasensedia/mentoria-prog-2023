package com.mentoriaprogramacao.taskMS.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("listsTasks")
public class ListTasksEntity {

    @Id
    private Integer id;
    private String name;
    private boolean deleted;
}
