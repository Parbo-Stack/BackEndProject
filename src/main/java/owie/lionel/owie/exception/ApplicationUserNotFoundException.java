package owie.lionel.owie.exception;

public class ApplicationUserNotFoundException extends RuntimeException {

    public ApplicationUserNotFoundException(Long id) {super("Could not find story with id: " + id );}
}
