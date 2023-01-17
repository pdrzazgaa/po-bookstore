package com.listek.bookstore.repositories;

import com.listek.bookstore.models.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart, Long> {

    @Query(value = "select * from koszyki where ostatnia_aktywnosc between (now()- interval "+Cart.EXPIRATION_TIME+" minute) and " +
            "now() and klientid = :clientID order by ostatnia_aktywnosc desc limit 1", nativeQuery = true)
    Optional<Cart> isAvailableCart(@Param("clientID") Long clientID);

    @Query("update Cart set lastActivity = now()")
    void updateLastActivity(@Param("cartID") Long cartID);

    @Query("select c from Cart c order by c.id limit 1")
    Optional<Cart> findFirst();

}
