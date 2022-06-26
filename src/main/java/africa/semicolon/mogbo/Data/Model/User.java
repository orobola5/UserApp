package africa.semicolon.mogbo.Data.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;

@Data
@NoArgsConstructor
@Document("Users")
public class User {
    @Id
    private  String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime dateTime = LocalDateTime.now();
}
