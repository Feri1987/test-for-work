/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalog.dao;


import com.catalog.entity.Product;

import java.util.List;

/**
 *
 * @author Denis
 */
public interface ProductDAO {
    
    void create(Product t);
    
    List<Product> read();
    
    void update(Product t);
    
    void delete(Product t);
    
    Product getOneById(int id);
    
}
