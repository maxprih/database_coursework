package com.example.coursework.exceptions;

import com.example.coursework.models.dto.responses.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author max_pri
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = NoFreeMoneyException.class)
    private ResponseEntity<MessageResponse> handleNoFreeMoneyException(NoFreeMoneyException e) {
        MessageResponse response = new MessageResponse("Бесплатные деньги доступны только при балансе менее 500");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
