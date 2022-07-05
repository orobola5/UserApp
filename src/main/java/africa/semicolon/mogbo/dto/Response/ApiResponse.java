package africa.semicolon.mogbo.dto.Response;

import africa.semicolon.mogbo.Data.Model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    private boolean isSuccessful;
    private Object data;
}
