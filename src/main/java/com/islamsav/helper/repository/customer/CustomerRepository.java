package com.islamsav.helper.repository.customer;

import com.islamsav.helper.entity.customer.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    @Query("FROM CustomerEntity WHERE phone = :phone")
    CustomerEntity findCustomerByPhone(@Param("phone") String phone);
}
