package com.service;

import org.springframework.stereotype.Component;

import com.Entity.Books;
import com.Entity.Inventory;
import com.Request.InventoryRequest;

import net.minidev.json.JSONObject;

@Component
public interface InventoryService {
	public JSONObject getAllInventory();
	public JSONObject createInventory(InventoryRequest req);
	public JSONObject deleteInventory(int id);
	public JSONObject updateInventory(Inventory inventory);

}
