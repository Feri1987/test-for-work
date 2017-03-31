/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalog.dao;

import com.catalog.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Denis
 */
@Component
@Transactional
public class ProductDAOImpl implements ProductDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Product t) {
        sessionFactory.getCurrentSession().save(t);
    }

    @Override
    public List<Product> read() {
        List<Product> list =  sessionFactory.getCurrentSession().createQuery("FROM Product").list();
        return list;
    }

    @Override
    public void update(Product t) {
        Product old = (Product) sessionFactory.getCurrentSession().get(Product.class, t.getId());
        old.setName(t.getName());
        old.setPrice(t.getPrice());
        old.setDescription(t.getDescription());
        sessionFactory.getCurrentSession().update(old);
    }

    @Override
    public void delete(Product t) {
        Product del = (Product) sessionFactory.getCurrentSession().get(Product.class, t.getId());
        sessionFactory.getCurrentSession().delete(del);

    }

    @Override
    public Product getOneById(int id) {
        Product findOne = (Product) sessionFactory.getCurrentSession().get(Product.class, id);
        return findOne;
    }
    
}
