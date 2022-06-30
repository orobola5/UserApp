package africa.semicolon.mogbo.utils;

import africa.semicolon.mogbo.Data.Model.User;
import africa.semicolon.mogbo.dto.Requests.RegisterUserRequest;
import africa.semicolon.mogbo.dto.Response.RegisterUserResponse;

import java.time.format.DateTimeFormatter;

public class Mapper {
//    public static User map(RegisterUserRequest request){
    public static void map(RegisterUserRequest request,User user){
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());

    }
    public static void map(User savedUser, RegisterUserResponse response){
        response.setEmail(savedUser.getEmail());
        response.setDateCreated(DateTimeFormatter.
                ofPattern("EEEE,dd/MM/yyy,hh:mm,a").
                format(savedUser.getDateTime()));
    }
}
