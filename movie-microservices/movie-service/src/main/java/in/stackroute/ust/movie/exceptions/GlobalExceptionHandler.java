package in.stackroute.ust.movie.exceptions;

import in.stackroute.ust.movie.dto.ErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ErrorDto> handleMovieNotFoundException(MovieNotFoundException ex) {
        return ResponseEntity.status(404).body(new ErrorDto(ex.getMessage(),
                LocalDateTime.now(), ex.getUri(), HttpStatus.NOT_FOUND.value()));
    }

    // MovieAlreadyExistsException
    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<ErrorDto> handleMovieAlreadyExistsException(MovieAlreadyExistsException ex) {
        return ResponseEntity.status(409).body(new ErrorDto(ex.getMessage(),
                LocalDateTime.now(), ex.getUri(), HttpStatus.CONFLICT.value()));
    }

    // InvalidMovieDataException
    @ExceptionHandler(InvalidMovieDataException.class)
    public ResponseEntity<ErrorDto> handleInvalidMovieDataException(InvalidMovieDataException ex) {
        return ResponseEntity.status(400).body(new ErrorDto(ex.getMessage(),
                LocalDateTime.now(), null, HttpStatus.BAD_REQUEST.value()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }
}
