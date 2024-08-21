package com.example.service;

import com.example.domain.Product;
import com.example.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    public List<Product> listAll() {
        return productRepository.listAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findByIdOptional(id);
    }

    @Transactional
    public Product createProduct(Product product) {
        productRepository.persist(product);
        return product;
    }

    @Transactional
    public Optional<Product> updateProduct(Long id, Product updatedProduct) {
        Optional<Product> productOptional = productRepository.findByIdOptional(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.name = updatedProduct.name;
            product.price = updatedProduct.price;
            product.description = updatedProduct.description;
            return Optional.of(product);
        }
        return Optional.empty();
    }

    @Transactional
    public boolean deleteProduct(Long id) {
        return productRepository.deleteById(id);
    }

    public long countProducts() {
        return productRepository.count();
    }
}
