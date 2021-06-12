package com.nhanhv.ecommerce.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    private int id;
    private String name;
    private String status;
    private double amount;
    private String username;
    private String password;

    public User() { }

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

    @Column(name = "amount", nullable = true)
    public double getAmount() {return amount;}
    public void setAmount(double amount) {this.amount = amount;}

    @Column(name = "status", nullable = false)
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}