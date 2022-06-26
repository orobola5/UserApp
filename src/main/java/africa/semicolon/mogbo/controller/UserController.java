package africa.semicolon.mogbo.controller;

import africa.semicolon.mogbo.Services.UserServices;
import africa.semicolon.mogbo.dto.Requests.LoginRequestDto;
import africa.semicolon.mogbo.dto.Requests.RegisterUserRequest;
import africa.semicolon.mogbo.dto.Response.LoginUserResponse;
import africa.semicolon.mogbo.dto.Response.RegisterUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserServices userServices;

    @PostMapping("/user")
    public RegisterUserResponse register(@RequestBody RegisterUserRequest registerUserRequest){
        return userServices.registerUser(registerUserRequest);
    }

    @PostMapping("/login")
    public LoginUserResponse loginuser(@RequestBody LoginRequestDto loginRequestDto){
        return userServices.loginUser(loginRequestDto);
    }

}
