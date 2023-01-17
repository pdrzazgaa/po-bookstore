package com.listek.bookstore.DTO;

import com.listek.bookstore.models.OnlinePayment;
import com.listek.bookstore.models.Order;
import com.listek.bookstore.models.Payment;
import com.listek.bookstore.models.TransferPayment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PaymentDTO {

    private static final String ONLINEPAYMENT = "online-payment";
    private static final String TRANSFER = "transfer";

    private String payment;

    public PaymentDTO(String payment) {
        this.payment = payment;
    }

    public Payment fromPaymentDTOtoPayment(Order order){
        if (payment.equals(ONLINEPAYMENT))
            return new OnlinePayment(LocalDateTime.now(), order);
        else
            return new TransferPayment(LocalDateTime.now(),"12 3456 7890 0000 1234", order);
    }


}
