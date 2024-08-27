package com.example.task1.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer cid;
	
	@Column(unique = true)
	public String name;
	
	public String description;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
	public List<Product> products;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(Integer cid, String name, String description, List<Product> products) {
		super();
		this.cid = cid;
		this.name = name;
		this.description = description;
		this.products = products;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", name=" + name + ", description=" + description + ", products=" + products
				+ "]";
	}

	
	
	
	

}
