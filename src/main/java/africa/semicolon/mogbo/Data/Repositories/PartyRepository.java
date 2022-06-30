package africa.semicolon.mogbo.Data.Repositories;

import africa.semicolon.mogbo.Data.Model.Party;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PartyRepository extends MongoRepository<Party,String> {

}
