/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalog.services;

import com.catalog.dao.ProductDAO;
import com.catalog.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Denis
 */
@Service
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<Product> read() {
        return productDAO.read();
    }

    @Override
    public void delete(Product t) {
        productDAO.delete(t);
    }

    @Override
    public Product getOne(int id) {
        return productDAO.getOneById(id);
    }

    @Override
    public Product createProductFromRequestParam(String name, String description, Double price) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        productDAO.create(product);

        return product;
    }

    @Override
    public void updateProductFromRequestParams(int id, String name, String description, Double price) {
        Product product = new Product(id, name, description, price);
        productDAO.update(product);
    }

}
