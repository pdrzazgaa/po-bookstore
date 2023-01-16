package com.listek.bookstore.repositories;

import com.listek.bookstore.models.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart, Long> {

    @Query(value = "select * from koszyki where ostatnia_aktywnosc between (now()- interval '15' minute) and " +
            "now() and klientid = :clientID", nativeQuery = true)
    Optional<Cart> isAvailableCart(@Param("clientID") Long clientID);

    @Query("update Cart set lastActivity = now()")
    void updateLastActivity(@Param("cartID") Long cartID);
}
