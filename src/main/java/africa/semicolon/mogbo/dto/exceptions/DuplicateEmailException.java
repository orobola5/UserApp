package africa.semicolon.mogbo.dto.exceptions;

public class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException(String s){
        super(s);
    }
}
