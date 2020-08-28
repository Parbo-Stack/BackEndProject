package owie.lionel.owie.Exception;

public class StoryNotFoundException extends RuntimeException {

    public StoryNotFoundException(Long id) { super("Could not find story with id: " + id);}
}
