package com.listek.bookstore.models;

public class Address {

    private int id;
    private String street;
    private String number;
    private String postCode;
    private String town;
    private String country;

    public Address(int id, String street, String number, String postCode, String town, String country) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.postCode = postCode;
        this.town = town;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
