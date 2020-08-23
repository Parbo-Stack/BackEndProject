package owie.lionel.owie.Exception;



public class WriteStoryNotFoundException extends RuntimeException {


    public WriteStoryNotFoundException (Long id) { super ("Could not find story with id: " + id); }

}
