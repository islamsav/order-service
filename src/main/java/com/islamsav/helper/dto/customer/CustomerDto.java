package com.islamsav.helper.dto.customer;

import com.islamsav.helper.entity.customer.CustomerEntity;
import com.islamsav.helper.entity.enums.GenderEnum;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CustomerDto implements Serializable {

    private final String name;
    private final String surname;
    private final String city;
    private final String phone;
    private final GenderEnum gender;
    private final String email;

    public static CustomerDto makeDTO(CustomerEntity customer) {
        return CustomerDto.builder()
                .name(customer.getName())
                .surname(customer.getSurname())
                .city(customer.getCity())
                .phone(customer.getPhone())
                .gender(customer.getGender())
                .email(customer.getEmail())
                .build();
    }
}
