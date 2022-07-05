package africa.semicolon.mogbo.Services;

import africa.semicolon.mogbo.dto.Requests.CreatePartyRequest;
import africa.semicolon.mogbo.dto.Requests.LoginRequestDto;
import africa.semicolon.mogbo.dto.Requests.RegisterUserRequest;
import africa.semicolon.mogbo.dto.Response.LoginUserResponse;
import africa.semicolon.mogbo.dto.Response.RegisterUserResponse;
import africa.semicolon.mogbo.dto.Response.createPartyResponse;

public interface UserServices {
    RegisterUserResponse registerUser(RegisterUserRequest request);
    LoginUserResponse  loginUser(LoginRequestDto loginRequestDto);
   createPartyResponse addParty(CreatePartyRequest request);

}
