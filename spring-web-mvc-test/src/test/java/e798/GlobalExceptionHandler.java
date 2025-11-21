package e798;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // what test will fail if I drop this class?
class GlobalExceptionHandler
{
    // what if I replace it with Exception or RuntimeException, will it work?
    @ExceptionHandler(CustomException.class)
    ResponseEntity<String> handleGoneException(CustomException e)
    {
        return new ResponseEntity<>(e.getMessage(), e.getStatusCode());
    }
}
