/* Kellen Haas
   CPSC 2150
   Lab4
   9/18/20
 */

package cpsc2150.MyQueue;

/**
 * A queue containing integers.
 * A queue is a data structure where the first item added to the
 * structure is the first item removed from the structure
 * This queue is bounded by MAX_DEPTH
 */
public interface IQueue {
    int MAX_DEPTH = 100;

    /**
     * @pre Queue size() < MAX_DEPTH
     * @param x The Integer being pushed into the end of the Queue
     * @post [x is in the last position of the Queue] and
     *      size() = #size() + 1
     * @return void
     */
    public void add(Integer x);

    /**
     * @pre Queue size() > 0
     * @post size() = #size() - 1
     * @return the Integer from the front of the Queue
     */
    public Integer pop();

    /**
     * @pre Queue size() > 0 and Queue size() < MAX_DEPTH
     * @post 0 <= size <= MAX_DEPTH
     * @return the number of Integers in the Queue
     */
    public int size();
}

