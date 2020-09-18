/* Kellen Haas
   CPSC 2150
   Lab4
   9/18/20
 */

package cpsc2150.MyQueue;

import java.util.Scanner;

public class QueueApp {

    public static void main(String[] args) {
        //Initialize to ArrayQueue temporarily
        IQueue q = new ArrayQueue();

        //Initializing Queue through user input
        Scanner scan = new Scanner(System.in);
        System.out.println("What kind of implementation would you like?");
        System.out.println("Enter 1 for ArrayQueue or 2 for ListQueue?");
        String in = scan.nextLine();

        if (in.equals("1")) { q = new ArrayQueue();}

        else if (in.equals("2")) {q = new ListQueue();}

        else {
            System.out.println("Invalid option.");
            System.out.println("Please enter 1 for array implementation or 2 for list implementation.");
            in = scan.nextLine();
            while (!in.equals("1") && (!in.equals("2"))) {
                System.out.println("Invalid option.");
                System.out.println("Please enter 1 for array implementation or 2 for list implementation.");
                in = scan.nextLine();
            }

            if (in.equals("1")) {q = new ArrayQueue();}

            else {q = new ListQueue();}
        }
        //Premade by instructor
        Integer x = 42;
        q.add(x);
        x = 17;
        q.add(x);
        x = 37;
        q.add(x);
        x = 36;
        q.add(x);
        x = 12;
        q.add(x);
        /*
        Add the code to print the queue. After the code is finished,
        the queue should still contain all its values in order
        */
        System.out.println("Elements of the Queue: ");
        System.out.println(q.size());
        IQueue temp = q;
        for (Integer k = 0; k < q.size(); k++) {
            Integer holder = q.pop();
            System.out.println(holder + " ");
            temp.add(holder);
        }
    }
}
