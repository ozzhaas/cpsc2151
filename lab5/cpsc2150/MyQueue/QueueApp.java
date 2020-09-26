/* Kellen Haas
   CPSC 2150
   Lab5
   9/23/20
 */

package cpsc2150.MyQueue;

import java.util.*;
import java.lang.*;
import java.io.*;

public class QueueApp {

    public static void main(String[] args) {
        IQueue q;
        boolean empty;

        //Initializing Queue through user input
        Scanner scan = new Scanner(System.in);
        System.out.println("What kind of implementation would you like?");
        System.out.println("Enter 1 for Array implementation or 2 for List implementation:\n");
        String in = scan.nextLine();

        if (in.equals("1")){
            q = new ArrayQueue();
        }
        else {
            q = new ListQueue();
        }

        //menu
        String menuSelec = "10";
        while(!menuSelec.equals("8")){
            System.out.println("\nSelect an option:\n");
            System.out.println("\t1. Add to the Queue\n\t2. Get next number from the Queue\n\t" +
                    "3. Peek at the front of the Queue\n\t4. Peek at the end of the Queue\n\t5. Insert in the Queue\n\t" +
                    "6. Get a position in the Queue\n\t7. Remove from a position in the Queue\n\t8. Quit\n");

            menuSelec = scan.nextLine();
            // if ((q.size() == 0) && (!menuSelec.equals("1"))) {
            //     isEmpty(q);
            //     System.out.println("~~~~~~~~~~~~~ SECOND SELECTION ~~~~~~~~~~~~\n");
            //     System.out.println("\nSelect an option:\n");
            //     System.out.println("\t1. Add to the Queue\n\t2. Get next number from the Queue\n\t" +
            //             "3. Peek at the front of the Queue\n\t4. Peek at the end of the Queue\n\t5. Insert in the Queue\n\t" +
            //             "6. Get a position in the Queue\n\t7. Remove from a position in the Queue\n\t8. Quit\n");
            //
                // menuSelec = scan.nextLine();

            // }
            // else {
                switch (menuSelec) {
                    case "1":
                        System.out.println("What number would you like to add to the Queue?");
                        String temp = scan.nextLine();
                        Integer numToAdd = Integer.parseInt(temp);
                        q.add(numToAdd);
                        System.out.println("\n");
                        printQ(q);
                        break;

                    case "2":
                        if(isEmpty(q))
                            break;

                        System.out.println("Next number is: " + q.pop());
                        System.out.println("\n");
                        printQ(q);
                        break;

                    case "3":
                        if(isEmpty(q))
                            break;

                        Integer frontNum = q.peek();
                        System.out.println("Peek: " + frontNum);
                        System.out.println("\n");
                        printQ(q);
                        break;

                    case "4":
                        if(isEmpty(q))
                            break;

                        Integer endNum = q.endOfQueue();
                        System.out.println("Peek at the end: " + endNum);
                        System.out.println("\n");
                        printQ(q);
                        break;

                    case "5":
                        if (isEmpty(q))
                            break;

                        System.out.println("What number do you want to add to the Queue?");
                        String tempInsNum = scan.nextLine();
                        Integer insNum = Integer.parseInt(tempInsNum);
                        System.out.println("\n");

                        System.out.println("What position do you want to insert it in?");
                        String tempInsPos = scan.nextLine();
                        Integer insPos = Integer.parseInt(tempInsPos);
                        System.out.println("\n");

                        while ((insPos < 1) || (insPos > q.size()+1)) {
                            System.out.println("Not a valid position in the Queue!");
                            System.out.println("What position in the Queue do you want to insert it in?");
                            tempInsPos = scan.nextLine();
                            insPos = Integer.parseInt(tempInsPos);
                            System.out.println("\n");
                        }


                        q.insert(insNum, insPos);
                        System.out.println("\n");
                        printQ(q);
                        break;

                    case "6":
                        if(isEmpty(q))
                            break;

                        System.out.println("What position in the Queue do you want to get?");
                        String getPos = scan.nextLine();
                        Integer pos = Integer.parseInt(getPos);

                        while ((pos < 1) || (pos > q.size()+1)) {
                            System.out.println("Not a valid position in the Queue!");
                            System.out.println("What position in the Queue do you want to get?");
                            getPos = scan.nextLine();
                            pos = Integer.parseInt(getPos);
                        }

                        Integer nextNum = q.get(pos);
                        System.out.println("\n" + nextNum + " is at position " + pos + " in the Queue.");
                        System.out.println("\n");
                        printQ(q);
                        break;

                    case "7":
                        if(isEmpty(q))
                            break;

                        System.out.println("What position would you like to remove from the Queue?");
                        String tempRemPos = scan.nextLine();
                        Integer remPos = Integer.parseInt(tempRemPos);

                        while ((remPos < 1) || (remPos > (q.size()))) {
                            System.out.println("\n");
                            System.out.println("Not a valid position in the Queue!");
                            System.out.println("What position would you like to remove from the Queue?");
                            tempRemPos = scan.nextLine();
                            remPos = Integer.parseInt(tempRemPos);
                            System.out.println("\n");
                        }

                        Integer removed = q.remove(remPos);
                        System.out.println(removed + " was at position " + remPos + " in the Queue.");
                        System.out.println("\n");
                        printQ(q);
                        break;

                    case "8":
                        System.out.println("Exiting menu...");
                        break;

                    default:
                        System.out.println("\nInvalid! You must enter a number 1-8.");
                        printQ(q);
                        break;
                }
            // }
        }
    }


    static private void printQ(IQueue printer) {
        if(printer.size() == 0) {
            System.out.println("Queue is empty!");
            System.out.println("Queue is: ");
        }
        else {
            System.out.println("Queue is: ");

            Integer holder = printer.get(1);
            System.out.print(holder);

            for (int k = 2; k <= printer.size(); k++) {
                holder = printer.get(k);
                System.out.print(", " + holder);
            }
            System.out.print("\n");
        }
    }

    static private boolean isEmpty(IQueue myQ){
        if(myQ.size() == 0) {
            System.out.println("Queue is empty!");
            System.out.println("Queue is: ");
            return true;
        }
        else
            return false;
    }
}
