package africa.semicolon.mogbo.controller;

import africa.semicolon.mogbo.Services.UserServices;
import africa.semicolon.mogbo.Services.UserServicesImpl;
import africa.semicolon.mogbo.dto.Requests.LoginRequestDto;
import africa.semicolon.mogbo.dto.Requests.RegisterUserRequest;
import africa.semicolon.mogbo.dto.Response.ApiResponse;
import africa.semicolon.mogbo.dto.Response.LoginUserResponse;
import africa.semicolon.mogbo.dto.Response.RegisterUserResponse;
import africa.semicolon.mogbo.dto.exceptions.DuplicateEmailException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserServices userServices;

    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequest registerUserRequest){
       try {
           var serviceResponse = userServices.registerUser(registerUserRequest);
           ApiResponse response = new ApiResponse(true,serviceResponse);
           return new ResponseEntity<>(response, HttpStatus.CREATED);
       }
       catch (DuplicateEmailException ex){
           ApiResponse response = new ApiResponse(false,ex.getMessage());
           return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
       }
    }

    @PostMapping("/login")
    public LoginUserResponse loginUser(@RequestBody LoginRequestDto loginRequestDto){
        return userServices.loginUser(loginRequestDto);
    }

}
