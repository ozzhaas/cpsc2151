/* Kellen Haas
   CPSC 2150
   Lab5
   9/23/20
 */

package cpsc2150.MyQueue;

public class ArrayQueue extends AbsQueue implements IQueue {

    /**
     * @invariants 0 <= depth <= MAX_DEPTH and
     *          [depth = number of Integers in myQ]
     * Correspondence IQueue = myQ
     *                IQueue.length() = ArrayQueue.length()
     */

    // where the data is stored. myQ[0] is the front of the queue
    private Integer[] myQ;

    //tracks how many items in the queue
    // also used to find the end of the queue
    private int depth;

    /**
     * @post myQ size = MAX_DEPTH and depth = 0
     */
    public ArrayQueue() {
        myQ = new Integer [MAX_DEPTH];
        depth = 0;
    }

    /**
     * @pre depth < MAX_DEPTH
     * @post depth = #depth + 1 and x = myQ[depth]
     * @param x The Integer being pushed into the end of the Queue
     */
    public void enqueue(Integer x){
        myQ[depth] = x;
        depth++;

    }

    /**
     * @pre depth > 0
     * @post depth = #depth - 1
     * @return Returns the first Integer in the Queue
     */
    public Integer dequeue() {
        Integer x = myQ[0];

        for(int i = 0; i < depth;i++){
            myQ[i] = myQ[i+1];
        }

        depth--;
        return x;
    }

    /**
     * @post 0 <= depth <= MAX_DEPTH
     * @return The current amount of Integers in myQ
     */
    public int length() {
        return depth;
    }


    public void clear() {depth = 0;}


}