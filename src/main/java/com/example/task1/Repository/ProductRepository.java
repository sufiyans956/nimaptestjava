package com.example.task1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.task1.entity.Product;



public interface ProductRepository extends JpaRepository<Product, Integer> {

}
