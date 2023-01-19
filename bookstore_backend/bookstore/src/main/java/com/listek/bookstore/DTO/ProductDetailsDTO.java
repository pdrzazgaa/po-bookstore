package com.listek.bookstore.DTO;

import com.listek.bookstore.models.Book;
import com.listek.bookstore.models.CoverType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ProductDetailsDTO {

    private Long id;
    private String name;
    private String author;
    private double price;
    private CoverType coverType;
    private String description;
    private String publisher;
    private String title;
    private int numberOfPages;
    private int numberOfItemsInStock;
    private LocalDateTime releaseDate;
    private String language;

    public ProductDetailsDTO(Object[] columns2) {
        Object[] columns;
        try {
            columns = (Object[]) columns2[0];
            setProperties(columns);
        } catch (ClassCastException exception) {
            System.out.println(exception.getMessage());
        } catch (ArrayIndexOutOfBoundsException exception){
            setProperties(columns2);
        }
    }

    private void setProperties(Object[] columns){
        this.id = (columns[0] != null) ? ((Long) columns[0]).longValue() : 0;
        this.name = (String) columns[1];
        this.author = (String) columns[2];
        this.price = (double) columns[3];
        this.coverType = CoverType.fromShort((Short) columns[4]);
        this.description = (String) columns[5];
        this.publisher = (String) columns[6];
        this.title = (String) columns[7];
        this.numberOfPages = (int) columns[8];
        this.numberOfItemsInStock = (int) columns[9];
        this.releaseDate = (LocalDateTime) columns[10];
        this.language = (String) columns[11];
    }

    public Book toBook(){
        Book book = new Book();
        book.setId(id);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setCoverType(coverType);
        book.setNumberOfPages(numberOfPages);
        book.setNumberOfItemsInStock(numberOfItemsInStock);
        book.setTitle(title);
        book.setReleaseDate(releaseDate);
        book.setDescription(description);
        book.setPrice(price);
        book.setLanguage(language);
        return book;
    }
}
