package com.order.ordermanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.order.ordermanagement.entity.ProductEntity;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, Long>{

}
