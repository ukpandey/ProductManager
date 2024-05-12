package com.example.ProductSpringWeb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	ProductRepository repo;
	
	public List<Product> findAllProducts() {
		List<Product> prods = (List<Product>) repo.findAll();
		return prods;
	}
	
	public List<Product> findProductsByType(String type){
		return repo.findByType(type);

	}

	public List<Product> findProductsByPlace(String place) {
		return repo.findByPlace(place);
	}
	
	public Optional<Product> findProductsById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}
	
	// For POST Request
    public Product saveProduct(Product product) {
        return repo.save(product);
    }


	public boolean existsById(int id) {
		return repo.existsById(id);
	}

	public void removeProduct(int id) {
	  repo.deleteById(id);	
	}

}
