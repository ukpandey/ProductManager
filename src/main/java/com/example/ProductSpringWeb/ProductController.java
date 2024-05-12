package com.example.ProductSpringWeb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping("products/all")
	public List<Product>  getAllProducts() {
		return service.findAllProducts();
	}
	
	@GetMapping("/products/id/{id}")
	public Optional<Product> getProdById(@PathVariable int id) {
		return service.findProductsById(id);
	}
	
	@GetMapping("/products/type/{type}")
	public List<Product> getProdByType(@PathVariable String type) {
		return service.findProductsByType(type);
	}
	
	@GetMapping("/products/place/{place}")
	public List<Product> getProdByPlace(@PathVariable String place){
		return service.findProductsByPlace(place);
	}
	
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }
    
    @PutMapping("/products/id/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        // Check if the product with the given id exists
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }


        // Update the product in the database
        Product savedProduct = service.saveProduct(updatedProduct);

        // Return the updated product
        return ResponseEntity.ok(savedProduct);
    }
    
    @DeleteMapping("products/id/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        if (!service.existsById(id)) {
            return new ResponseEntity<String>("Record not found", HttpStatus.NOT_FOUND);
        }
        
        service.removeProduct(id);
        return new ResponseEntity<String>("Record with "+id+ "deleted", HttpStatus.OK);
    }

}
