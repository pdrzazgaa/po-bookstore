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
    private CoverType coverType;

    public ProductListToData(Object[] columns) {
        this.id = (columns[0] != null)?((Long)columns[0]).longValue():0;
        this.name = (String) columns[1];
        this.author = (String) columns[2];
        this.price = (double) columns[3];
        this.coverType = CoverType.fromShort((Short)columns[4]);
    }
}
