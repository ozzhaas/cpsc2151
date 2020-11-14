/*Kellen Haas
  CPSC 2150
  lab7
  10/07/20
 */

package cpsc2150.mortgages;


public abstract class AbsMortgage implements IMortgage {

    /**
     *
     * @return the string representation of this loan details, or a notice that the loan was not approved
     * @requires this != null and [interestRate and payment have been calculated]
     * @ensures [toString = The string value of the loan, or "Loan was not approved"]
     */
    @Override
    public String toString()
    {
        String str = "";
        if(loanApproved())
        {
            str += "Mortgage Information: \n";
            str += "Principal Amount: $" + getPrincipal() + "\n";
            str += "Interest Rate: ";
            str += String.format("%.1f", (getRate() * 100));
            str += "%\n";
            str += "Term: " + getYears() + " years\n";
            str += "Monthly Payment: $" + getPayment() + "\n";
        }
        return str;
    }
}
