package com.listek.bookstore.repositories;

import com.listek.bookstore.models.UserAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

    Optional<UserAccount> findUserAccountByEmailAndPassword(String email, String password);
    Optional<UserAccount> findById(Long id);
}
