/*Kellen Haas
  CPSC 2150
  Lab6
  5/31/20
 */

package cpsc2150.MyQueue;

public class ArrayQueue<T> extends AbsQueue<T> implements IQueue<T>{

    /**
     * @invariants 0 <= depth <= MAX_DEPTH and
     *          [depth = number of Ts in myQ]
     * Correspondence IQueue = myQ
     */

    // where the data is stored. myQ[0] is the front of the queue
	private T [] myQ;

    //tracks how many items in the queue
    // also used to find the end of the queue
    private int depth;

    /**
     * @post myQ size = MAX_DEPTH and depth = 0
     */
    public ArrayQueue() {
	    myQ = (T[]) new Object [IQueue.MAX_DEPTH];
        depth = 0;
    }

    /**
     * @pre depth < MAX_DEPTH
     * @post depth = #depth + 1 and x = myQ[depth]
     * @param x The T being pushed into the end of the Queue
     */
    public void enqueue(T x){
        myQ[depth] = x;
        depth++;
    }

    /**
     * @pre depth > 0
     * @post depth = #depth - 1
     * @return Returns the first T in the Queue
     */
    public T dequeue() {
        T x = myQ[0];

        for(int i = 0; i < depth;i++){
            myQ[i] = myQ[i+1];
        }

        depth--;
        return x;
    }

    /**
     * @post 0 <= depth <= MAX_DEPTH
     * @return The current amount of Ts in myQ
     */
    public int length() {
        return depth;
    }

}
