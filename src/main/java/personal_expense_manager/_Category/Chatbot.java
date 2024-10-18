package personal_expense_manager._Category;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Chatbot {
	Repository repo = Repository.getRepository();
	
	private Scanner s = new Scanner(System.in);
	private int choice;
	public void showMenu() {
		while (true) {
			printMenu();
			switch(choice) {
			//add category logic goes here
			case 1:
				onAddCategory();
				pressAnyKeyToContinue();
				break;
			case 2:
				onCategoryList();
				pressAnyKeyToContinue();
				break;
			case 3:
				onExpenseEntry();
				pressAnyKeyToContinue();
				break;
			case 4:
				onExpenseList();
				pressAnyKeyToContinue();
				break;
			case 5:
				onMonthlyExpenseList();
				pressAnyKeyToContinue();
				break;
			case 6:
				onYearlyExpenseList();
				pressAnyKeyToContinue();
				break;
			case 7:
				onCategorizedExpenseList();
				pressAnyKeyToContinue();
				break;	
			case 0:
				onExit();
					break;
				
				
				
			}
		}
	}
	

	


	//private void expenseEntry() {
	//	throw new UnsupportedOperationException("Not supported yet.");
		
	//}

	public void printMenu() {
		System.out.println("-----Welcome to YourExpense!-----");
		System.out.println("1. Add Category");
		System.out.println("2. Category List");
		System.out.println("3. Expense Entry");
		System.out.println("4. Expense List");
		System.out.println("5. Monthly Expense List");
		System.out.println("6. Yearly Expense List");
		System.out.println("7. Categorized Expense List");
		System.out.println("0. Exit");
		System.out.println("----------------------------------");
		System.out.println("Enter your choice: ");
		choice = s.nextInt();
		
	}
	
	
	public void pressAnyKeyToContinue() {
		System.out.println("Press any key to continue...");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void onAddCategory() {
		s.nextLine();
		System.out.print("Enter Category Name: ");
		String catName = s.nextLine();
		Category cat = new Category(catName);
		repo.catList.add(cat);
		System.out.println("Success: Category Added: ");
	}
	
	public void onCategoryList() {
		System.out.println("Category List");
		List<Category> clist = repo.catList;
		for(int i = 0; i < clist.size(); i++) {
			Category c=clist.get(i);
			System.out.println((i + 1) + ". " + c.getName() + ", "+ c.getCategoryId());
			
		}
	}

	
	public void onExpenseEntry() {
		System.out.println("Enter Details for Expense Entry...");
		onCategoryList();
		System.out.println("Choose category: ");
		int catChoice = s.nextInt();
		Category selectedCat = repo.catList.get(catChoice-1);
		
		System.out.println("Enter Amount : ");
		float amount = s.nextFloat();
		
		System.out.println("Enter Remark : ");
		s.nextLine();
		String remark = s.nextLine();
		
		Date date = new Date ();
		
		Expense exp = new Expense();
		exp.setCategoryId(selectedCat.getCategoryId());
		exp.setAmount(amount);
		exp.setRemark(remark);
		exp.setDate(date);
		
		repo.expList.add(exp);
		System.out.println("Success: Expense Added");
		
	}
	
	private void onExpenseList() {
		System.out.println("Expense Listing...");
		List<Expense> expList = repo.expList;
		for (int i = 0; i <expList.size();i++) {
			Expense exp = expList.get(i);
			System.out.println((i + 1) + ". " + exp.getCategoryId() + ", " + exp.getAmount() + ", " + exp.getRemark() + ", " + exp.getDate());
			
		}
		
	}
	
	private void onMonthlyExpenseList() {
		System.out.println("Monthly Expense Listing...");
		
	}


	private void onYearlyExpenseList() {
		System.out.println("Yearly Expense Listing...");
		
	}


	private void onCategorizedExpenseList() {
		System.out.println("Category wise Expense Listing...");
		
	}
	
	private void onExit() {
		System.exit(0);
		
	}
	
}
