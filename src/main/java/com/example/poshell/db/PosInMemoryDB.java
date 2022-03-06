package com.example.poshell.db;

import com.example.poshell.model.Cart;
import com.example.poshell.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections.IteratorUtils;
@Component
public class PosInMemoryDB implements PosDB {

    Logger logger = LoggerFactory.getLogger(PosInMemoryDB.class);

    private List<Product> products = new ArrayList<>();

    private Cart cart;

    private final ProductRepository repository;


    @Override
    public List<Product> getProducts() {

        Iterator<Product> myIterator = this.repository.findAll().iterator();
        List<Product> myList=IteratorUtils.toList(myIterator);

        return myList;
//        return products;
    }

    @Override
    public Cart saveCart(Cart cart) {
        this.cart = cart;
        return this.cart;
    }

    @Override
    public Cart getCart() {
        return this.cart;
    }

    @Override
    public Product getProduct(String productId) {
//        for (Product p : getProducts()) {
//            if (p.getId().equals(productId)) {
//                return p;
//            }
//        }
//
//        return null;
//
      Optional<Product> opt = this.repository.findById(productId);
      if(opt.isEmpty())
          return null;
      return opt.get();
    }

    private PosInMemoryDB(ProductRepository repository) {
        this.repository = repository;
        this.products.add(new Product("PD1", "iPhone 13", 8999));
        this.products.add(new Product("PD2", "MacBook Pro", 29499));
    }

}
