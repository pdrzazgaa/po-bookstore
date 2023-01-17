package com.listek.bookstore.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ComplaintDTO {
    private String orderNumber;
    private Long userId;
    private DeliveryDTO delivery;
    private List<ProductComplaintDTO> reclamationPositions;

    @Override
    public String toString() {
        return "ComplaintDTO{" +
                "orderNumber='" + orderNumber + '\'' +
                ", userId=" + userId +
                ", delivery=" + delivery +
                ", reclamationPosition=" + reclamationPositions +
                '}';
    }
}
