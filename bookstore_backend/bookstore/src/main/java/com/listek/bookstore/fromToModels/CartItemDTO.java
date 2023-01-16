package com.listek.bookstore.fromToModels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {
    private Long clientID;
    private Long productID;
}
