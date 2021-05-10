package com.example.spare_parts.controller;

import com.example.spare_parts.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.spare_parts.service.UserService;
import com.example.spare_parts.entity.UserEntity;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;


    @GetMapping(value = "/users")
    public List<UserEntity> getUser() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public UserEntity fetchUserById(@PathVariable("id")Integer id){
        return userService.findUserById(id);
    }

    @PostMapping("/user/{id}")
    public UserEntity updateUserById(@PathVariable("id")Integer id, @RequestBody @Validated UserEntity userEntity){
        return userService.addNewUser(userEntity);
    }

    @PostMapping(value="/user/create", consumes = "application/json", produces =MediaType.APPLICATION_JSON_VALUE)
    public UserEntity createUser(@RequestBody @Validated UserEntity userEntity){
        return userService.addNewUser(userEntity);
    }
//
    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable(name = "userId")Integer id){
        userService.deleteUser(id);
    }


}
