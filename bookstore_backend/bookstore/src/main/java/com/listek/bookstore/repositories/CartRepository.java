package com.listek.bookstore.repositories;

import com.listek.bookstore.models.Cart;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart, Long> {

    /**
     * Function checks if there is an existing client's cart that's last activity was less than 15 minutes ago
     * @param clientID
     * @return
     */
    @Query(value = "select koszyki.id, koszyki.ostatnia_aktywnosc, koszyki.klientid from koszyki left join zamowienia on koszyki.id = zamowienia.koszykid " +
            "where zamowienia.id is null and ostatnia_aktywnosc between (now()- interval "+Cart.EXPIRATION_TIME+" minute) and " +
            "now() and klientid = :clientID order by ostatnia_aktywnosc desc limit 1", nativeQuery = true)
    Optional<Cart> isAvailableCart(@Param("clientID") Long clientID);


    @Modifying
    @Query(value = "delete from koszyki where (select count(pozycje_koszyka.id) from pozycje_koszyka " +
            "where pozycje_koszyka.koszykid = koszyki.id) = 0", nativeQuery = true)
    void removeEmptyCart();

}
