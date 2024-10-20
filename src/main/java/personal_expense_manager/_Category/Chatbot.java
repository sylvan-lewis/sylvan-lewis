package personal_expense_manager._Category;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Chatbot {
	
	Repository repo = Repository.getRepository();
	
	ReportService reportService = new ReportService();
	
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
		
		System.out.println("Enter Date (DD/MM/YYYY): ");
		String dateAsString = s.nextLine();
		Date date = DateUtil.stringToDate(dateAsString);
		
		
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
		
	    if (repo.expList == null || repo.expList.isEmpty()) {
	        System.out.println("No expenses found.");
	        return;
	    }		
		
		for (int i = 0; i <expList.size();i++) {
			Expense exp = expList.get(i);
			
			String catName = reportService.getCategoryName(exp.getCategoryId());
			if (catName == null) {
	            catName = "Unknown Category"; // Handle null category name
	        }
			
			String dateString = DateUtil.dateToString(exp.getDate());
			
			if (dateString == null) {
	            dateString = "Invalid Date"; // Handle null or invalid date
	        }

			String remark = exp.getRemark();
	        if (remark == null) {
	            remark = "No Remark"; // Default message for missing remarks
	        }
			
	        String formattedAmount = String.format("%.2f", exp.getAmount());
			
			System.out.println((i + 1) + ". " + catName + ", " + exp.getCategoryId() + ", " + exp.getAmount() + ", " + exp.getRemark() + ", " + dateString);
			
		}
		
	}
	
	private void onMonthlyExpenseList() {
		System.out.println("Monthly Expense Total...");
		Map <String, Float> resultMap = reportService.calculateMonthlyTotal();
		Set <String> keys = resultMap.keySet();
		for (String yearMonth : keys) {
			String [] arr = yearMonth.split(", ");
			String year = arr[0];
			Integer monthNo = new Integer(arr[1]);
			String monthName = DateUtil.getMonthName(monthNo);
			System.out.println(year + ", " + monthName + " : " + resultMap.get(yearMonth));
		}
	}


	private void onYearlyExpenseList() {
		System.out.println("Yearly Expense Total...");
		Map<Integer, Float> resultMap = reportService.calculateYearlyTotal();
		Set<Integer> years = resultMap.keySet();
		Float total = 0.0F;
		for (Integer year : years) {
			Float exp = resultMap.get(year);
			total = total + exp;
			System.out.println(year + " : " + resultMap.get(year));
		}
		System.out.println("----------------------------------");
		System.out.println("Total Expenses(INR): " + total);
	}


	private void onCategorizedExpenseList() {
		System.out.println("Category wise Expense Listing...");
		Map <String, Float> resultMap = reportService.calculateCategoriedTotal();
		Set <String> categories = resultMap.keySet();
		Float netTotal = 0.0F;
		for (String categoryName : categories) {
			Float catWiseTotal = resultMap.get(categoryName);
			netTotal = netTotal + catWiseTotal;
			System.out.println(categoryName + " : " + catWiseTotal);			
		}
		System.out.println("--------------------------------");
		System.out.println("Net Total : " + netTotal);
	}
	
	private void onExit() {
		System.exit(0);
		
	}
	
	
	} 
