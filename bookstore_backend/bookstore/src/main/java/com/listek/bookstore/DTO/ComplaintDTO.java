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
    private Long clientId;
    private DeliveryDTO delivery;
    private List<ProductComplaintDTO> reclamationPosition;

    @Override
    public String toString() {
        return "ComplaintDTO{" +
                "orderNumber='" + orderNumber + '\'' +
                ", clientId=" + clientId +
                ", delivery=" + delivery +
                ", reclamationPosition=" + reclamationPosition +
                '}';
    }
}
