package alkearse_Functions;
// Kearse Complete
//===========================
// Date: 05/01/2026
// Author: Ashlei Kearse
// Second Author: Christopher O'Brien
// Function Name: AI Assisted Java File
// [Y] Approved? (Chris);
// Description: I Refactored the functions with AI.
//============================
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

	  /** Return annualInterestRate */
	  //-------------------------------
	  // Function1: getAnnualInterestRate()
	  //-------------------------------
	  public double getAnnualInterestRate() {
	    return annualInterestRate;
	  }
	//------------------------------------
	// Function2: setAnnualInterestRate()
	//------------------------------------
	  /** Set a new annualInterestRate */
	  public void setAnnualInterestRate(double annualInterestRate) {
	    this.annualInterestRate = annualInterestRate;
	  }
	//-----------------------------------
	// Function3: getNumberOfYears()
	//----------------------------------
	  /** Return numberOfYears */
	  public int getNumberOfYears() {
	    return numberOfYears;
	  }
	//----------------------------------
	// Function4: setNumberOfYears()
	//----------------------------------
	  /** Set a new numberOfYears */
	  public void setNumberOfYears(int numberOfYears) {
	    this.numberOfYears = numberOfYears;
	  }
	//----------------------------------
	// Function5: getLoanAmount()
	//----------------------------------
	  /** Return loanAmount */
	  public double getLoanAmount() {
	    return loanAmount;
	  }
	//-----------------------------------
	// Function6: setLoanAmount()
	//-----------------------------------
	  /** Set a newloanAmount */
	  public void setLoanAmount(double loanAmount) {
	    this.loanAmount = loanAmount;
	  }
	// -------------------------------
    // Function7: Monthly Payment (Standard Loan)
	// Author: alkearse
    // -------------------------------
    public double getMonthlyPayment(double loan, double rate, int years) {
        double monthlyRate = rate / 12.0 / 100.0;
        int months = years * 12;

        return loan * monthlyRate * Math.pow(1 + monthlyRate, months)
                / (Math.pow(1 + monthlyRate, months) - 1);
    }
	// -------------------------------
    // Function8: Extra Payment Every Month
    // Author: alkearse_Functions
    // -------------------------------
    public LoanResult loanExtra(double loan, double rate, int years, double extra) {
        double monthlyRate = rate / 12.0 / 100.0;
        double payment = getMonthlyPayment(loan, rate, years);

        double balance = loan;
        double totalInterest = 0;
        int months = 0;

        while (balance > 0) {
            double interest = balance * monthlyRate;
            double principal = (payment + extra) - interest;

            balance -= principal;
            totalInterest += interest;
            months++;

            if (months > years * 12 * 2) break; // safety
        }

        return new LoanResult(totalInterest, months);
    }
	//------------------------------------
	// Function9: getTotalInterest()
	//------------------------------------
	  // 11/9
	  /** Find total interest */
	  public double getTotalInterest() {
	    double totalInterest = getTotalPayment() - loanAmount;
	    return totalInterest;    
	  }
	//------------------------------------
	// Function10: getLoanDate()
	//------------------------------------
	  /** Return loan date */
	  public java.util.Date getLoanDate() {
	    return loanDate;
	  }
	// -------------------------------
    // Function11: loanFirstMonthExtra
    // Author: alkearse
    // -------------------------------
    public LoanResult loanFirstMonthExtra(double loan, double rate, int years, double extra) {
        double monthlyRate = rate / 12.0 / 100.0;
        double payment = getMonthlyPayment(loan, rate, years);

        double balance = loan;
        double totalInterest = 0;
        int months = 0;

        while (balance > 0) {
            double interest = balance * monthlyRate;

            double actualPayment = payment;
            if (months == 0) {
                actualPayment += extra;
            }

            double principal = actualPayment - interest;

            balance -= principal;
            totalInterest += interest;
            months++;

            if (months > years * 12 * 2) break;
        }

        return new LoanResult(totalInterest, months);
    }
	// -------------------------------
    // Function12: LoanResult
    // Author: alkearse
    // -------------------------------
    public static class LoanResult {
        public double interest;
        public int months;

        public LoanResult(double interest, int months) {
            this.interest = interest;
            this.months = months;
        }
    }
	
	}
