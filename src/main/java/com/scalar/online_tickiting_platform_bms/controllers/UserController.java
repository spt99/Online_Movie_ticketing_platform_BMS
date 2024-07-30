package com.scalar.online_tickiting_platform_bms.controllers;

import com.scalar.online_tickiting_platform_bms.dtos.SignUpRequestDto;
import com.scalar.online_tickiting_platform_bms.dtos.SignUpResponseDto;
import com.scalar.online_tickiting_platform_bms.models.ResponseStatus;
import com.scalar.online_tickiting_platform_bms.models.User;
import com.scalar.online_tickiting_platform_bms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;
    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }
    public SignUpResponseDto SignUp(SignUpRequestDto signUpRequestDto) {
        User user;
        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
        try{
            user = userService.SignUp(signUpRequestDto.getEmail(), signUpRequestDto.getPassword());
            signUpResponseDto.setStatus(ResponseStatus.SUCCESS);
            signUpResponseDto.setUserId(user.getId());
        }
        catch(Exception e)
        {
            signUpResponseDto.setStatus(ResponseStatus.FAILURE);
            signUpResponseDto.setUserId(-1L);
        }

        return signUpResponseDto;
    }
}
