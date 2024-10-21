package personal_expense_manager._Category;

import java.io.Serializable;

public class Category implements Serializable{
	private static final long serialVersionUID = 1L;
	
		private Long categoryId = System.currentTimeMillis();
		private String name;
		
		public Category(String name) {
			this.name = name;
		}
		public Category(Long categoryId, String name) {
			this.categoryId = categoryId;
			this.name = name;
		}
		
		public Category() {
			
		}
		
		public Long getCategoryId() {
			return categoryId;
		}
		
		public void setCategoryId(Long categoryId) {
			this.categoryId = categoryId;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name= name;
		}
		
		public static void main(String[] args) {
		
	}
}

