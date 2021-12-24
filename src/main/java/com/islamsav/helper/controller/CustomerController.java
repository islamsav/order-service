package com.islamsav.helper.controller;

import com.islamsav.helper.dto.ResponseMessage;
import com.islamsav.helper.dto.customer.CustomerDto;
import com.islamsav.helper.exception.CustomerCreateException;
import com.islamsav.helper.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseMessage> createNewCustomer(@RequestBody CustomerDto customerDto) {
        String phone = customerDto.getPhone();
        boolean customerExist = customerService.customerByPhoneExist(phone);
        if (customerExist) {
            log.info("Пользователь с номером телефона {} уже зарегистрирован", phone);
            throw new CustomerCreateException(String.format("Пользователь с номером телефона %s уже зарегистрирован", phone));
        }
        if (phone.length() != 11) {
            log.info("Длина номера телефона должна составлять из 11 цифр");
            throw new CustomerCreateException("Длина номера телефона должна составлять из 11 цифр");
        }
        customerService.saveCustomer(customerDto);
        log.info("Новый пользователь сохранен");
        return ResponseEntity.ok().body(new ResponseMessage("Новый пользователь сохранен"));
    }
}

