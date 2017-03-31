/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalog.services;

import com.catalog.entity.Product;
import java.util.List;

/**
 *
 * @author Denis
 */
public interface ProductService {
    
    List<Product> read();

    void delete(Product t);
    
    Product getOne(int id);

    Product createProductFromRequestParam(String name, String description, Double price);

    void updateProductFromRequestParams(int id, String name, String description, Double price);
}
