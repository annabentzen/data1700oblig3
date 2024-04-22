package com.example.data1700oblig3v2;

public class Order {
    private String movie;
    private int quantity;
    private String firstname;
    private String surname;
    private String email;
    private String phone;

    public Order() {
    }

    public Order(String movie, int quantity, String firstname, String surname, String email, String phone) {
        this.movie = movie;
        this.quantity = quantity;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}