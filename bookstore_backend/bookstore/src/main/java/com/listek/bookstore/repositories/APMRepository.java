package com.listek.bookstore.repositories;

import com.listek.bookstore.models.APM;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface APMRepository extends CrudRepository<APM, Integer> {
    List<APM> findAll();
}
