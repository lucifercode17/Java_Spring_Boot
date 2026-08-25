package in.learnings.dtoCrudApplication.Exception;

import in.learnings.dtoCrudApplication.dto.ExpectionResponseDto;
import in.learnings.dtoCrudApplication.dto.ValidationDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GobalExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ExpectionResponseDto> handleResourceNotFound(ResourceNotFound ex ,HttpServletRequest request){
        ExpectionResponseDto response = new ExpectionResponseDto(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()

        );
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }
    @ExceptionHandler(DuplicateConflict.class)
    public  ResponseEntity<ExpectionResponseDto> handleDuplicateConflict(DuplicateConflict ex,HttpServletRequest request){
        ExpectionResponseDto response = new ExpectionResponseDto(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()

        );
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(response);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExpectionResponseDto> handleRuntimeException(RuntimeException ex,HttpServletRequest request){
        ExpectionResponseDto response = new ExpectionResponseDto(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()

        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationDto> handleValidationException(MethodArgumentNotValidException ex, HttpServletRequest request){


        Map<String,String> errorFields = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errorFields.put(
                                error.getField(),
                                error.getDefaultMessage()
                        )
                );





        ValidationDto response = new ValidationDto(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                request.getRequestURI(),
                errorFields


        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

}
