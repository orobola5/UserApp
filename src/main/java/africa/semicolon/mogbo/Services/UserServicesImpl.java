package africa.semicolon.mogbo.Services;

import africa.semicolon.mogbo.Data.Model.Party;
import africa.semicolon.mogbo.Data.Model.User;
import africa.semicolon.mogbo.Data.Repositories.UserRepository;
import africa.semicolon.mogbo.dto.Requests.CreatePartyRequest;
import africa.semicolon.mogbo.dto.Requests.LoginRequestDto;
import africa.semicolon.mogbo.dto.Requests.RegisterUserRequest;
import africa.semicolon.mogbo.dto.Response.LoginUserResponse;
import africa.semicolon.mogbo.dto.Response.RegisterUserResponse;
import africa.semicolon.mogbo.dto.Response.createPartyResponse;
import africa.semicolon.mogbo.dto.exceptions.DuplicateEmailException;
import africa.semicolon.mogbo.dto.exceptions.UserDoesNotExistException;
import africa.semicolon.mogbo.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.Optional;

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

    @Override
    public createPartyResponse addParty(CreatePartyRequest request) {
        //check if user exist
        Optional<User>optionalUser=userRepository.findUserByEmail(request.getEmail());
        //throw exception if user does not exist
        if(optionalUser.isEmpty())throw  new UserDoesNotExistException(request.getEmail()+"does not exist");
        User foundUser =optionalUser.get();
        //create party
        Party party = new Party();
        party.setLocation(request.getPartyLocation());
        party.setName(request.getPartyName());
        //save party
        Party savedParty = partyService.saveParty(party);
        //add party to list of users party
        foundUser.getParties().add(savedParty);
        //save the user
        userRepository.save(foundUser);
        //return response
        createPartyResponse response = new createPartyResponse();
        response.setPartyLocation(savedParty.getLocation());
        response.setPartyName(savedParty.getName());
        response.setCreatedBy(foundUser.getFirstName());
        return response;
    }


}