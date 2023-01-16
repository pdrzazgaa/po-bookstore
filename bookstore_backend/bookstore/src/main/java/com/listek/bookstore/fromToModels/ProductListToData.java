package com.listek.bookstore.fromToModels;

import com.listek.bookstore.models.CoverType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductListToData {
    private Long id;
    private String name;
    private String author;
    private double price;
    private CoverType cover;
}
