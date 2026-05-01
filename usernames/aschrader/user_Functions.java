package usernames.aschrader;

//===========================
// Date: 04/09/2026
// Author: aschrader
// Function Name: User_Formulas
// Description: Loan payment calculator formulas including monthly payment,
//              total payment, total interest, and extra payment calculations.
//===========================

public class User_Formulas {

    //----------------------------
    // Date: 04/23/2026
    // Author: aschrader
    // Description: Calculates the fixed monthly payment using the amortization formula.
    //----------------------------
    public static double getMonthlyPayment(double loanAmount, double annualInterestRate, int numberOfYears) {
        double monthlyInterestRate = annualInterestRate / 1200.0;
        return loanAmount * monthlyInterestRate /
                (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
    }

    //----------------------------
    // Date: 04/23/2026
    // Author: aschrader
    // Description: Calculates total amount paid over the life of the loan.
    //----------------------------
    public static double getTotalPayment(double loanAmount, double annualInterestRate, int numberOfYears) {
        double monthlyPayment = getMonthlyPayment(loanAmount, annualInterestRate, numberOfYears);
        return monthlyPayment * numberOfYears * 12;
    }

    //----------------------------
    // Date: 04/23/2026
    // Author: aschrader
    // Description: Calculates total interest paid.
    //----------------------------
    public static double getTotalInterest(double loanAmount, double annualInterestRate, int numberOfYears) {
        return getTotalPayment(loanAmount, annualInterestRate, numberOfYears) - loanAmount;
    }

    //----------------------------
    // Date: 04/09/2026
    // Author: aschrader
    // Description: Extra payment in the first month only.
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
    // Description: Extra payment every month until loan is paid off.
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
