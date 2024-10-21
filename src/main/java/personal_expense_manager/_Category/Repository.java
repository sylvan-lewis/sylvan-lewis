package personal_expense_manager._Category;

import java.util.ArrayList;
import java.util.List;

//Database class
public class Repository {

	public List <Expense> expList = new ArrayList<>();
	public List <Category> catList = new ArrayList<>();
	private static Repository repository;
	private Repository() {
	//catList	= new ArrayList<>();
	//expList	= new ArrayList<>();
	}
	public static Repository getRepository() {
		if(repository == null){
			repository = new Repository();
	}
	return repository;
	}
}
