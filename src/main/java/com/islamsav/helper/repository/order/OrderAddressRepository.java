package com.islamsav.helper.repository.order;

import com.islamsav.helper.entity.order.OrderAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderAddressRepository extends JpaRepository<OrderAddressEntity, Integer> {
}
