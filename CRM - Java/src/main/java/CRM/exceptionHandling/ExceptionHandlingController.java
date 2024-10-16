package CRM.exceptionHandling;

import CRM.messages.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlingController {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> entityCannotBeFound(){
        String message = "Entity cannot found";
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionMessage(message, HttpStatus.NOT_FOUND));
    }
}
