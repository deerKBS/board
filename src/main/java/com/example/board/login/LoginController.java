package com.example.board.login;

import com.example.board.config.BaseException;
import com.example.board.login.dto.LoginRequest;
import com.example.board.login.dto.LoginResponse;
import com.example.board.login.service.LoginService;
import com.example.board.member.repository.entity.Member;
import com.example.board.util.ApiResult;
import com.example.board.util.Apiutils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping(value = "/login")
    public ApiResult<?> login(@RequestBody LoginRequest loginRequest){
        try{
            Member member = loginService.login(loginRequest.getMemberId(), loginRequest.getPassword());
            return Apiutils.success(new LoginResponse(member.getId(), member.getName()));
        }catch(BaseException e){
            throw new BaseException(e.getApiError());
        }
    }
}
