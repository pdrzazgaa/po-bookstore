package com.listek.bookstore.DTO;

import com.listek.bookstore.models.Cart;
import com.listek.bookstore.models.CoverType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CartDTO {

    private long id;
    private double cartSum;
    private List<CartItemProductDTO> cartItems;

    public CartDTO(Object[] columns) {
        this.id = (columns[0] != null)?((Long)columns[0]).longValue():0;
    }

    public Cart toCart(){
        Cart newCart = new Cart();
        newCart.setId(id);
        newCart.setCartItems(new ArrayList<>());
        return newCart;
    }

    public void computeSumCart(){
        cartSum = 0;
        for (CartItemProductDTO cartItemProductDTO : cartItems){
            cartSum += cartItemProductDTO.computePrice();
        }
    }
}
