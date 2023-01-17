package com.listek.bookstore.DTO;

import com.listek.bookstore.models.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class AddressDTO {

    private String street;
    private String city;
    private String postcode;
    private String country;
    private String num;

    public Address fromAddressDTOtoAddress(String forename, String surname, String mail, String phoneNumber){
        return new Address(forename, surname, mail, phoneNumber, street, num, postcode, city, country);
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                ", country='" + country + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}
