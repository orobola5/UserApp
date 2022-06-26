//package africa.semicolon.mogbo.Services;
//
//import africa.semicolon.mogbo.dto.Requests.LoginRequestDto;
//import africa.semicolon.mogbo.dto.Requests.RegisterUserRequest;
//import africa.semicolon.mogbo.dto.Response.LoginUserResponse;
//import africa.semicolon.mogbo.dto.Response.RegisterUserResponse;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class UserServicesTest {
//
//    @Autowired
//    UserServices userServices;
//
//    @Test
//    void testThatUserCanLogin(){
//        LoginRequestDto loginRequestDto = new LoginRequestDto();
//        loginRequestDto.setEmail("Olanrewajulove2@gmail.com");
//        loginRequestDto.setPassword("23ert");
//        LoginUserResponse loginUserResponse = userServices.loginUser(loginRequestDto);
//        assertEquals("Success",loginUserResponse.getMessage());
////        assertEquals("23ert", loginRequestDto.getPassword());
////        assertEquals("Olanrewajulove2@gmail.com",loginRequestDto.getEmail());
//    }
//
//}