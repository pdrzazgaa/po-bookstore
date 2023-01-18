package com.listek.bookstore.repositories;

import com.listek.bookstore.models.CartItem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {
    @Modifying
    @Query(value="delete from pozycje_koszyka where ilosc = 0", nativeQuery = true)
    void removeEmptyCartItem();
}
