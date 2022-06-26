package africa.semicolon.mogbo.Services;

import africa.semicolon.mogbo.Data.Model.User;
import africa.semicolon.mogbo.Data.Repositories.UserRepository;
import africa.semicolon.mogbo.dto.Requests.LoginRequestDto;
import africa.semicolon.mogbo.dto.Requests.RegisterUserRequest;
import africa.semicolon.mogbo.dto.Response.LoginUserResponse;
import africa.semicolon.mogbo.dto.Response.RegisterUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Service
public class UserServicesImpl implements UserServices{
    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        User user= new User();
        User foundUser = userRepository.findByEmail(request.getEmail());
        if(foundUser!=null){
            throw new IllegalArgumentException("User already exist");
        }

        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());

        User savedUser = userRepository.save(user);
        RegisterUserResponse response = new RegisterUserResponse();
        response.setEmail(savedUser.getEmail());
        response.setDateCreated(DateTimeFormatter.ofPattern("EEEE,dd/MM/yyy,hh:mm,a").format(savedUser.getDateTime()));

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
