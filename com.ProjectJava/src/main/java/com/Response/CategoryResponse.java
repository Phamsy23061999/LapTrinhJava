package com.Response;

public class CategoryResponse {
	
	public static class CreateCategoryResqonse{
		
		public String category_name;
		public String description;
		public String note;
		public CreateCategoryResqonse() {
			
		}
		public CreateCategoryResqonse( String category_name,String description, String note ) {
			this.category_name = category_name;
			this.description = description;
			this.note = note;
		}
		
		
		public String getCategory_name() {
			return category_name;
		}
		public void setCategory_name(String category_name) {
			this.category_name = category_name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
	}
	

}
