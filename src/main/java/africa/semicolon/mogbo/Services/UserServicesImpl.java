package africa.semicolon.mogbo.Services;

import africa.semicolon.mogbo.Data.Model.User;
import africa.semicolon.mogbo.Data.Repositories.UserRepository;
import africa.semicolon.mogbo.dto.Requests.LoginRequestDto;
import africa.semicolon.mogbo.dto.Requests.RegisterUserRequest;
import africa.semicolon.mogbo.dto.Response.LoginUserResponse;
import africa.semicolon.mogbo.dto.Response.RegisterUserResponse;
import africa.semicolon.mogbo.dto.exceptions.DuplicateEmailException;
import africa.semicolon.mogbo.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
public class UserServicesImpl implements UserServices {

    private final UserRepository userRepository;
    private final PartyService partyService;

    public UserServicesImpl( @Autowired UserRepository userRepository,PartyService partyService) {
      this.userRepository=userRepository;
      this.partyService=partyService;
    }

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        if(userRepository.existsByEmail(request.getEmail()))
            throw new DuplicateEmailException(request.getEmail()+"exist!!!");
        User user = new User();
        Mapper.map(request, user);
        User savedUser = userRepository.save(user);
        RegisterUserResponse response = new RegisterUserResponse();
        Mapper.map(savedUser,response);
        return response;
    }

    @Override
    public LoginUserResponse loginUser(LoginRequestDto loginRequestDto) {
        User user = userRepository.findByEmail(loginRequestDto.getEmail());
        if(user == null){
            throw new IllegalArgumentException("User is not registered");
        }

        if(!Objects.equals(user.getPassword(), loginRequestDto.getPassword())){
            throw new IllegalArgumentException("Password incorrect");
        }

        return new LoginUserResponse("Success");
    }


}