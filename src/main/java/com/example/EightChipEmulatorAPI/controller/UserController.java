package com.example.EightChipEmulatorAPI.controller;

import com.example.EightChipEmulatorAPI.dto.UserCreateDTO;
import com.example.EightChipEmulatorAPI.dto.UserDTO;
import com.example.EightChipEmulatorAPI.entity.UserEntity;
import com.example.EightChipEmulatorAPI.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public UserDTO getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "", produces = "application/json")
    public List<UserDTO> geAllUsers(){
        System.out.println("aa");
        return userService.getAllUsers();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity createUser(@Valid @RequestBody UserCreateDTO user) {
        return userService.createUser(user);
    }
    
    @PutMapping(path = "/update")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO updateUser(@Valid @RequestBody UserDTO user){
        return userService.updateUser(user);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Void> deleteUserById(@RequestBody Map<String, Integer> payload){
        Integer id = payload.get("id");
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
}
