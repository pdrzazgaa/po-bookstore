package com.listek.bookstore.loaders;

import com.listek.bookstore.models.Category;
import com.listek.bookstore.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CategoriesLoader implements CommandLineRunner {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        loadCategoryData();
    }

    private void loadCategoryData() {
        if (categoryRepository.count() == 0) {
            Category category1 = new Category("Książki", null);
            Category category2 = new Category("Literatura Piękna", category1);
            Category category3 = new Category("Poradniki i albumy", category1);
            Category category4 = new Category("Literatura obcokrajowa", category1);
            Category category5 = new Category("Komiksy", category1);
            Category category6 = new Category("Literatura obyczajowa", category1);
            Category category7 = new Category("Motywacja", category3);
            Category category8 = new Category("Podróże", category3);
            Category category9 = new Category("Zdrowie", category3);
            Category category10 = new Category("Sport", category3);
            Category category11 = new Category("Psychologia", category3);
            Category category12 = new Category("Książki", category4);
            Category category13 = new Category("Literatura brytyjska", category4);
            Category category14 = new Category("Literatura francuska", category4);
            Category category15 = new Category("Literatura amerykańska", category4);
            Category category16 = new Category("Literatura włoska", category4);
            Category category17 = new Category("Depresja", category6);
            Category category18 = new Category("Kulinaria", category6);
            Category category19 = new Category("Zdrowie", category6);
            Category category20 = new Category("Góry", category6);
            Category category21 = new Category("Morze", category6);
            Category category22 = new Category("Miłość", category2);
            Category category23 = new Category("Wojna", category2);
            Category category24 = new Category("Poezja", category2);
            Category category25 = new Category("Romantyzm", category2);
            Category category26 = new Category("Psychologia", category2);
            categoryRepository.save(category1);
            categoryRepository.save(category2);
            categoryRepository.save(category3);
            categoryRepository.save(category4);
            categoryRepository.save(category5);
            categoryRepository.save(category6);
            categoryRepository.save(category7);
            categoryRepository.save(category8);
            categoryRepository.save(category9);
            categoryRepository.save(category10);
            categoryRepository.save(category11);
            categoryRepository.save(category12);
            categoryRepository.save(category13);
            categoryRepository.save(category14);
            categoryRepository.save(category15);
            categoryRepository.save(category16);
            categoryRepository.save(category17);
            categoryRepository.save(category18);
            categoryRepository.save(category19);
            categoryRepository.save(category20);
            categoryRepository.save(category21);
            categoryRepository.save(category22);
            categoryRepository.save(category23);
            categoryRepository.save(category24);
            categoryRepository.save(category25);
            categoryRepository.save(category26);
        }
        System.out.println(categoryRepository.count());
    }
}
