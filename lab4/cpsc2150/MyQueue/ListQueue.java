/* Kellen Haas
   CPSC 2150
   Lab4
   9/18/20
 */

package cpsc2150.MyQueue;

import java.util.*;

public class ListQueue implements IQueue {

    /**
     * @invariants 0 <= depth <= MAX_DEPTH and
     * [depth = number of Integers in myQ]
     * Correspondence IQueue = myQ
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
    public void add(Integer x){
        myQ.add(x);
    }

    /**
     * @pre myQ.size() > 0
     * @post myQ.size() = #myQ.size() - 1
     * @return Returns the first Integer in the Queue
     */
    public Integer pop() {
        Integer x = myQ.get(0);

        myQ.remove(0);
        return x;
    }

    /**
     * @post 0 <= myQ.size() <= MAX_DEPTH
     * @return The current amount of Integers in myQ
     */
    public int size() {
        return myQ.size();
    }
}

