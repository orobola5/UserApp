package africa.semicolon.mogbo.dto.Requests;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String email;
    private String password;
}
