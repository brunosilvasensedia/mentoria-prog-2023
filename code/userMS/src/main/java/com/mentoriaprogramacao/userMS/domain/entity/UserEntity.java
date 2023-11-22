package com.mentoriaprogramacao.userMS.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "users")
public class UserEntity {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
}
