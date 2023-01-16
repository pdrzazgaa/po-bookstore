package com.listek.bookstore.fromToModels;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClientProductDTO {
    private Long clientID;
    private Long productID;
}
