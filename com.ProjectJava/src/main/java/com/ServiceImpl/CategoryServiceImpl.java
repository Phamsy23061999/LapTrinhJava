package com.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.CategoryDAO;
import com.Entity.CategoryEntity;

import net.minidev.json.JSONObject;

@Service
public class CategoryServiceImpl{
	@Autowired 
	private CategoryDAO categoryDAO;
	
	public JSONObject Save(CategoryEntity entity) {
		
		JSONObject js = new JSONObject();
		
		js.put("Category", categoryDAO.SaveCategory(entity));
		
		return js;
		
	}
	public JSONObject update (int id) {
		JSONObject js = new JSONObject();
		
		js.put("Category", categoryDAO.updateCategory(id));
		
		return js;
	}
}
