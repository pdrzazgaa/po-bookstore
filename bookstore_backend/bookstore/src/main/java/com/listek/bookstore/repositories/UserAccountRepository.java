package com.listek.bookstore.repositories;

import com.listek.bookstore.models.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
}
