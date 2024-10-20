package personal_expense_manager._Category;

import java.io.*;
import java.util.Scanner;

public class Authenticator {

    // Method to validate login credentials
    public static boolean validateLogin(String username, String password) {
        // Try-with-resources to automatically close the file reader
        try (Scanner scanner = new Scanner(new File("C:/Users/Sylvan/Desktop/obsidi_project/src/main/java/personal_expense_manager/_Category/users.txt"))){
            while (scanner.hasNextLine()) {
                String[] credentials = scanner.nextLine().split(",");

                // Ensure the line contains both username and password
                if (credentials.length == 2) {
                    String fileUsername = credentials[0].trim();
                    String filePassword = credentials[1].trim();

                    // Validate credentials
                    if (fileUsername.equals(username) && filePassword.equals(password)) {
                        return true; // Login successful
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading users.txt file: " + e.getMessage());
        }

        return false; // Return false if login fails
    }
}