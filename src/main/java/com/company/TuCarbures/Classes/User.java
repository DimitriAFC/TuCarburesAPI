package com.company.TuCarbures.Classes;

public class User {
    public String idUser;
    public String userName;
    public String favoriteStation;
    public String adress;
    public int zipCode;
    public String city;
    public int numberPhone;
    public String password;
    public String email;

    public User(String idUser, String userName, String favoriteStation, String adress, int zipCode, String city, int numberPhone, String password, String email) {

        this.idUser = idUser;
        this.userName = userName;
        this.favoriteStation = favoriteStation;
        this.adress = adress;
        this.zipCode = zipCode;
        this.city = city;
        this.numberPhone = numberPhone;
        this.password = password;
        this.email = email;

    }
}

