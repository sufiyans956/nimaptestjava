package com.example.task1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.task1.entity.Category;



@Repository
public interface Categoryrepository extends JpaRepository<Category, Integer> {

}
