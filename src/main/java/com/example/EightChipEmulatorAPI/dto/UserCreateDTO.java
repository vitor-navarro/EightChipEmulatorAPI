package com.example.EightChipEmulatorAPI.dto;

import com.example.EightChipEmulatorAPI.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.BeanUtils;

public class UserCreateDTO {
    @JsonProperty("id")
    public Integer id;

    @JsonProperty("username")
    @NotNull
    @NotBlank
    public String username;


    @JsonProperty("password")
    @Size(message = "Password should be longer than 7 caracters", min = 7)
    @NotNull
    public String password;


    @JsonProperty("email")
    @Email(message = "Email should be valid")
    public String email;

    public UserCreateDTO(){}

    public UserCreateDTO(UserEntity user){
        BeanUtils.copyProperties(user, this);
    }
}
