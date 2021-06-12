package com.nhanhv.ecommerce.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    private int id;
    private String name;
    private double price;
    private String image;
    private String status;

    public Product() { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Column(name = "price", nullable = true)
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    @Column(name = "image", nullable = true)
    public String getImage() {return image; }
    public void setImage(String image) { this.image = image; }

    @Column(name = "status", nullable = false)
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}