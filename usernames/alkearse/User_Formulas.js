alkearse 

# alkearse
#===========================
# Date:
# Author:
# Second Author:
# Function Name:
# [Y/N] Approved? (alkearse);
# Description:
#============================

function endOfClassMessage() {
  console.log("Welcome to the end of the class.");
}

function getMonthlyPayment(loan, rate, years) {

  let monthlyRate = rate / 12 / 100;
  let months = years * 12;

  let payment =
    loan
    monthlyRate *
    Math.pow(1 + monthlyRate, months) / 
    (Math.pow(1 + monthlyRate, months) - 1);

  return payment; 
}


function loanExtra(loan, rate, years) {
  let monthlyRate = rate / 12 / 100;
  let payment = getMonthlyPayment(loan, rate, years);

  let balance = loan;
  let totalInterest = 0;
  let months = 0;

  while (balance > 0) {

    let interest = balance * monthlyRate;
    let principal = payment - interest;

    balance -= principal;
    totalInterest += interest;

    months++;

    if (months > years * 12 * 2) break;
  }

  return {
    interest: totalInterest,
    months: months 

  }; 
}

function loanFirstMonthExtra(loan, rate, years, extra) {

  let monthlyRate = rate / 12 / 100;
  let payment = getMonthlypayment(loan, rate, years);

  let balance = loan;
  let totalInterest = 0;
  let months = 0;

  while (balance > 0) {

    let interest = balance 
  }
}

function loanFirstMonthExtra(loan, rate, years, extra) {
  let monthlyRate = rate / 12 / 100;
  let payment = getMonthlyPayment(loan, rate, years);

  let balance = loan;
  let totalInterest = 0;
  let months = 0;

  while (balance > 0) {
    let interest = balance * monthlyRate;

    let actualPayment = payment;
    if (months === 0) {
      actualPayment += extra;
    }

    let principal = actualPayment - interest;

    balance -= principal;
    totalInterest += interest;

    months++;

    if (months > years * 12 * 2) break;
  }

  return { 
    interest: totalInterest,
    months: months 

  };
}


function loanMonthlyExtra(loan, rate, years,extra) {

  let monthlyRate = rate / 12/ 100;

  let payment = getMonthlyPayment(loan, rate, years);

  let balance = loan; 
  let totalinterest = 0;
  let months = 0;

  while(balance > 0) {

    let 
  }
}