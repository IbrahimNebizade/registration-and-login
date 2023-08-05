package com.company.service.impl;

import com.company.DTO.*;
import com.company.DTO.Page;
import com.company.mapper.UserMapper;
import com.company.model.User;
import com.company.repository.UserRepository;
import com.company.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;
    private final UserMapper userMapper;



    @Override
    public CreateUserResponse createUser(CreateUserCommand command) {
        log.info("ActionLog.UserServiceImpl.createUser.start - command: {}", command);
        userRepo.findByNickName(command.getNickName()).ifPresent(user -> {
            throw new RuntimeException("user already exist");
        });
        var user = UserMapper.INSTANCE.userCommandToUser(command);
        userRepo.save(user);
        log.info("ActionLog.UserServiceImpl.createUser.end - command: {}", command);
        return userMapper.userToUserResponse(user);
    }

    @Override
    public void deleteUser(Long userId) {
        log.info("ActionLog.{}.UserServiceImpl.deleteUser.start - userId: {}", getClass().getSimpleName(),userId);
        log.info("ActionLog.{}.UserServiceImpl.deleteUser.end - userId: {}", getClass().getSimpleName(),userId);
        userRepo.deleteById(userId);
    }

    @Override
    public void deleteUser(String nickName) {
        userRepo.deleteByNickName(nickName);
    }

    @Override
    public FindUserResponse findUserById(Long id) {
        log.info("ActionLog.{}.UserServiceImpl.findUserById.start - userId: {}", getClass().getSimpleName(),id);
        var user= userRepo.findById(id).orElseThrow();
        log.info("ActionLog.{}.UserServiceImpl.findUserById.end - userId: {}", getClass().getSimpleName(),id);
        return FindUserResponse.builder()
                .userId(user.getId())
                .build();
    }

    @Override
    public FindUserResponse findUserByNickname(String nickname) {
       var user= userRepo.findByNickName(nickname).orElseThrow();
        return FindUserResponse.builder()
                .userId(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .age(user.getAge())
                .phoneNumber(user.getPhoneNumber())
                .birthDate(user.getBirthdate())
                .nickName(user.getNickName())
                .build();
    }

    @Override
    public UpdateUserResponse updateUser(Long id,UpdateUserCommand command) {

        userRepo.findById(id).ifPresent(user -> {
            user.setName(command.getName());
            user.setSurname(command.getSurname());
            user.setNickName(command.getNickName());
            user.setBirthdate(command.getBirthDate());
            user.setPhoneNumber(command.getPhoneNumber());
            user.setAge(command.getAge());
            userRepo.save(user);
        });
       var user=userMapper.userUpdateCommandToUser(command);
        return  UpdateUserResponse.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .age(user.getAge())
                .phoneNumber(user.getPhoneNumber())
                .birthDate(user.getBirthdate())
                .nickName(user.getNickName())
                .build();
    }
    @Override
    public Page<List<User>> getAllUsers(Pageable pageable) {
        log.info("ActionLog.UserServiceImpl.getAllUsers.start - page: {}, size:{}", pageable.getPageNumber(), pageable.getPageSize());
        var userEntityPage = userRepo.findAll(pageable);
        log.info("ActionLog.UserServiceImpl.getAllUsers.end - page: {}, size:{}", pageable.getPageNumber(), pageable.getPageSize());
        return new Page<>(
                userEntityPage.getContent(),
                userEntityPage.getPageable().getPageNumber(),
                userEntityPage.getTotalPages(),
                userEntityPage.hasNext()
        );
    }
}
