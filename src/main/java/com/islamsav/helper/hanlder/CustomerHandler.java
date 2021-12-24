package com.islamsav.helper.hanlder;

import com.islamsav.helper.dto.ResponseMessage;
import com.islamsav.helper.exception.CustomerCreateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerHandler {

    @ExceptionHandler({CustomerCreateException.class})
    public ResponseEntity<ResponseMessage> handle(CustomerCreateException customerCreateException) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new ResponseMessage(customerCreateException.getMessage()));
    }
}
