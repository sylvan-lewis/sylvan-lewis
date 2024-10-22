package personal_expense_manager._Category;


import java.io.IOException;
import java.util.Scanner;

public class StartApp {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);  // Use a Scanner for user input

        // First, validate login before showing the menu
        if (login(scanner)) {
            // If login is successful, show the chatbot menu
            Chatbot chat = new Chatbot();  // Ensure Chatbot is correctly imported
            chat.showMenu();  // Ensure showMenu() method exists in Chatbot class
        } else {
            // If login fails, exit the application
            System.out.println("Login failed. Exiting application.");
            System.exit(0);  // Terminate the program if login fails
        }

        // Close the scanner after all input operations are done
        scanner.close();
    }

    // Login method to validate username and password
    private static boolean login(Scanner scanner) {
        System.out.println("----- Login -----");

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();  // Capture username input

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();  // Capture password input

        // Check if the username and password are valid (assuming Authenticator class exists)
        if (Authenticator.validateLogin(username, password)) {
            System.out.println("Login successful!");
            return true;  // Successful login
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return false;  // Failed login
        }
    }
}
