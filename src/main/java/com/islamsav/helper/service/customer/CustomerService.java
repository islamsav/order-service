package com.islamsav.helper.service.customer;

import com.islamsav.helper.dto.customer.CustomerDto;
import com.islamsav.helper.entity.customer.CustomerEntity;
import com.islamsav.helper.repository.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    @Transactional
    public void saveCustomer(CustomerDto customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCity(customer.getCity());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setGender(customer.getGender());
        customerEntity.setName(customer.getName());
        customerEntity.setSurname(customer.getSurname());
        customerEntity.setPhone(customer.getPhone());
        customerRepository.save(customerEntity);
    }

    public boolean customerByPhoneExist(String phone) {
        return customerRepository.findCustomerByPhone(phone) != null;
    }
}
