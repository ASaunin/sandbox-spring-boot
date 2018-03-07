package com.asaunin.service;

import com.asaunin.domain.Product;
import com.asaunin.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> listAll() {
        final List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public Product getById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product saveOrUpdate(Product product) {
        productRepository.save(product);
        return product;
    }

    public void delete(String id) {
        productRepository.deleteById(id);
    }

}
