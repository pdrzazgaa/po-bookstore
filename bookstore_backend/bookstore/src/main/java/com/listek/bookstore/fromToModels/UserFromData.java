package com.listek.bookstore.fromToModels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserFromData {

    private String email;
    private String password;
}
