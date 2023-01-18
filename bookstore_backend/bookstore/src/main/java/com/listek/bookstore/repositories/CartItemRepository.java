package com.listek.bookstore.repositories;

import com.listek.bookstore.DTO.CartItemProductDTO;
import com.listek.bookstore.models.CartItem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {
    @Modifying
    @Query(value="delete from pozycje_koszyka where ilosc = 0", nativeQuery = true)
    void removeEmptyCartItem();

    @Query(value = "select pk.ilosc quantity, k.id, k.nazwa name, k.cena price, k.autor author, k.typ_okladki coverType from pozycje_koszyka pk inner join ksiazki k on k.id = pk.productid " +
            "where pk.koszykid = :cartId", nativeQuery = true)
    List<CartItemProductDTO> getCartItemsByCartId(@Param("cartId") Long cartId);
}
