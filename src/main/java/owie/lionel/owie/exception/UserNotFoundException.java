package owie.lionel.owie.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("Could not find story with id: " + id );}

    public UserNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
