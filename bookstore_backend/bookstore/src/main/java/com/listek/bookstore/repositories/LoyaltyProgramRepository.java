package com.listek.bookstore.repositories;

import com.listek.bookstore.models.LoyaltyProgram;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LoyaltyProgramRepository extends CrudRepository<LoyaltyProgram, Long> {

    Optional<LoyaltyProgram> findByClient_Id(Long clientID);

}
