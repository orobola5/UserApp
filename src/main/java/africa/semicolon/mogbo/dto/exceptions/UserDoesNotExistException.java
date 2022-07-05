package africa.semicolon.mogbo.dto.exceptions;

public class UserDoesNotExistException extends  RuntimeException{
    public UserDoesNotExistException(String message) {
        super(message);
    }
}
