package africa.semicolon.mogbo.Data.Repositories;

import africa.semicolon.mogbo.Data.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {


    User findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<User> findUserByEmail(String email);
}
