package com.listek.bookstore.repositories;

import com.listek.bookstore.models.Client;
import com.listek.bookstore.models.UserAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long> {

    Optional<Client> findClientById(Long id);
}
