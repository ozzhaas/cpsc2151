/*Kellen Haas
  CPSC 2150
  Lab12
  11/20/20
*/

package cpsc2150.mortgages;

public class MortgageController implements IMortgageController {

    private IMortgageView view;

    public MortgageController( IMortgageView v) {
        view = v;
    }

    public void submitApplication() {
        //loop control
        boolean customer = true;

        System.out.println("Loop for customer has started...\n");
        String name = view.getName();

        //get yearly income
        double income = view.getYearlyIncome();
        while(income <= 0){
            view.printToUser("Income must be greater than 0.");
            income = view.getYearlyIncome();
        }

        //get monthly debt
        double debts = view.getMonthlyDebt();
        while(debts < 0){
            view.printToUser("Debts must be greater than or equal to 0.");
            debts = view.getMonthlyDebt();
        }

        //get credit
        int credit = view.getCreditScore();
        while(credit <= 0 || credit >= 850){
            view.printToUser("Credit Score must be greater than 0 and less than 850.");
            credit = view.getCreditScore();
        }

        ICustomer myCustomer = new Customer(debts,income,credit,name);
        System.out.println("ICustomer object myCustomer was created...\n");
        //loop control
        boolean mortgage = true;


        System.out.println("Loop for mortgage has started...\n");
        //getting house cost
        double houseCost = view.getHouseCost();
        while(houseCost <= 0){
            view.printToUser("Cost must be greater than 0.");
            houseCost = view.getHouseCost();
        }

        //getting down payment
        double downPayment = view.getDownPayment();
        while(downPayment <= 0 || downPayment >= houseCost){
            view.printToUser("Down Payment must be greater than 0 and less than the cost of the house.");
            downPayment = view.getDownPayment();
        }

        //getting years
        int years = view.getYears();
        while(years <= 0){
            view.printToUser("Years must be greater than 0.");
            years = view.getYears();
        }

        //make the mortgage
        IMortgage myMortgage = new Mortgage(houseCost,downPayment,years,myCustomer);
        System.out.println("The IMortgage object myMortgage was created...\n");
        boolean approved = myMortgage.loanApproved();
        view.printToUser(myCustomer.toString());


        //this is messy
        if(approved){
            view.printToUser(myMortgage.toString());
        }
        view.displayApproved(approved);
        view.displayRate(myMortgage.getRate());
        view.displayPayment(myMortgage.getPayment());

        //another loan?
        mortgage = view.getAnotherMortgage();

        //another customer?
        customer = view.getAnotherCustomer();
    }
}
