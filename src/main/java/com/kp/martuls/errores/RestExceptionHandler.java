package com.kp.martuls.errores;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.kp.martuls.configuracion.KeyGestionlogger;
import com.kp.martuls.validation.Validar;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	Validar validar;
	
  @ExceptionHandler
  protected ResponseEntity<ErrorResponse> handleException(NoSuchElementException exc) {
    HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
    return buildResponseEntity(httpStatus, exc);
  }

  @ExceptionHandler
  protected ResponseEntity<ErrorResponse> handleException(DuplicateKeyException exc) {
    HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
    return buildResponseEntity(httpStatus, exc);
  }

  @ExceptionHandler
  protected ResponseEntity<ErrorResponse> handleException(IllegalArgumentException exc) {
    HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
    KeyGestionlogger.EXCEPTIONS_LOG.log(String.format("%s|%s|%s",exc.getMessage(),exc.getCause(),exc));
    return buildResponseEntity(httpStatus, exc);
  }
  
  @ExceptionHandler
  protected ResponseEntity<ErrorResponse> handleException(InvalidDataException exc) {
    HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
    List<String> errors = exc.getResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
        .collect(Collectors.toList());
    return buildResponseEntity(httpStatus, new RuntimeException(validar.getMsg0004()), errors);
  }

  @ExceptionHandler
  protected ResponseEntity<ErrorResponse> handleException(MethodArgumentTypeMismatchException exc) {
    HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
    // Aplica cuando en el URL se envia un argumento invalido, por ejemplo String
    // por Integer
    return buildResponseEntity(httpStatus, new RuntimeException(validar.getMsg0005()));
  }

  @ExceptionHandler
  protected ResponseEntity<ErrorResponse> handleException(Exception exc) {
    HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    KeyGestionlogger.EXCEPTIONS_LOG.log(String.format("%s|%s|%s",exc.getMessage(),exc.getCause(),exc));

    return buildResponseEntity(httpStatus, new RuntimeException(validar.getMsg0006()));
  }

  private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus httpStatus, Exception exc) {
    return buildResponseEntity(httpStatus, exc, null);
  }

  private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus httpStatus, Exception exc, List<String> errors) {
    ErrorResponse error = new ErrorResponse();
    error.setMessage(exc.getMessage());
    error.setStatus(httpStatus.value());
    error.setTimestamp(new Date());
    error.setErrors(errors);
    return new ResponseEntity<>(error, httpStatus);

  }

}
