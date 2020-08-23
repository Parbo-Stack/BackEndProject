package owie.lionel.owie.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import owie.lionel.owie.Model.AudioStory;
import owie.lionel.owie.Model.FinishStory;

@ControllerAdvice
public class FinishStoryNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(FinishStoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String finishstoryNotFoundHandler (FinishStoryNotFoundException ex) { return ex.getMessage();}
}
