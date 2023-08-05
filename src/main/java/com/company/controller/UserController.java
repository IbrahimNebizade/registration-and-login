package com.company.controller;

import com.company.DTO.*;
import com.company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/user")
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/create")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserCommand command){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(command));
    }
    @GetMapping(value = "/find/{nickName}")
    public ResponseEntity<FindUserResponse> findUserByNickName(@PathVariable String nickName){
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.findUserByNickname(nickName));
    }
    @DeleteMapping(value = "/delete/{nickName}")
    public void deleteUserByNickName(@PathVariable String nickName){
              userService.deleteUser(nickName);
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<UpdateUserResponse> updateUser(@PathVariable Long id,@RequestBody UpdateUserCommand command){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id,command));
    }
}
