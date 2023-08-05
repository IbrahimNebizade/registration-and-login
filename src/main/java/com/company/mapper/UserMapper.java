package com.company.mapper;

import com.company.DTO.CreateUserCommand;
import com.company.DTO.CreateUserResponse;
import com.company.DTO.UpdateUserCommand;
import com.company.DTO.UpdateUserResponse;
import com.company.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public  interface UserMapper  {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

//    @Mapping(target = "id",ignore = true)
//    @Mapping(target = "name" ,source = "name")
//    @Mapping(target = "surname",source = "surname")
//    @Mapping(target = "nickName",source = "nickName")
//    @Mapping(target = "age",source = "age")
//    @Mapping(target = "phoneNumber",source = "phoneNumber")
//    @Mapping(target = "birthdate",source = "birthDate")
//    @Mapping(target = "createTime",source = "createTime")
       User userCommandToUser(CreateUserCommand command);
       CreateUserResponse userToUserResponse(User user);
       UpdateUserResponse userToUserUpdateResponse(User user);
       User userUpdateCommandToUser(UpdateUserCommand command);

}
