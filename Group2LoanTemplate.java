package groupproject2026;
// LiveExample 10.2
public class LoanTemplate {
	  private double annualInterestRate;
	  private int numberOfYears;
	  private double loanAmount;
	  private java.util.Date loanDate;

	  /** No-arg constructor */
	  public LoanTemplate() {
	    this(2.5, 1, 1000);
	  }

	  /** Construct a loan with specified annual interest rate,
	      number of years, and loan amount
	    */
	  public LoanTemplate(double annualInterestRate, int numberOfYears,
	      double loanAmount) {
	    this.annualInterestRate = annualInterestRate;
	    this.numberOfYears = numberOfYears;
	    this.loanAmount = loanAmount;
	    loanDate = new java.util.Date();
	  }
	//-----------------------------------
	// Function1:
	//-----------------------------------
	  /** Return annualInterestRate */
	  public double getAnnualInterestRate() {
	    return annualInterestRate;
	  }
	//------------------------------------
	// Function2:
	//------------------------------------
	  /** Set a new annualInterestRate */
	  public void setAnnualInterestRate(double annualInterestRate) {
	    this.annualInterestRate = annualInterestRate;
	  }
	//-------------------------------------
	// Function3:
	//-------------------------------------
	  /** Return numberOfYears */
	  public int getNumberOfYears() {
	    return numberOfYears;
	  }
	//-------------------------------------
	// Function4:
	//-------------------------------------
	  /** Set a new numberOfYears */
	  public void setNumberOfYears(int numberOfYears) {
	    this.numberOfYears = numberOfYears;
	  }
	//---------------------------------------
	// Function5:
	//---------------------------------------
	  /** Return loanAmount */
	  public double getLoanAmount() {
	    return loanAmount;
	  }
	//---------------------------------------
	// Function6:
	//---------------------------------------
	  /** Set a newloanAmount */
	  public void setLoanAmount(double loanAmount) {
	    this.loanAmount = loanAmount;
	  }
	//---------------------------------------
	// Function7:
	//---------------------------------------
	  /** Find monthly payment */
	  public double getMonthlyPayment() {
	    double monthlyInterestRate = annualInterestRate / 1200;
	    double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
	      (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
	    return monthlyPayment;    
	  }
	//-------------------------------------
	// Function8:
	//-------------------------------------
	  /** Find total payment */
	  public double getTotalPayment() {
	    double totalPayment = getMonthlyPayment() * numberOfYears * 12;
	    return totalPayment;    
	  }
	//-------------------------------------
	// Function9:
	//-------------------------------------
	  // 11/9
	  /** Find total interest */
	  public double getTotalInterest() {
	    double totalInterest = getTotalPayment() - loanAmount;
	    return totalInterest;    
	  }
	//--------------------------------------
	// Function10:
	//--------------------------------------
	  /** Return loan date */
	  public java.util.Date getLoanDate() {
	    return loanDate;
	  }
	  
	}
