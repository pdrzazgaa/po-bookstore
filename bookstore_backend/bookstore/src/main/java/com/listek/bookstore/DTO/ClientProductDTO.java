package com.listek.bookstore.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClientProductDTO {
    private Long clientID;
    private Long productID;
}
