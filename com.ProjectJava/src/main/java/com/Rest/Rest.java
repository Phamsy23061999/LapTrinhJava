package com.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.CategoryEntity;
import com.ServiceImpl.CategoryServiceImpl;
import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/category")

public class Rest {
	@Autowired
	private CategoryServiceImpl categoryImpl;
	
	
	@GetMapping("/save_category")
	public JSONObject SaveCategory( CategoryEntity entity) {
		return categoryImpl.Save(entity);
	}
	
	
	@PostMapping("/save")
	public JSONObject Save(@RequestBody CategoryEntity entity) {
		return categoryImpl.Save(entity);
	}
	
	@GetMapping("/update")
	public JSONObject update(int id) {
		return categoryImpl.update(id);
	}
	

}
