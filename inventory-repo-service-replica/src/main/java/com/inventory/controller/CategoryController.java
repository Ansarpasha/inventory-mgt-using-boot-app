package com.inventory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inventory.entity.Category;
import com.inventory.repo.CategoryJpa;

@Controller
public class CategoryController {
	@Autowired
	private CategoryJpa categoryJpa;
	
	@RequestMapping("/addSampleCategory")
	public @ResponseBody String addSampleCategory() {
		List<Category> categories = new ArrayList<>();
		Category category1 = new Category();
		category1.setCategoryName("Mobile Essentails");
		Category category2 = new Category();
		category2.setCategoryName("Mobile");
		categories.add(category1);
		categories.add(category2);
		
		for(Category category : categories){
			categoryJpa.create(category);
		}
		return "added categories";
	}
}
