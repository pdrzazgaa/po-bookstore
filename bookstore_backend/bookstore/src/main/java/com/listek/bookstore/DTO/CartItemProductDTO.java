package com.listek.bookstore.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartItemProductDTO {
    private long id;
    private int quantity;
    private String name;
    private double price;
    private String author;
    private String coverType;
}
