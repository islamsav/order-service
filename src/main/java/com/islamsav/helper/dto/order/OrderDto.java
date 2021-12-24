package com.islamsav.helper.dto.order;

import com.islamsav.helper.entity.order.OrderEntity;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class OrderDto implements Serializable {

    private final String title;
    private final String descriptions;
    private final Integer price;
    private final Integer views;
    private final Integer requests;
    private final Boolean isActive;

    public static OrderDto makeDTO(OrderEntity order) {
        return OrderDto.builder()
                .title(order.getTitle())
                .descriptions(order.getDescriptions())
                .price(order.getPrice())
                .views(order.getViews())
                .requests(order.getRequests())
                .isActive(order.getIsActive())
                .build();
    }
}
