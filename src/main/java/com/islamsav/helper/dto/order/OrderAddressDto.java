package com.islamsav.helper.dto.order;

import com.islamsav.helper.entity.order.OrderAddressEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class OrderAddressDto implements Serializable {

    private final Float latitude;
    private final Float longitude;
    private final String position;

    public static OrderAddressDto makeDTO(OrderAddressEntity orderAddress) {
        return OrderAddressDto.builder()
                .latitude(orderAddress.getLatitude())
                .longitude(orderAddress.getLongitude())
                .position(orderAddress.getPosition()).build();
    }
}
