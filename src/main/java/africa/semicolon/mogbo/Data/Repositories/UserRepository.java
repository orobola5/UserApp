package africa.semicolon.mogbo.Data.Repositories;

import africa.semicolon.mogbo.Data.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {
    User findByEmail(String email);
}
