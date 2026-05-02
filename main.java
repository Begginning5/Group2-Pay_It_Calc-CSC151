// Load the PROJECT TESTING PACKAGES
import Fgroupproject2026.LoanTemplate;
// USER Project Package
import alkearse.alkerse;
import aschrader.aschrader;
import cethompson7.cethompson7;
import cfrederic.cfrederic;
import cmobrien3.cmobrien3;
// Load the USER FUNCTIONS FROM FILES
//import usernames.alkearse.user_Functions.java;
//import usernames.aschrader.user_Functions.java;
//import usernames.cethompson7.user_Functions.java;
//import usernames.cfrederic.user_Functions.java;
//import usernames.cmobrien3.user_Functions.java;
// GENERAL Java import statements
//import java.util.Scanner;

public class TestLoanClassTemplate {
  /** Main method */
  public static void main(String[] args) {
	// Create a Scanner
    Scanner input = new Scanner(System.in);

    // Enter yearly interest rate
    System.out.print("Enter annual interest rate, for example, 8.25: ");
    double annualInterestRate = input.nextDouble();

    // Enter number of years
    System.out.print("Enter number of years as an integer: ");
    int numberOfYears = input.nextInt();

    // Enter loan amount
    System.out.print("Enter loan amount, for example, 120000.95: ");
    double loanAmount =  input.nextDouble();
    
    //11/9 -- GOSH! 
    // Enter extra payment amount
    System.out.print("Enter extra payment amount, for example, 1000.00: ");
    double extraPaymentAmount =  input.nextDouble();

    // Create Loan object
    Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);

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
	  
  //------------------------------
  // Implement User Functions
  //------------------------------
	System.out.println();
	System.out.println("Enter the username to run the user functions (alkearse, aschrader, cethompson7, cfrederic, cmobrien3): ");
    System.out.println("To run the default functions enter Fgroupproject2026");
    String username = input.nextLine().trim();
    boolean runDefault = username.equals("Fgroupproject2026");
    System.out.println();
	System.out.println("NEXT:");

  //------------------------------
  // Function11: extraPayFirstMonth
  //------------------------------
  /** Extra payment first month only */

  	{try {
  		// Build a class name dynamically -- I think the default is good.  
      String className = (runDefault == true) ? "Fgroupproject2026.LoanTemplate" : username + "." + username;
  		// Load the class
		  Class<?> userClass = Class.forName(className);
		  // Get the method you want to call
		  var method = userClass.getMethod("extraPayFirstMonth", Loan.class, double.class);
		  // Call the method 
		  Object result = method.invoke(null, loan, extraPaymentAmount);
		  // Print the result
		  System.out.println("Result: " + result);
		  // Catch the exception.
	} catch (Exception e) {System.out.println("Could not find a method for that username.");}}
	  
  //------------------------------
  // Function12: extraPayEveryMonth
  //------------------------------
  	{try {
  		// Build a class name dynamically
      String className = (runDefault == true) ? "Fgroupproject2026.LoanTemplate" : username + "." + username;
  		// Load the class
		  Class<?> userClass = Class.forName(className);
		  // Get the method you want to call
		  var method = userClass.getMethod("extraPayEveryMonth", Loan.class, double.class);
		  // Call the method 
		  Object result = method.invoke(null, loan, extraPaymentAmount);
		  // Print the result
		  System.out.println("Result: " + result);
		  // Catch the exception.
	} catch (Exception e) {System.out.println("Could not find a method for that username.");}}}}
