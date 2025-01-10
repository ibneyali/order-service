package com.order.ordermanagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.ordermanagement.entity.ProductEntity;
import com.order.ordermanagement.repository.ProductRepository;
import com.order.ordermanagement.service.ProductService;
import com.order.ordermanagement.service.SequenceGeneratorService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	 @Autowired
	 private SequenceGeneratorService sequenceGenerator;

	@Override
	public List<ProductEntity> findAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Optional<ProductEntity> findProductById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public ProductEntity saveProduct(ProductEntity productEntity) {
		long uniqueId = sequenceGenerator.generateSequence(ProductEntity.SEQUENCE_NAME);
		productEntity.setId(uniqueId);
		return productRepository.save(productEntity);
	}

	@Override
	public ProductEntity updateProduct(ProductEntity productEntity) {
		return productRepository.save(productEntity);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);	
	}

}