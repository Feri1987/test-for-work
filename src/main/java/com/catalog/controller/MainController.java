/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalog.controller;

import com.catalog.entity.Product;
import com.catalog.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Denis
 */
@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listProducts(ModelMap model, @RequestParam(required = false) String successMessage) {
        List<Product> list = productService.read();
        model.addAttribute("list", list);
        model.addAttribute("successMessage", successMessage);
        return "list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView saveNewProduct(@RequestParam String name,
                                 @RequestParam String description,
                                 @RequestParam Double price,
                                 ModelAndView model, RedirectAttributes redirect) {

        productService.createProductFromRequestParam(name, description, price);

        redirect.addAttribute("successMessage", "Add new product successful!");
        model.setViewName("redirect:/list");

        return model;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView getUpdatePage(@RequestParam int id, ModelAndView model) {

        Product selectedProduct = productService.getOne(id);

        model.setViewName("update");
        model.addObject("product", selectedProduct);

        return model;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateAction(@RequestParam int id,
                                     @RequestParam String name,
                                     @RequestParam String description,
                                     @RequestParam Double price,
                                     ModelAndView model,
                                     RedirectAttributes redirect) {

        productService.updateProductFromRequestParams(id, name, description, price);

        model.setViewName("redirect:/list");
        redirect.addAttribute("successMessage", String.format("product updated id : %s", id));

        return model;
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam int id, RedirectAttributes redirect) {
        productService.delete(new Product(id));
        redirect.addAttribute("successMessage", String.format("product is deleted id = %s !", id));
        return "redirect:/list";
    }
}
