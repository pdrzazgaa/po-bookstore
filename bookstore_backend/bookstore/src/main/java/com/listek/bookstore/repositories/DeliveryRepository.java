package com.listek.bookstore.repositories;

import com.listek.bookstore.models.Delivery;
import org.springframework.data.repository.CrudRepository;

public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
}
