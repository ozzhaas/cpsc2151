/*Kellen Haas
  CPSC 2150
  Lab11
  11/13/20
 */

package cpsc2150.mortgages;

public abstract class AbsCustomer implements ICustomer {

    //Every customer will have an IMortgage Loan
    //Protected so the child classes can access it
    protected IMortgage loan;

    @Override
    public String toString()
    {
        String str = "";
        str += "\n\n";
        str += "Customer Information: \n";
        str += "Name: " + getName() + "\n";
        str += "Income: $" + getIncome() + "\n";
        str += "Credit Score: " + getCreditScore() + "\n";
        str += "Monthly Debt: $" + getMonthlyDebtPayments() + "\n";
        if(appliedForLoan()) {
            str += loan.toString();
        }

        return str;

    }
}
