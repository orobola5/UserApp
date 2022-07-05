package africa.semicolon.mogbo.dto.Requests;

import lombok.Data;

@Data
public class CreatePartyRequest {
    private String email;
    private String partyName;
    private  String partyLocation;

}
