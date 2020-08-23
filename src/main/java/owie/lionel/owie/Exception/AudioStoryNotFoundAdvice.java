package owie.lionel.owie.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AudioStoryNotFoundAdvice {


    @ResponseBody
    @ExceptionHandler(AudioStoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String audiostoryNotFoundHandler (AudioStoryNotFoundException ex) { return ex.getMessage();}
}
