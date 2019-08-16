package br.com.backSpringBoot.awesome.handler;

import br.com.backSpringBoot.awesome.error.ErrorDetails;
import br.com.backSpringBoot.awesome.error.ResourceNotFoundDetails;
import br.com.backSpringBoot.awesome.error.ResourceNotFoundException;
import br.com.backSpringBoot.awesome.error.ValidationErrorDetails;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author people
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleReourceNotFoundException(ResourceNotFoundException rfnException) {
        ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not found")
                .detail(rfnException.getMessage())
                .developerMessage(rfnException.getClass().getName())
                .build();

        return new ResponseEntity<>(rnfDetails, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException manvException) {
//        List<FieldError> listFieldError = manvException.getBindingResult().getFieldErrors();
//        String erroField = listFieldError.stream().map(FieldError::getField).collect(Collectors.joining(","));
//        String erroMessages = listFieldError.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
//        ValidationErrorDetails manvDetails = ValidationErrorDetails.Builder
//                .newBuilder()
//                .timestamp(new Date().getTime())
//                .status(HttpStatus.BAD_REQUEST.value())
//                .title("Field Validation Error")
//                .detail("Field Validation Error")
//                .developerMessage(manvException.getClass().getName())
//                .field(erroField)
//                .fieldMessage(erroMessages)
//                .build();
//
//        return new ResponseEntity<>(manvDetails, HttpStatus.BAD_REQUEST);
//    }
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException manvException,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        List<FieldError> listFieldError = manvException.getBindingResult().getFieldErrors();
        String erroField = listFieldError.stream().map(FieldError::getField).collect(Collectors.joining(","));
        String erroMessages = listFieldError.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
        ValidationErrorDetails manvDetails = ValidationErrorDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Field Validation Error")
                .detail("Field Validation Error")
                .developerMessage(manvException.getClass().getName())
                .field(erroField)
                .fieldMessage(erroMessages)
                .build();

        return new ResponseEntity<>(manvDetails, HttpStatus.BAD_REQUEST);
    }

//    @Override
//    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        ErrorDetail errorDetail = ErrorDetail.Builder
//                .newBuilder()
//                .timestamp(new Date().getTime())
//                .status(HttpStatus.NOT_FOUND.value())
//                .title("Resource not found")
//                .detail(ex.getMessage())
//                .developerMessage(ex.getClass().getName())
//                .build();
//
//        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
//    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
         ErrorDetails errorDetails = ErrorDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(status.value())
                .title("Internal Exception")
                .detail(ex.getMessage())
                .developerMessage(ex.getClass().getName())
                .build();
        return new ResponseEntity<>(errorDetails, headers, status);
    }

}
