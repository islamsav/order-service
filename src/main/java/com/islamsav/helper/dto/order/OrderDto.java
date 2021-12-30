package com.islamsav.helper.dto.order;

import com.islamsav.helper.entity.order.OrderEntity;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Builder
public class OrderDto implements Serializable {

    private final String title;
    private final String descriptions;
    private final Integer price;
    private final Integer views;
    private final Integer requests;
    private final Boolean isActive;
    private final OrderAddressDto orderAddress;
    private final LocalDateTime createdAt;

    public static OrderDto makeDTO(OrderEntity order) {
        return OrderDto.builder()
                .title(order.getTitle())
                .descriptions(order.getDescriptions())
                .price(order.getPrice())
                .views(order.getViews())
                .requests(order.getRequests())
                .isActive(order.getIsActive())
                .orderAddress(OrderAddressDto.makeDTO(order.getOrderAddress()))
                .createdAt(order.getCreatedAt())
                .build();
    }
}
