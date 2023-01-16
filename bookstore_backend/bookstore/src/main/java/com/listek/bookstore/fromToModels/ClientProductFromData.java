package com.listek.bookstore.fromToModels;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClientProductFromData {
    private Long clientID;
    private Long productID;
}
