package com.listek.bookstore.loaders;

import com.listek.bookstore.models.Book;
import com.listek.bookstore.models.Category;
import com.listek.bookstore.models.CoverType;
import com.listek.bookstore.models.Product;
import com.listek.bookstore.repositories.BookRepository;
import com.listek.bookstore.repositories.CategoryRepository;
import com.listek.bookstore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
public class BooksLoader implements CommandLineRunner {

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBooksData();
    }


    private void loadBooksData() {
        if (bookRepository.count() == 0) {

            Book user1 = new Book(9.99, 10, "Kubuś Puchatek", "Książka dla dzieci",
                    "Kubuś puchatek", "A.A. Milne", "NASZA KSIĘGARNIA",
                    LocalDateTime.of(2002, 9, 1, 0, 0),
                    367, "polski", "12345", CoverType.HardCover);
            //Book user2 = new Book();
            bookRepository.save(user1);
            //bookRepository.save(user2);
        }
        System.out.println(bookRepository.count());
    }
}
