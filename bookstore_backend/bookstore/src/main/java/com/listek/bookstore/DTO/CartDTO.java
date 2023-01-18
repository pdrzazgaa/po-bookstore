package com.listek.bookstore.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartDTO {

    private long id;
    private double cartSum;
    private CartItemProductDTO cartItems;
}
