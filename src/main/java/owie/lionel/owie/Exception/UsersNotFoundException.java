package owie.lionel.owie.Exception;

public class UsersNotFoundException extends RuntimeException {

    public UsersNotFoundException (Long id) {super("Could not find story with id: " + id );}
}
