package owie.lionel.owie.exception;

public class StoryNotFoundException extends RuntimeException {

    public StoryNotFoundException(Long id) { super("Could not find story with id: " + id);}
}
