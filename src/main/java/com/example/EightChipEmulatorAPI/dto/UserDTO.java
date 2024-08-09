package com.example.EightChipEmulatorAPI.dto;

import com.example.EightChipEmulatorAPI.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDTO {

    @JsonProperty("id")
    public Integer id;

    @JsonProperty("username")
    @NotNull
    @NotBlank
    public String username;

    @JsonProperty("email")
    @Email(message = "Email should be valid")
    public String email;

    public UserDTO(){}

    public UserDTO(UserEntity user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }

}

