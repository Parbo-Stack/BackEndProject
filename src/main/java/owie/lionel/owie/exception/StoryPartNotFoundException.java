package owie.lionel.owie.exception;

public class StoryPartNotFoundException extends RuntimeException{

    public StoryPartNotFoundException(Long storyPartId) { super("This is not allowed" + storyPartId);}
}
