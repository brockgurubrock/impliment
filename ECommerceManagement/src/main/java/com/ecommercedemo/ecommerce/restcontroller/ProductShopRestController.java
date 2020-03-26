package com.ecommercedemo.ecommerce.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommercedemo.ecommerce.dto.BuyProductRequestDTO;
import com.ecommercedemo.ecommerce.dto.SuccessResponseDTO;
import com.ecommercedemo.ecommerce.service.OrderDetailService;

@RestController
@RequestMapping("/productShopDetail")
public class ProductShopRestController {
	@Autowired
	private OrderDetailService orderDetailService;
	@PostMapping("/productShop")
	public ResponseEntity<SuccessResponseDTO>buyProduct(@RequestBody BuyProductRequestDTO buyProductRequestDTO)
	{
		orderDetailService.buyProduct(buyProductRequestDTO);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

}
