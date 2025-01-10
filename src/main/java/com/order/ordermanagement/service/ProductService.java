package com.order.ordermanagement.service;

import java.util.List;
import java.util.Optional;

import com.order.ordermanagement.entity.ProductEntity;


public interface ProductService {
	List<ProductEntity> findAllProducts();
	Optional<ProductEntity> findProductById(Long id);
	ProductEntity saveProduct(ProductEntity productEntity);
	ProductEntity updateProduct(ProductEntity productEntity);
	void deleteProduct(Long id);
}
