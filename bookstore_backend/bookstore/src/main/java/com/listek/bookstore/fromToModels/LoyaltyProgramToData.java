package com.listek.bookstore.fromToModels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoyaltyProgramToData {

    private boolean isParticipant;
    private int bookcoins;
}
