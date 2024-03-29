package com.listek.bookstore.repositories;

import com.listek.bookstore.models.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Query(value = "select id, nazwa, autor, cena, typ_okladki from ksiazki where liczba_sztuk_na_stanie > 0", nativeQuery = true)
    List<Object[]> findBooks();

    @Query(value = "select id, nazwa, autor, cena, typ_okladki, opis, wydawca, " +
            "tytul, liczba_stron, liczba_sztuk_na_stanie, data_wydania, jezyk  from ksiazki " +
            "where liczba_sztuk_na_stanie > 0 and id = :id", nativeQuery = true)
    Optional<Object[]> findBook(@Param("id") Long id);

    @Query(value = "select id, nazwa, autor, cena, typ_okladki from ksiazki as K " +
            "where :idK in (select PK.kategoriaid from produkty_kategorie as PK " +
            "where K.id = PK.produktid and liczba_sztuk_na_stanie > 0)", nativeQuery = true)
    List<Object[]> findBooksByCategory(@Param("idK") Long idK);
}
