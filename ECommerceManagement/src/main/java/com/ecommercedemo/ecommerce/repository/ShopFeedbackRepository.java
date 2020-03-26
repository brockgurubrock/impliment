package com.ecommercedemo.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommercedemo.ecommerce.entity.ShopFeedback;

@Repository
public interface ShopFeedbackRepository extends JpaRepository<ShopFeedback,Long> {

}
