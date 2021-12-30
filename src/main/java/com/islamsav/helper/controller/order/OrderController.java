package com.islamsav.helper.controller.order;

import com.islamsav.helper.dto.ResponseMessage;
import com.islamsav.helper.dto.order.OrderDto;
import com.islamsav.helper.entity.order.OrderEntity;
import com.islamsav.helper.exception.OrderNotFoundException;
import com.islamsav.helper.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping(value = "/order/createNewOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseMessage> createNewOrder(@RequestBody OrderDto orderDto) {
        orderService.saveOrder(orderDto);
        return ResponseEntity.ok().body(new ResponseMessage("Заказ успешно создан"));
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Integer id) {
        OrderEntity orderEntity = orderService.findOrderById(id);
        if (orderEntity == null) {
            throw new OrderNotFoundException("Отсутствует заказ под номером " + id);
        }
        OrderDto orderDto = OrderDto.makeDTO(orderEntity);
        return ResponseEntity.ok().body(orderDto);
    }
}
