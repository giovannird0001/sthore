package com.sthore.msOperador.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sthore.msOperador.models.Product;
import com.sthore.msOperador.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
       public void saveSampleProducts(List<Product> sampleProducts) {
        for (Product product : sampleProducts) {
            // Puedes realizar cualquier lógica de negocio aquí antes de guardar el producto
            productRepository.save(product);
        }
    }
}