package com.example.board.member.controller;

import com.example.board.config.BaseException;
import com.example.board.member.dto.LoginRequest;
import com.example.board.member.dto.LoginResponse;
import com.example.board.member.service.LoginService;
import com.example.board.member.repository.entity.Member;
import com.example.board.util.ApiResult;
import com.example.board.util.Apiutils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping(value = "/login")
    public ApiResult<?> login(@RequestBody LoginRequest loginRequest){
        try{
            Member member = loginService.login(loginRequest);
            return Apiutils.success(new LoginResponse(member.getId(), member.getName()));
        }catch(BaseException e){
            throw new BaseException(e.getApiError());
        }
    }
}
