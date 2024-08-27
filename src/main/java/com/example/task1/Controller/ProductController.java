package com.example.task1.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.task1.entity.Product;
import com.example.task1.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	public ProductService ps;
	
	@GetMapping("/products")
	public Collection<Product> getallproduct() {
		return ps.getallproduct();
	}
	
	@PostMapping("/products")
	public Product addproduct(@RequestBody Product p ) {
		return ps.addproduct(p);
		
	}
	
	@GetMapping("/products/{id}")
	public Product getoneprod(@PathVariable Integer id) {
		
		return ps.getonebyid(id);
		
	}
	@PutMapping("/products/{id}")
	
	public Product updatePassword(@PathVariable int id, @RequestBody Product updatedprod) {
		Product existprod = ps.getonebyid(id);
		
		return ps.updateproduct(updatedprod, existprod);
	
	}
	
	@DeleteMapping("/products/{id}")
	
	public String deleteproduct(@PathVariable int id) {
		return ps.deleteproduct(id);
	}
	

	
}
