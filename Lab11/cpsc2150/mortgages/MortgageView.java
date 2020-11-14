/*Kellen Haas
  CPSC 2150
  Lab11
  11/13/20
 */


/*No contracts necessary*/


package cpsc2150.mortgages;

import java.util.Scanner;

public class MortgageView implements IMortgageView{
    Scanner scan;
    IMortgageController c;

    public MortgageView(){
        scan = new Scanner(System.in);
    }

    public void setController(IMortgageController c) {this.c = c;}


    public double getHouseCost() {
        double houseCost = 0.0;
        System.out.println("How much does the house cost?\n");
        String input = scan.nextLine();
        houseCost = Double.parseDouble(input);
        return houseCost;
    }


    public double getDownPayment() {
        double downPayment = 0.0;
        System.out.println("How much is the down payment?\n");
        String input = scan.nextLine();
        downPayment = Double.parseDouble(input);
        return downPayment;
    }


    public int getYears() {
        int yrs = 0;
        System.out.println("How many years?\n");
        String input = scan.nextLine();
        yrs = Integer.parseInt(input);
        return yrs;
    }


    public double getMonthlyDebt() {
        double monthlyDebt = 0.0;
        System.out.println("How much are your monthly debt payments?\n");
        String input = scan.nextLine();
        monthlyDebt = Double.parseDouble(input);
        return monthlyDebt;
    }


    public double getYearlyIncome() {
        double yearlyIncome = 0.0;
        System.out.println("How much is your yearly income?\n");
        String input = scan.nextLine();
        yearlyIncome = Double.parseDouble(input);
        return yearlyIncome;
    }


    public int getCreditScore() {
        int creditScore = 0;
        System.out.println("What is your credit score?\n");
        String input = scan.nextLine();
        creditScore = Integer.parseInt(input);
        return creditScore;
    }


    public String getName() {
        String name = "";
        System.out.println("What's your name?\n");
        name = scan.nextLine();
        return name;
    }


    public void printToUser(String s) {
        System.out.println(s);
    }


    public void displayPayment(double p) {
        String str = "";
        str += "Principal Amount: $" + p + "\n";
        System.out.println(str);
    }


    public void displayRate(double r) {
        String str = "";
        str += "Interest Rate: ";
        str += String.format("%.1f", (r * 100)) + "%\n";
        System.out.println(str);
    }


    public void displayApproved(boolean a) {
        if (!a) {
            System.out.println("Your loan was not approved.");
        }
        else {
            System.out.println("Congratulations! Your loan was approved.");
        }
        System.out.println("\n");
    }


    public boolean getAnotherMortgage() {
        System.out.println("Would you like to apply for another mortgage? Y/N\n");
        String input = scan.nextLine();
        input = input.toUpperCase();
        if (input.equals("Y")){
            return true;
        }
        else if (input.equals("N")) {
            return false;
        }
        return false;
    }


    public boolean getAnotherCustomer() {
        System.out.println("Would you like to consider another customer? Y/N\n");
        String input = scan.nextLine();
        input = input.toUpperCase();
        if (input.equals("Y")) {
            return true;
        }
        else if (input.equals("N")) {
            System.out.println("Exiting program...");
            return false;
        }
        return false;
    }

}
