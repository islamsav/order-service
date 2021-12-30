package com.islamsav.helper.service.order;

import com.islamsav.helper.dto.order.OrderDto;
import com.islamsav.helper.entity.order.OrderAddressEntity;
import com.islamsav.helper.entity.order.OrderEntity;
import com.islamsav.helper.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderEntity findOrderById(Integer id) {
        return orderRepository.findOrderById(id);
    }

    @Transactional
    public void saveOrder(OrderDto orderDto) {
        OrderAddressEntity orderAddress = new OrderAddressEntity(
                orderDto.getOrderAddress().getLatitude(),
                orderDto.getOrderAddress().getLongitude(),
                orderDto.getOrderAddress().getPosition()
        );
        OrderEntity orderEntity = new OrderEntity(
                orderDto.getTitle(),
                orderDto.getDescriptions(),
                orderDto.getPrice(),
                orderAddress
        );
        orderRepository.save(orderEntity);
    }
}
