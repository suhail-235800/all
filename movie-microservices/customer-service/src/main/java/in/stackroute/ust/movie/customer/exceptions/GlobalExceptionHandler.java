package in.stackroute.ust.movie.customer.exceptions;

import in.stackroute.ust.movie.customer.dto.ErrorDto;
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
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleBlogNotFoundException(CustomerNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ErrorDto> handleMovieAlreadyExistsException(CustomerAlreadyExistsException ex) {
        return ResponseEntity.status(409).body(new ErrorDto(ex.getMessage(),
                LocalDateTime.now(), ex.getUri(), HttpStatus.CONFLICT.value()));
    }

    @ExceptionHandler(InvalidCustomerDataException.class)
    public ResponseEntity<ErrorDto> handleInvalidMovieDataException(InvalidCustomerDataException ex) {
        return ResponseEntity.status(400).body(new ErrorDto(ex.getMessage(),
                LocalDateTime.now(), null, HttpStatus.BAD_REQUEST.value()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }

}
