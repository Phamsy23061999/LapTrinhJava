package com.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Books;
import com.Entity.Inventory;
import com.Repository.BooksRepository;
import com.Repository.InventoryRepository;
import com.Request.InventoryRequest;
import com.Response.InventoryResponse;
import com.service.InventoryService;

import net.minidev.json.JSONObject;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	InventoryRepository inventoryReposity;
	@Autowired
	BooksRepository bookRepository;
	@Override
	public JSONObject getAllInventory() {
		JSONObject data = new JSONObject();
		try {
			List<Inventory> listInventory = inventoryReposity.findAll();
			List<InventoryResponse>listIvenResponse = new ArrayList<InventoryResponse>();
			for(Inventory inventory : listInventory) {
				Books books = bookRepository.getBookById(inventory.getBooks().getId());
				InventoryResponse inventoryResponse = new InventoryResponse(inventory);
				inventoryResponse.setBooks(books);
				listIvenResponse.add(inventoryResponse);
			}
			data.put("is_success", true);
			data.put("items",listIvenResponse);
		} catch (Exception e) {
			data.put("is_success", false);
			data.put("Error","Lưu Không Thành Công");
		}
		
		return data;
	}
	@Override
	public JSONObject createInventory(InventoryRequest req) {
		JSONObject data = new JSONObject();
		try {
			Books books = bookRepository.getBookById(req.getBook_id());
			if(books == null) {
				throw new Exception("Không tìm Thấy Thông Tin Sách");
			}
			int updatebook = bookRepository.updateBookById(req.getQuantity(), books.getId());
			if(updatebook !=0) {
				int inventory = inventoryReposity.createInventory(req.getQuantity(),req.getReason() ,req.getBook_id(),req.getNumber_of_lost_books() );
			}else {
				throw new Exception("Tạo Phiếu Thất Bại");
			}
			data.put("is_success", true);
			data.put("message","Tạo Inventory Thành Công");
		} catch (Exception e) {
			data.put("is_success", false);
			data.put("Error","Lưu Không Thành Công");
		}
		return data;
	}
	
	@Override
	public JSONObject deleteInventory(int id) {
		JSONObject data = new JSONObject();
		try {
			int detleteInventory = inventoryReposity.deleteInventoryByid(id);
			data.put("is_success", true);
			data.put("message","Xóa Thành Công");
		} catch (Exception e) {
			data.put("is_success", false);
			data.put("Error","Xóa Không Thành Công");
		}
		return data;
	}
	@Override
	public JSONObject updateInventory(Inventory inventory) {
		JSONObject data = new JSONObject();
		try {
			Inventory inventorys = inventoryReposity.getOne(inventory.getId());
			if(inventorys == null ) {
				throw new Exception("Inventory Không Tồn Tại");
			}
//			data.put("is_success", true);
//			data.put("message",listIvenResponse);
		} catch (Exception e) {
			data.put("is_success", false);
			data.put("Error","Lưu Không Thành Công");
		}
		
		return data;
	}
	
	

}
