package com.example.repository;

import com.example.domain.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {
    // PanacheRepository fournit des méthodes CRUD de base

    public Product findByName(String name) {
        return find("name", name).firstResult();
    }

//    public List<Product> findExpensiveProducts(Double price) {
//        return find("price > ?1", price).list();
//    }
}
