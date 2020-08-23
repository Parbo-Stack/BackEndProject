package owie.lionel.owie.Exception;



public class AudioStoryNotFoundException extends RuntimeException{

    public AudioStoryNotFoundException (Long id) { super ("Could not find story with id: " + id); }
}
