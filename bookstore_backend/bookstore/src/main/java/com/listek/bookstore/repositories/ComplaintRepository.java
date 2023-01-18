package com.listek.bookstore.repositories;

import com.listek.bookstore.models.Complaint;
import org.springframework.data.repository.CrudRepository;

public interface ComplaintRepository extends CrudRepository<Complaint, Long> {
}
