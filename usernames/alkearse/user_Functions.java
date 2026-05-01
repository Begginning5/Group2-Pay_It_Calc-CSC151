//===========================
// Date: 05/01/2026
// Author: Ashlei Kearse
// Second Author: Christopher O'Brien
// Function Name: AI Assisted Java File
// [Y] Approved? (Chris);
// Description: I Refactored the functions with AI.
//============================
package usernames.alkearse;

public class alkearse {

    // -------------------------------
    // 1Function7: Monthly Payment (Standard Loan)
    // -------------------------------
    public double getMonthlyPayment(double loan, double rate, int years) {
        double monthlyRate = rate / 12.0 / 100.0;
        int months = years * 12;

        return loan * monthlyRate * Math.pow(1 + monthlyRate, months)
                / (Math.pow(1 + monthlyRate, months) - 1);
    }

    // -------------------------------
    // 2Function?: Extra Payment Every Month
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

    // -------------------------------
    // 3Function4: Extra Payment Only in Month 1
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
    // 4Function? Extra Payment Class (Java cannot return JS objects)
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
