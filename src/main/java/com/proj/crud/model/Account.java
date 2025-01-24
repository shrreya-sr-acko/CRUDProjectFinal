package com.proj.crud.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    private String id;
    
    @Indexed(unique = true)
    @NotBlank(message = "Username is mandatory")
    private String username;


    @NotNull(message = "Password is mandatory")
    private String password;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Indexed(unique = true)
    @NotNull(message = "User ID is mandatory")
    private int userId;
}
