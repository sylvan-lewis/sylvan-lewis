package personal_expense_manager._Category;

public class Category {

		private String categoryId;
		private String name;
		
		public Category(String name) {
			this.name = name;
		}
		public Category(String categoryId, String name) {
			this.categoryId = categoryId;
			this.name = name;
		}
		
		public Category() {
			
		}
		
		public String getCategoryId() {
			return categoryId;
		}
		
		public void setCategoryId(String categoryId) {
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

