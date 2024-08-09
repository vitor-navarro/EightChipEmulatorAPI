package com.example.EightChipEmulatorAPI.service;

import com.example.EightChipEmulatorAPI.dto.UserCreateDTO;
import com.example.EightChipEmulatorAPI.dto.UserDTO;
import com.example.EightChipEmulatorAPI.entity.UserEntity;
import com.example.EightChipEmulatorAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//TODO serviço de mudança e recuperação de senha
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(UserCreateDTO user) {
        UserEntity userEntity = new UserEntity(user);

        return userRepository.save(userEntity);
    }

    public UserDTO getUser(Integer id) {
        if(userRepository.findById(id).isPresent()){
            UserEntity userEntity = userRepository.findById(id).get();
            return new UserDTO(userEntity);
        }
        return new UserDTO();
    }

    public List<UserDTO> getAllUsers(){
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(UserDTO::new).toList();
    }

    public UserDTO updateUser(UserDTO user){
        UserEntity userEntity = userRepository.findById(user.getId()).get();

        userEntity.setUsername(user.getUsername());
        userEntity.setEmail(user.getEmail());

        return new UserDTO(userRepository.save(userEntity));
    }

    public void deleteUserById(Integer id){
        UserEntity userEntity = userRepository.findById(id).get();
        userRepository.delete(userEntity);
    }
}
