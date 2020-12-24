package com.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Request.InventoryRequest;
import com.service.InventoryService;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/admin/inventory-management")
public class InventoryRestController {
	@Autowired
	InventoryService inventoryService;
	
	
	@PostMapping("/create-inventory")
	public JSONObject createInventory(@RequestBody InventoryRequest req) {
		return inventoryService.createInventory(req);
	}
	@GetMapping("/get-all")
	public JSONObject getAllInventory() {
		return  inventoryService.getAllInventory();
	}
	
	

}
