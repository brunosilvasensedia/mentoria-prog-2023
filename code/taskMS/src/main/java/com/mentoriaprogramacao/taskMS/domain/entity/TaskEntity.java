package com.mentoriaprogramacao.taskMS.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("tasks")
public class TaskEntity {

    @Id
    private Integer id;
    private String title, description;
    private LocalDate due_date;
    private boolean completed, deleted;
}
