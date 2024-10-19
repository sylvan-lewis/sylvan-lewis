package personal_expense_manager._Category;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static final String[] MONTHS = 
									{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	public static Date stringToDate(String dateAsString) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			return df.parse(dateAsString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static String dateToString(Date date) {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			return df.format(date);
		

	}

	public static String getYearAndMonth (Date date) {
		SimpleDateFormat df = new SimpleDateFormat ("yyyy,MM");
		return df.format(date);
	}
	
	public static Integer getYear (Date date) {
		SimpleDateFormat df = new SimpleDateFormat ("yyyy");
		//String yearString = df.format(date);
		return Integer.parseInt(df.format(date));
	}
	
	public static String getMonthName(Integer monthNo) {
		if (monthNo < 1 || monthNo > 12) {
			throw new IllegalArgumentException("Month must be between 1-12");
		}
		return MONTHS[monthNo - 1 ];
		
		// validate that its within the range of normal calendar months 1-12
	}
}
