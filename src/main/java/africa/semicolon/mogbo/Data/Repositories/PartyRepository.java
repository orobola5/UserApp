package africa.semicolon.mogbo.Data.Repositories;

import africa.semicolon.mogbo.Data.Model.Party;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends MongoRepository<Party,String> {

}
