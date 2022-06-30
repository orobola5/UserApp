package africa.semicolon.mogbo.Data.Repositories;

import africa.semicolon.mogbo.Data.Model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@DataMongoTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test public void save(){
        User user=new User();
        userRepository.save(user);
        assertEquals(1,userRepository.count());

    }

}