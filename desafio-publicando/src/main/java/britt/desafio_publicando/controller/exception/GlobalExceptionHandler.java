package britt.desafio_publicando.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handler(IllegalArgumentException businesException){
        return new ResponseEntity<>(businesException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handlerNotFoundException(NoSuchElementException notFoundException){
        return new ResponseEntity<>("Resource ID not found.", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handlerUnexpectedException(Throwable unexpectedException){
        var message = "Unexpected server error, see the logs.";
        logger.error(message, unexpectedException);
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
