package groupproject2026;
// LiveExample 10.1
import java.util.Scanner;
import alkearse from "./usernames/alkearse/User_Formulas.js";
import aschrader from "./usernames/aschrader/User_Formulas.js";
import cethompson7 from "./usernames/cethompson7/User_Formulas.js";
import cfrederic from "./usernames/cfrederic/User_Formulas.js";
import cmobrien3 from "./usernames/cmobrien3/User_Formulas.js";


public class TestLoanClassTemplate {
  /** Main method */
  public static void main(String[] args) {
	// Create a Scanner
    Scanner input = new Scanner(System.in);

    System.out.println("Enter the username for your waketech account to run your formulas: ");
    String username = input.nextLine().trim();

    // Enter yearly interest rate
    System.out.print(
      "Enter annual interest rate, for example, 8.25: ");
    double annualInterestRate = input.nextDouble();

    // Enter number of years
    System.out.print("Enter number of years as an integer: ");
    int numberOfYears = input.nextInt();

    // Enter loan amount
    System.out.print("Enter loan amount, for example, 120000.95: ");
    double loanAmount =  input.nextDouble();
    
    //11/9
    // Enter extra payment amount
    System.out.print("Enter extra payment amount, for example, 1000.00: ");
    double extraPaymentAmount =  input.nextDouble();

    // Create Loan object
    Loan loan =
      new Loan(annualInterestRate, numberOfYears, loanAmount);

    // Display loan date, monthly payment, and total payment, and total interest
    System.out.printf("The loan was created on %s%n" +
      "The monthly payment is %.2f%nThe total payment is %.2f%nThe total interest is %.2f%n%n",
      loan.getLoanDate().toString(),
      loan.getMonthlyPayment(), 
      loan.getTotalPayment(),
      loan.getTotalInterest());
    
    extraPayFirstMonth(loan, extraPaymentAmount);
    System.out.println();
    extraPayEveryMonth(loan, extraPaymentAmount);
  }
  
  /** Extra payment first month only */
  	try {
  		// Build a class name dynamically
  		String className = "usernames." + username + ".User_Formulas";
  		// Load the class
		Class<?> userClass = Class.forName(className);
		// Get the method you want to call
		var method = userClass.getMethod("extraPayFirstMonth", Loan.class, double.class);
		// Call the method 
		Object result = method.invoke(null, loan, extraPaymentAmount);
		// Print the result
		System.out.println("Result: " + result);
		// Catch the exception.
	} catch (Exception e) {System.out.println("Could not find a method for that username.");}

  	try {
  		// Build a class name dynamically
  		String className = "usernames." + username + ".User_Formulas";
  		// Load the class
		Class<?> userClass = Class.forName(className);
		// Get the method you want to call
		var method = userClass.getMethod("extraPayEveryMonth", Loan.class, double.class);
		// Call the method 
		Object result = method.invoke(null, loan, extraPay);
		// Print the result
		System.out.println("Result: " + result);
		// Catch the exception.
	} catch (Exception e) {System.out.println("Could not find a method for that username.");}
