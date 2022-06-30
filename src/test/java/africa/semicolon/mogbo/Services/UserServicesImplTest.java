package africa.semicolon.mogbo.Services;

import africa.semicolon.mogbo.Data.Repositories.UserRepository;
import africa.semicolon.mogbo.dto.Requests.RegisterUserRequest;
import africa.semicolon.mogbo.dto.exceptions.DuplicateEmailException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServicesImplTest {
    @Autowired
    private UserServices userServicesImpl;
    @Autowired
    private UserRepository userRepository;
    @Test void registerUserTest(){
        registerFunmi();
        assertEquals(1,userRepository.count());

    }

    private void registerFunmi() {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("funmi@email.com");
        request.setFirstName("omisande");
        request.setLastName("funmi");
        request.setPassword("ilovejesus");
        userServicesImpl.registerUser(request);
    }

    @Test void duplicateEmailThrowsException(){
        registerFunmi();
        assertThrows(DuplicateEmailException.class, this::registerFunmi);
        try{
            registerFunmi();
        }
        catch (DuplicateEmailException exception){
            assertEquals("funmi@email.com exists",exception.getMessage());
        }
    }


}