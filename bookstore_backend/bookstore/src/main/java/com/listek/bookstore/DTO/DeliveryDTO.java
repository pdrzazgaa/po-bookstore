package com.listek.bookstore.DTO;

import com.listek.bookstore.models.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.cache.spi.AbstractCacheTransactionSynchronization;

@Getter
@Setter
@NoArgsConstructor
public class DeliveryDTO {

    private static final String BOOKSTORE = "bookstore";
    private static final String CARRIER = "carrier";
    private static final String PARCELMACHINE = "parcelMachine";

    private String delivery;
    private String parcelMachineNumber;

    public Delivery fromDeliveryDTOtoDelivery(Address address, Order order){
        if (delivery.equals(BOOKSTORE))
            return new BookstoreDelivery(address, order);
        else if (delivery.equals(PARCELMACHINE))
            return new APMDelivery(address, parcelMachineNumber, order);
        else
            return new CourierDelivery(address, order);
    }

    @Override
    public String toString() {
        return "DeliveryDTO{" +
                "delivery='" + delivery + '\'' +
                ", parcelMachineNumber='" + parcelMachineNumber + '\'' +
                '}';
    }
}
