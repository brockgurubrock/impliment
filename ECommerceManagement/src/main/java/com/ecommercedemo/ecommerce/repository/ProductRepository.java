package com.ecommercedemo.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommercedemo.ecommerce.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
