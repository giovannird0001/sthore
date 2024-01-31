package com.sthore.msOperador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sthore.msOperador.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
 
}