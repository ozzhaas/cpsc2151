/* Kellen Haas
   CPSC 2150
   Lab5
   9/23/20
 */


package cpsc2150.MyQueue;

import java.util.*;

public class ListQueue extends AbsQueue implements IQueue{

    /**
     * @invariants 0 <= depth <= MAX_DEPTH and
     * [depth = number of Integers in myQ]
     * Correspondence IQueue = myQ
     *                IQueue.length() = ListQueue.length()
     */

    //this time store the queue in a list
    //myQ.get(0) is the front of the queue
    private List<Integer> myQ;

    /**
     * @post myQ.size() = 0 and [myQ is empty]
     */
    public ListQueue() {
        myQ = new ArrayList<Integer>();
    }

    /**
     * @pre myQ.size() < MAX_DEPTH
     * @post myQ.size() = #myQ.size() + 1 and x = myQ[myQ.size()]
     * @param x The Integer being pushed into the end of the Queue
     */
    public void enqueue(Integer x){
        myQ.add(x);
    }

    /**
     * @pre myQ.size() > 0
     * @post myQ.size() = #myQ.size() - 1
     * @return Returns the first Integer in the Queue
     */
    public Integer dequeue() {
        Integer x = myQ.get(0);

        myQ.remove(0);
        return x;
    }

    /**
     * @post 0 <= myQ.size() <= MAX_DEPTH
     * @return The current amount of Integers in myQ
     */
    public int length() {
        return myQ.size();
    }




    public void clear() {
        for (int i = 0; i < length(); i++) {
            if (myQ.get(0) == null) {
                return;
            }
            myQ.remove(i);
        }
    }
}

