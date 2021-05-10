package com.example.spare_parts.service;

import com.example.spare_parts.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.spare_parts.repository.UserRepository;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public UserEntity getUser(Integer userId) {

        return userRepository.findById(userId).get();
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    public UserEntity findUserById(Integer id){
        return userRepository.findById(id).orElseThrow(null);   }


    public UserEntity addNewUser (UserEntity newUser){
        return userRepository.save(newUser);
    }
}
