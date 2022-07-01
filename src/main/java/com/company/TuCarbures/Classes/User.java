package com.company.TuCarbures.Classes;

public class User {
    private String id;
    private String userName;
    private String favoriteStation;
    private String favoriteFuel;
    private String adress;
    private String zipCode;
    private String city;
    private String numberPhone;
    private String password;
    private String email;

    public User(String id, String userName, String favoriteStation, String favoriteFuel, String adress, String zipCode,
                String city, String numberPhone, String password, String email) {

        this.setId(id);
        this.setUserName(userName);
        this.setFavoriteStation(favoriteStation);
        this.setFavoriteFuel(favoriteFuel);
        this.setAdress(adress);
        this.setZipCode(zipCode);
        this.setCity(city);
        this.setNumberPhone(numberPhone);
        this.setPassword(password);
        this.setEmail(email);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFavoriteStation() {
        return favoriteStation;
    }

    public void setFavoriteStation(String favoriteStation) {
        this.favoriteStation = favoriteStation;
    }

    public String getFavoriteFuel() {
        return favoriteFuel;
    }

    public void setFavoriteFuel(String favoriteFuel) {
        this.favoriteFuel = favoriteFuel;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

