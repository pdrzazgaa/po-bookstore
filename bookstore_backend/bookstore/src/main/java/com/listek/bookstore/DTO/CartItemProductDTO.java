package com.listek.bookstore.DTO;

import com.listek.bookstore.models.CoverType;
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
    private CoverType coverType;
    public CartItemProductDTO(Object[] column){
        quantity = (int) column[0];
        id = (long) column[1];
        name = (String) column[2];
        price = (double) column[3];
        author = (String) column[4];
        coverType = CoverType.fromShort((Short)column[5]);
    }

    public double computePrice(){
        return quantity * price;
    }
}
