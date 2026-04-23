// Please Update Your Username
// Hello!
// Please Update your Username
//===========================
// Date: 04/09/2026
// Author: aschrader
// Second Author:
// Function Name: User_Formulas
// [Y/N] Approved? (cmobrien3):
// Description: Loan payment calculator formulas including monthly payment,
//              total payment, total interest, and extra payment calculations.
//============================

function endOfClassMessage() {
  console.log("Welcome to the end of the class.");
}

//----------------------------
// Date: 04/23/2026
// Author: aschrader
// Second Author:
// Function Name: getMonthlyPayment
// [Y/N] Approved? (cmobrien3):
// Description: Calculates the fixed monthly payment using the amortization formula.
//----------------------------
function getMonthlyPayment(loanAmount, annualInterestRate, numberOfYears) {
  var monthlyInterestRate = annualInterestRate / 1200;
  var monthlyPayment = loanAmount * monthlyInterestRate /
    (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
  return monthlyPayment;
}

//----------------------------
// Date: 04/23/2026
// Author: aschrader
// Second Author:
// Function Name: getTotalPayment
// [Y/N] Approved? (cmobrien3):
// Description: Calculates total amount paid over the life of the loan.
//----------------------------
function getTotalPayment(loanAmount, annualInterestRate, numberOfYears) {
  var monthlyPayment = getMonthlyPayment(loanAmount, annualInterestRate, numberOfYears);
  var totalPayment = monthlyPayment * numberOfYears * 12;
  return totalPayment;
}

//----------------------------
// Date: 04/23/2026
// Author: aschrader
// Second Author:
// Function Name: getTotalInterest
// [Y/N] Approved? (cmobrien3):
// Description: Calculates total interest paid. Total payment minus loan amount.
//----------------------------
function getTotalInterest(loanAmount, annualInterestRate, numberOfYears) {
  var totalInterest = getTotalPayment(loanAmount, annualInterestRate, numberOfYears) - loanAmount;
  return totalInterest;
}

//----------------------------
// Date: 04/09/2026
// Author: aschrader
// Second Author:
// Function Name: extraPayFirstMonth
// [Y/N] Approved? cmobrien3):
// Description: Calculates total interest and months when an extra payment
//              is made in the first month only.
//----------------------------
function extraPayFirstMonth(loanAmount, annualInterestRate, numberOfYears, extraPay) {
  var monthlyInterestRate = annualInterestRate / 1200;
  var monthlyPayment = getMonthlyPayment(loanAmount, annualInterestRate, numberOfYears);
  var myLoanAmount = loanAmount;
  var month = 0;
  var interest = 0.0;
  var principal = 0.0;
  var totalInterest = 0.0;

  // First month: apply extra payment
  interest = myLoanAmount * monthlyInterestRate;
  principal = monthlyPayment - interest;
  myLoanAmount = myLoanAmount - principal - extraPay;
  totalInterest += interest;
  month++;

  // A1: remaining months regular payment
  while (myLoanAmount >= monthlyPayment) {
    interest = myLoanAmount * monthlyInterestRate;
    principal = monthlyPayment - interest;
    myLoanAmount -= principal;
    totalInterest += interest;
    month++;
  }
  // B1: final partial month
  if (myLoanAmount > 0 && myLoanAmount < monthlyPayment) {
    interest = myLoanAmount * monthlyInterestRate;
    totalInterest += interest;
    month++;
  }

  var interestSaved = getTotalInterest(loanAmount, annualInterestRate, numberOfYears) - totalInterest;
  console.log("Extra payment only first month $" + extraPay.toFixed(2));
  console.log("Total interest $" + totalInterest.toFixed(2));
  console.log("Total interest saved $" + interestSaved.toFixed(2));
  console.log("Total months " + month);
}

//----------------------------
// Date: 04/09/2026
// Author: aschrader
// Second Author:
// Function Name: extraPayEveryMonth
// [Y/N] Approved? (cmobrien3):
// Description: Calculates total interest and months when an extra payment
//              is made every month until the loan is paid off.
//----------------------------
function extraPayEveryMonth(loanAmount, annualInterestRate, numberOfYears, extraPay) {
  var monthlyInterestRate = annualInterestRate / 1200;
  var monthlyPayment = getMonthlyPayment(loanAmount, annualInterestRate, numberOfYears);
  var myLoanAmount = loanAmount;
  var month = 0;
  var interest = 0.0;
  var principal = 0.0;
  var totalInterest = 0.0;

  // A2: pay extra every month while loan is large enough
  while (myLoanAmount >= (monthlyPayment + extraPay)) {
    interest = myLoanAmount * monthlyInterestRate;
    principal = monthlyPayment - interest;
    myLoanAmount = myLoanAmount - principal - extraPay;
    totalInterest += interest;
    month++;
  }
  // B2: regular payment only, loan too small for extra
  while (myLoanAmount >= monthlyPayment) {
    interest = myLoanAmount * monthlyInterestRate;
    principal = monthlyPayment - interest;
    myLoanAmount -= principal;
    totalInterest += interest;
    month++;
  }
  // Final partial month
  if (myLoanAmount > 0 && myLoanAmount < monthlyPayment) {
    interest = myLoanAmount * monthlyInterestRate;
    totalInterest += interest;
    month++;
  }

  var interestSaved = getTotalInterest(loanAmount, annualInterestRate, numberOfYears) - totalInterest;
  console.log("Extra payment every month $" + extraPay.toFixed(2));
  console.log("Total interest $" + totalInterest.toFixed(2));
  console.log("Total interest saved $" + interestSaved.toFixed(2));
  console.log("Total months " + month);
}