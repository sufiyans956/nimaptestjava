package com.example.task1.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task1.Repository.ProductRepository;

import com.example.task1.entity.Product;

@Service
public class ProductService {
	@Autowired 
	public ProductRepository prodrepo;
	
	public Collection<Product> getallproduct() {

		return prodrepo.findAll();
	}

	public Product addproduct(Product p) {

		return prodrepo.save(p);
	}
	
	public Product getonebyid(int id) {
		Product foundprod = null;
		Optional<Product> getOneprod = prodrepo.findById(id);
		if (!getOneprod.isEmpty())
			foundprod = getOneprod.get();
		return foundprod;
	}
	
	public Product updateproduct(Product oldprod,Product newprod) {
		oldprod.setName(newprod.getName());
		oldprod.setPrice(newprod.getPrice());
		prodrepo.save(oldprod);
		return oldprod;
	}
	public String deleteproduct(int id) {	
		prodrepo.deleteById(id);
		return "product From Id : "+id+" is Deleted";
	}

}
