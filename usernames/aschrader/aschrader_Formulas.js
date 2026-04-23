// Please Update Your Username
// Hello!
// Please Update your Username
//===========================
// Date:
// Author:
// Second Author:
// Function Name:
// [Y/N] Approved? (username1);
// Description:
//============================

function endOfClassMessage() {
  console.log("Welcome to the end of the class.");
}

// Date:04/09/26
// Author: Alex Schrader
// Second Author:
// Function Name: ExtraPayFirstMonth
// [Y/N] Approved? (username1);
// Description: Calculates total interest andmonths when extra
//               payment is made in the first month only.
//============================
	/* Extra payment first month only */
  public static void extraPayFirstMonth(Loan l, double extraPay) {
	  System.out.printf("Extra payment only first month $%.2f%n", extraPay);
	  double myLoanAmount =l.getLoanAmount();
	  double myMonthlyInterestRate = l.getAnnualInterestRate()/1200;
	  double myMonthlyPayment = l.getMonthlyPayment();
	  int month= 0;
	  double interest = 0.0;
	  double principal = 0.0;
	  double totalInterest = 0.0;

	  while (myLoanAmount >= myMonthlyPayment) {
		  // to do A1 same as A2
		  
	  }
	  if (myLoanAmount < myMonthlyPayment) {
		  // to do B1 same as B2
	  }
	  // (Aschrader)
	  double interestSaved = l.getTotalInterest() - totalInterest;
	  /*
	  System.out.println("total interest " + totalInterest);
	  System.out.println("interest saved " + interestSaved);
	  System.out.println("total month " + month);
	  */
	  System.out.printf("Total interest $%.2f%nTotal interest saved $%.2f%nTotal months %d %n",
			  totalInterest, interestSaved, month);	  
  }
  