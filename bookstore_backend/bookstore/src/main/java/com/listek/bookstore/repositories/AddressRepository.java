package com.listek.bookstore.repositories;

import com.listek.bookstore.models.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
