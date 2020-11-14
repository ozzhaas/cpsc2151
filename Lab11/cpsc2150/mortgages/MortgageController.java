/*Kellen Haas
  CPSC 2150
  Lab11
  11/13/20
 */


/*No contracts necessary*/

package cpsc2150.mortgages;

public class MortgageController implements IMortgageController{
    IMortgageView myView;

    public MortgageController( IMortgageView view) {
        myView = view;
    }

    public void submitApplication() {
        //loop control
        boolean customer = true;

        while(customer){
            String name = myView.getName();

            //get yearly income
            double income = myView.getYearlyIncome();
            while(income <= 0){
                myView.printToUser("Income must be greater than 0.");
                income = myView.getYearlyIncome();
            }

            //get monthly debt
            double debts = myView.getMonthlyDebt();
            while(debts < 0){
                myView.printToUser("Debts must be greater than or equal to 0.");
                debts = myView.getMonthlyDebt();
            }

            //get credit
            int credit = myView.getCreditScore();
            while(credit <= 0 || credit >= 850){
                myView.printToUser("Credit Score must be greater than 0 and less than 850.");
                credit = myView.getCreditScore();
            }

            ICustomer myCustomer = new Customer(debts,income,credit,name);
            //loop control
            boolean mortgage = true;


            while(mortgage){

                //getting house cost
                double houseCost = myView.getHouseCost();
                while(houseCost <= 0){
                    myView.printToUser("Cost must be greater than 0.");
                    houseCost = myView.getHouseCost();
                }

                //getting down payment
                double downPayment = myView.getDownPayment();
                while(downPayment <= 0 || downPayment >= houseCost){
                    myView.printToUser("Down Payment must be greater than 0 and less than the cost of the house.");
                    downPayment = myView.getDownPayment();
                }

                //getting years
                int years = myView.getYears();
                while(years <= 0){
                    myView.printToUser("Years must be greater than 0.");
                    years = myView.getYears();
                }

                //make the mortgage
                IMortgage myMortgage = new Mortgage(houseCost,downPayment,years,myCustomer);

                boolean approved = myMortgage.loanApproved();
                myView.printToUser(myCustomer.toString());


                if(approved){
                    myView.displayApproved(approved);
                    myView.printToUser(myMortgage.toString());
                }
                else
                    myView.displayApproved(approved);

                //another loan?
                mortgage = myView.getAnotherMortgage();
            }

            //another customer?
            customer = myView.getAnotherCustomer();
        }
    }
}
