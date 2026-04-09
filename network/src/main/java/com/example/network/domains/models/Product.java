package com.example.network.domains.models;

public class Product {
    public Integer id;
    public String name;
    public String description;
    public Integer gender;
    public String expenditure;
    public Integer price;
    public String imageFile;

    public Product(String name, String description, Integer price, String expenditure, Integer gender, String imageFile) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.expenditure = expenditure;
        this.gender = gender;
        this.imageFile = imageFile;
    }

    public Product(Integer id, String name, String description, Integer price, String expenditure, Integer gender, String imageFile) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.expenditure = expenditure;
        this.gender = gender;
        this.imageFile = imageFile;
    }

    public Product(Integer id) {
        this.id = id;
    }
}
