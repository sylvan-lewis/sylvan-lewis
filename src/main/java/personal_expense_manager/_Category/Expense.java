package personal_expense_manager._Category;

import java.util.Date;

public class Expense {
	//private String expenseId //= System.currentTimeMillis();
	private String categoryId; 
	private Float amount;
	private Date date;
	private String remark; // type of entry expense or income
	
	public Expense() {
		
	}
	
	
	
	public Expense(String categoryId, Float amount, Date date, String remark) {
		super();
		this.categoryId = categoryId;
		this.amount = amount;
		this.date = date;
		this.remark = remark;
	}


	public String getCategoryId() {return categoryId;}

	public void setCategoryId(String categoryId) {this.categoryId = categoryId;}

	public Float getAmount() {return amount;}

	public void setAmount(Float amount) {this.amount = amount;}

	public Date getDate() {return date;}

	public void setDate(Date date) {this.date = date;}

	public String getRemark() {return remark;}

	public void setRemark(String remark) {this.remark = remark;}

}
