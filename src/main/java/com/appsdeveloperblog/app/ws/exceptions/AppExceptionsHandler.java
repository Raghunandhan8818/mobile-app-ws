package com.appsdeveloperblog.app.ws.exceptions;

import com.appsdeveloperblog.app.ws.ui.model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@Controller
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
     public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
        String error_message = ex.getLocalizedMessage();
        if (error_message == null) error_message = ex.toString();
        ErrorMessage errorMessage = new ErrorMessage(error_message, new Date());
        return new ResponseEntity<>(errorMessage ,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
    public ResponseEntity<Object> handleSpecificExceptions(Exception ex, WebRequest request) {
        String error_message = ex.getLocalizedMessage();
        if (error_message == null) error_message = ex.toString();
        ErrorMessage errorMessage = new ErrorMessage(error_message, new Date());
        return new ResponseEntity<>(errorMessage ,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @ExceptionHandler(value = {UserServiceException.class})
//    public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest request) {
//        String error_message = ex.getLocalizedMessage();
//        if (error_message == null) error_message = ex.toString();
//        ErrorMessage errorMessage = new ErrorMessage(error_message, new Date());
//        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }

}
