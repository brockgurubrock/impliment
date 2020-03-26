package com.ecommercedemo.ecommerce.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommercedemo.ecommerce.entity.Product;
import com.ecommercedemo.ecommerce.entity.ProductShopDetails;

@Repository
public interface ProductShopDetailsRepository extends JpaRepository<ProductShopDetails, Long> {

	//@Query("from productShopdetailRepository l where l.productid=:productShopdetailRepository.productid and l.shopid=:productShopdetailRepository.shopid")
	public ProductShopDetails findByShopShopIdAndProductProductId(Long productId, Long shopId);
	public ProductShopDetails findByProduct(Optional<Product> product);

}
