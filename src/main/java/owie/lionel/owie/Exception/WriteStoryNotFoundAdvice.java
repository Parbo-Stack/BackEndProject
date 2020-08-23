package owie.lionel.owie.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WriteStoryNotFoundAdvice {

    /**
     * met Responsebody geven we aan dat we een naar JSON geserialized object teruggeven.Dit object wordt in een
     * HTTPResponse gezet.
     *
     * De ExceptionHandler moet een verwijzing bevatten naar de Exceptie die we gemaakt hebben. Let op, hier moet class
     *achter.
     *
     * Met ResponsiveStatus geven we aan welke HTTP status we willen meegeven. HTTP 484 is zo'n status. de 484 betekent
     * not dfound. je kunt ze hier allemaal vinden:
     * https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/http/HttpStatus.html
     * @param ex
     * @return
     */

    @ResponseBody
    @ExceptionHandler(WriteStoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String writestoryNotFoundHandler (WriteStoryNotFoundException ex) { return ex.getMessage();}
}
