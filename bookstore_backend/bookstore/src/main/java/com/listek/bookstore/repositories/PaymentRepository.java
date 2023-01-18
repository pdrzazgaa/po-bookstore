package com.listek.bookstore.repositories;

import com.listek.bookstore.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
