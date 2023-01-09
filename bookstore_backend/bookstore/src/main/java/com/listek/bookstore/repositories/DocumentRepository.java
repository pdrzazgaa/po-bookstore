package com.listek.bookstore.repositories;

import com.listek.bookstore.models.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<Document, Long> {
}
