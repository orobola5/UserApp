package africa.semicolon.mogbo.Data.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@NoArgsConstructor
public class Party {
    @Id
    private String id;
    private String name;
    private String location;

}
