package owie.lionel.owie.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApplicationUserNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ApplicationUserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    public String UsersNotFoundHandler ( ApplicationUserNotFoundException ex) { return ex.getMessage();}
}
