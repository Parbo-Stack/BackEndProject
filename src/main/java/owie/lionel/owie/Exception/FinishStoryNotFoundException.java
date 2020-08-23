package owie.lionel.owie.Exception;

public class FinishStoryNotFoundException extends RuntimeException {

    public FinishStoryNotFoundException (Long id) { super ("Could not find story with id: " + id); }
}
