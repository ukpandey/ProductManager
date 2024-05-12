package com.example.ProductSpringWeb;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	List<Product> findByType(String type);
	List<Product> findByPlace(String place);
}
