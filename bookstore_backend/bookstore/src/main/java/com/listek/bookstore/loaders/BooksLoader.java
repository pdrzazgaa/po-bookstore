package com.listek.bookstore.loaders;

import com.listek.bookstore.models.Book;
import com.listek.bookstore.models.Category;
import com.listek.bookstore.models.CoverType;
import com.listek.bookstore.repositories.BookRepository;
import com.listek.bookstore.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Order(4)
public class BooksLoader implements CommandLineRunner {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBooksData();
    }


    private void loadBooksData() {

        if (bookRepository.count() == 0) {

            List<Category> categories = categoryRepository.findAll();

            Book book1 = new Book(9.99, 10, "Kubuś Puchatek",
                    "Książka dla dzieci",
                    "Kubuś puchatek", "A.A. Milne", "NASZA KSIĘGARNIA",
                    LocalDateTime.of(2002, 9, 1, 0, 0),
                    367, "polski", "12345", CoverType.HardCover);
            book1.addCategory(categories.get(8));
            Book book2 = new Book(19.99, 5, "Pan Tadeusz",
                    "Polska epopeja narodowa",
                    "Pan Tadeusz - Ostatni zajazd na Litwie", "Adam Mickiewicz",
                    "NASZA KSIĘGARNIA",
                    LocalDateTime.of(1997, 5, 23, 0, 0),
                    578, "polski", "12346", CoverType.SoftCover);
            book2.addCategory(categories.get(23));
            Book book3 = new Book(9.99, 10, "Kordian",
                    "Lektura Szkolna",
                    "Kordian", "Juliusz Słowacki", "NASZA KSIĘGARNIA",
                    LocalDateTime.of(2000, 8, 30, 0, 0),
                    635, "polski", "12347", CoverType.HardCover);
            book3.addCategory(categories.get(23));
            Book book4 = new Book(29.99, 20, "Harry Potter i Komnata Tajemnic",
                    "Książka o przygodach Harrego Pottera",
                    "Harry Potter i Komnata Tajemnic", "J.K. Rowling", "NASZA KSIĘGARNIA",
                    LocalDateTime.of(2007, 1, 1, 0, 0),
                    426, "polski", "12320", CoverType.SoftCover);
            book4.addCategory(categories.get(13));
            bookRepository.save(book1);
            bookRepository.save(book2);
            bookRepository.save(book3);
            bookRepository.save(book4);
        }
        System.out.println("Books: " + bookRepository.count());
    }
}
