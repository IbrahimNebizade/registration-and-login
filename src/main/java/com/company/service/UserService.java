package com.company.service;

import com.company.DTO.*;
import com.company.model.User;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface UserService {
    CreateUserResponse createUser(CreateUserCommand command);
    void deleteUser(Long userId);
    void deleteUser(String nickName);
    FindUserResponse findUserById(Long id);

    FindUserResponse findUserByNickname(String nickname);
    UpdateUserResponse updateUser(Long id,UpdateUserCommand command);
    Page<List<User>> getAllUsers(Pageable pageable);

}
