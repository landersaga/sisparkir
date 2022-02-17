package parkir;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ParkirNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ParkirNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String parkirNotFoundHandler(ParkirNotFoundException ex){
        return ex.getMessage();
    }

}
