package com.islamsav.helper.repository.order;

import com.islamsav.helper.entity.order.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    OrderEntity findOrderById(Integer id);
}
