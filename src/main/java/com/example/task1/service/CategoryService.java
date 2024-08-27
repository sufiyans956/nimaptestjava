package com.example.task1.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.task1.Repository.Categoryrepository;
import com.example.task1.entity.Category;



@Service
public class CategoryService {
	@Autowired
	private Categoryrepository categorerepo;

	public Collection<Category> getallcategory() {

		return categorerepo.findAll();
	}

	public Category addcategory(Category c) {

		return categorerepo.save(c);
	}
	
	public Category getonebyid(int id) {
		Category foundcat = null;
		Optional<Category> getOnecat = categorerepo.findById(id);
		if (!getOnecat.isEmpty())
			foundcat = getOnecat.get();
		return foundcat;
	}
	
	public Category updatecategory(Category oldcat,Category newcat) {
		oldcat.setName(newcat.getName());
		categorerepo.save(oldcat);
		return oldcat;
	}
	public String deletecat(int id) {	
		categorerepo.deleteById(id);
		return "category From Id : "+id+" is Deleted";
	}
}
