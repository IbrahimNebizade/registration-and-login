package com.company.config.DTOConfig;

import com.company.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserMapperConfig {
    @Bean
    public UserMapper userMapper(){
        return UserMapper.INSTANCE;
    }
}
