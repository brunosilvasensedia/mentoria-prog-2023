package com.mentoriaprogramacao.taskMS.adapter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="listTask")
public class ListTaskRequest {

    @Id
    private String id;
    private String name;
    private boolean deleted;

}
