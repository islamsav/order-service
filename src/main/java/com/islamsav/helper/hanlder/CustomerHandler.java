package com.islamsav.helper.hanlder;

import com.islamsav.helper.dto.ResponseMessage;
import com.islamsav.helper.exception.CustomerCreateException;
import com.islamsav.helper.exception.OrderNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class CustomerHandler {

    @ExceptionHandler({CustomerCreateException.class})
    public ResponseEntity<ResponseMessage> handleCustomerCreate(CustomerCreateException customerCreateException) {
        log.info("HANDLE: " + customerCreateException.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new ResponseMessage(customerCreateException.getMessage()));
    }

    @ExceptionHandler({OrderNotFoundException.class})
    public ResponseEntity<ResponseMessage> handleOrderNotFound(OrderNotFoundException orderNotFoundException) {
        log.info("HANDLE: " + orderNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new ResponseMessage(orderNotFoundException.getMessage()));
    }
}
