package aschrader_Functions;
// aschrader_Functions_Group
public class LoanTemplate_off {
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
// Function1: getAnnualInterestRate()
//-----------------------------------
	  /** Return annualInterestRate */
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
//------------------------------------
// Function3 getNumberOfYears()
//------------------------------------
	  /** Return numberOfYears */
	  public int getNumberOfYears() {
	    return numberOfYears;
	  }
//------------------------------------
// Function4: setNumberOfYears
//------------------------------------
	  /** Set a new numberOfYears */
	  public void setNumberOfYears(int numberOfYears) {
	    this.numberOfYears = numberOfYears;
	  }
//------------------------------------
// Function5: getLoanAmount()
//------------------------------------
	  /** Return loanAmount */
	  public double getLoanAmount() {
	    return loanAmount;
	  }
//------------------------------------
// Function6: setLoanAmount()
//------------------------------------
	  /** Set a newloanAmount */
	  public void setLoanAmount(double loanAmount) {
	    this.loanAmount = loanAmount;
	  }
//------------------------------------
// Function7: getMonthlyPayment()
//------------------------------------
	  /** Find monthly payment */
	  public double getMonthlyPayment() {
	    double monthlyInterestRate = annualInterestRate / 1200;
	    double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
	      (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
	    return monthlyPayment;    
	  }
//------------------------------------
// Function8: getTotalPayment()
//------------------------------------
	  /** Find total payment */
	  public double getTotalPayment() {
	    double totalPayment = getMonthlyPayment() * numberOfYears * 12;
	    return totalPayment;    
	  }
//-------------------------------------
// Function9: getTotalInterest()
//-------------------------------------
	  // 11/9
	  /** Find total interest */
	  public double getTotalInterest() {
	    double totalInterest = getTotalPayment() - loanAmount;
	    return totalInterest;    
	  }
//--------------------------------------
// Function 10: getLoanDate()
//--------------------------------------
	  /** Return loan date */
	  public java.util.Date getLoanDate() {
	    return loanDate;
	  }
      //----------------------------
    // Date: 04/09/2026
    // Author: aschrader
    // 4Function11: extraPayFirstMonth()
    //----------------------------
    public static String extraPayFirstMonth(double loanAmount, double annualInterestRate, int numberOfYears, double extraPay) {

        double monthlyInterestRate = annualInterestRate / 1200.0;
        double monthlyPayment = getMonthlyPayment(loanAmount, annualInterestRate, numberOfYears);

        double balance = loanAmount;
        int month = 0;
        double totalInterest = 0.0;

        // First month with extra payment
        double interest = balance * monthlyInterestRate;
        double principal = monthlyPayment - interest;
        balance = balance - principal - extraPay;
        totalInterest += interest;
        month++;

        // Regular months
        while (balance >= monthlyPayment) {
            interest = balance * monthlyInterestRate;
            principal = monthlyPayment - interest;
            balance -= principal;
            totalInterest += interest;
            month++;
        }

        // Final partial month
        if (balance > 0) {
            interest = balance * monthlyInterestRate;
            totalInterest += interest;
            month++;
        }

        double interestSaved = getTotalInterest(loanAmount, annualInterestRate, numberOfYears) - totalInterest;

        return "Extra payment only first month: $" + extraPay +
               "\nTotal interest: $" + String.format("%.2f", totalInterest) +
               "\nInterest saved: $" + String.format("%.2f", interestSaved) +
               "\nTotal months: " + month;
    }

    //----------------------------
    // Date: 04/09/2026
    // Author: aschrader
    // 5Function12: extraPayEveryMonth
    //----------------------------
    public static String extraPayEveryMonth(double loanAmount, double annualInterestRate, int numberOfYears, double extraPay) {

        double monthlyInterestRate = annualInterestRate / 1200.0;
        double monthlyPayment = getMonthlyPayment(loanAmount, annualInterestRate, numberOfYears);

        double balance = loanAmount;
        int month = 0;
        double totalInterest = 0.0;

        // Pay extra every month
        while (balance >= (monthlyPayment + extraPay)) {
            double interest = balance * monthlyInterestRate;
            double principal = monthlyPayment - interest;
            balance = balance - principal - extraPay;
            totalInterest += interest;
            month++;
        }

        // Regular payments only
        while (balance >= monthlyPayment) {
            double interest = balance * monthlyInterestRate;
            double principal = monthlyPayment - interest;
            balance -= principal;
            totalInterest += interest;
            month++;
        }

        // Final partial month
        if (balance > 0) {
            double interest = balance * monthlyInterestRate;
            totalInterest += interest;
            month++;
        }

        double interestSaved = getTotalInterest(loanAmount, annualInterestRate, numberOfYears) - totalInterest;

        return "Extra payment every month: $" + extraPay +
               "\nTotal interest: $" + String.format("%.2f", totalInterest) +
               "\nInterest saved: $" + String.format("%.2f", interestSaved) +
               "\nTotal months: " + month;
    }
}

	  
	}
