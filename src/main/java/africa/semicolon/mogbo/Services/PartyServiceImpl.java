package africa.semicolon.mogbo.Services;

import africa.semicolon.mogbo.Data.Model.Party;
import africa.semicolon.mogbo.Data.Repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyServiceImpl implements PartyService {
    @Autowired
    private PartyRepository partyRepository;

    @Override
    public Party saveParty(Party party) {

        return party;
    }
}
