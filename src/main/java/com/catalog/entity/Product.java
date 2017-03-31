/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalog.entity;

import javax.persistence.*;

/**
 *
 * @author Denis
 */
@Entity
@Table(name = "PRODUCT")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "PRICE")
    private Double price;
    
    @Column(name = "DESCRIPTION")
    private String description;

    public Product() {
    }

    public Product(Integer id, String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }
    public Product(Integer id) {
        this.id = id;
    }

    public Product(String name, Double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    
}
