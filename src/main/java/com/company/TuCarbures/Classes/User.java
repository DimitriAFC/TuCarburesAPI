package com.company.TuCarbures.Classes;

public class User {
    public String id;
    public String userName;
    public String favoriteStation;
    public String favoriteFuel;
    public String adress;
    public String zipCode;
    public String city;
    public String numberPhone;
    public String password;
    public String email;

    public User(String id, String userName, String favoriteStation,String favoriteFuel, String adress, String zipCode, String city, String numberPhone, String password, String email) {

        this.id = id;
        this.userName = userName;
        this.favoriteStation = favoriteStation;
        this.favoriteFuel = favoriteFuel;
        this.adress = adress;
        this.zipCode = zipCode;
        this.city = city;
        this.numberPhone = numberPhone;
        this.password = password;
        this.email = email;

    }
}

