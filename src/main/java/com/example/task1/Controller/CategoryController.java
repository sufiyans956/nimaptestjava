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

import com.example.task1.entity.Category;
import com.example.task1.service.CategoryService;



@RestController
@RequestMapping("/api")

public class CategoryController {
	
@Autowired
 public CategoryService cs;

	@GetMapping("/categories")
	public Collection<Category> getallcategory() {
		return cs.getallcategory();
	}
	
	@PostMapping("/categories")
	public Category addcategory(@RequestBody Category c ) {
		return cs.addcategory(c);
		
	}
	
	@GetMapping("/categories/{id}")
	public Category getonecat(@PathVariable Integer id) {
		
		return cs.getonebyid(id);
		
	}
	@PutMapping("/categories/{id}")
	
	public Category updatePassword(@PathVariable int id, @RequestBody Category updatedcat) {
		Category existcat = cs.getonebyid(id);
		
		return cs.updatecategory(updatedcat, existcat);
	
	}
	
	@DeleteMapping("/categories/{id}")
	
	public String deletecateorgy(@PathVariable int id) {
		return cs.deletecat(id);
	}
		
	
}
