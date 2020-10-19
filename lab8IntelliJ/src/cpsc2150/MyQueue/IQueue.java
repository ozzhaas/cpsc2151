/*Kellen Haas
  CPSC 2150
  Lab8
  10/18/20
 */

package cpsc2150.MyQueue;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * A queue containing T.
 * A queue is a data structure where the first item enqueueed to the
 * structure is the first item removed from the structure
 * This queue is bounded by MAX_DEPTH
 */
public interface IQueue<T> {
    int MAX_DEPTH = 100;

    /**
     * @param x The T being pushed into the end of the Queue
     * @return void
     * @pre Queue length() < MAX_DEPTH
     * @post [x is in the last position of the Queue] and
     * length() = #length() + 1
     */
    public void enqueue(T x);

    /**
     * @return the T from the front of the Queue
     * @pre Queue length() > 0
     * @post length() = #length() - 1
     */
    public T dequeue();

    /**
     * @return the number of T in the Queue
     * @pre 0 <= amount of objects in Queue <= MAX_DEPTH
     * @post 0 <= length <= MAX_DEPTH
     */
    public int length();

    /**
     * @return The T in the front of the Queue
     * @pre length() > 0
     * @post Queue = #Queue
     */
    default T peek() {
        T temp;
        T valToReturn = null;
        for(int i = 0; i < length(); i++){
            temp = dequeue();
            if (i == 0) {
                valToReturn = temp;
            }
            enqueue(temp);
        }
        return valToReturn;
    }

    /**
     * @return The T at the end of the Queue
     * @pre depth > 0
     * @post Queue = #Queue
     */
    default T endOfQueue(){
        return get(length());
    }

    /**
     * @param x   The T being inserted into the Queue
     * @param pos The position in the Queue where x will be placed
     * @pre 1 <= pos <= length() + 1 < MAX_DEPTH
     * @post length() = #length() + 1 and [(positions > pos) = #position + 1]
     */
    default void insert(T x, int pos) {
        pos -= 1;
        int length = length();
        for (int i = 0; i < length + 1; i++) {
            T popVar;
            if (i != pos) {
                popVar = dequeue();
            }
            else {
                popVar = x;
            }
            enqueue(popVar);
        }
    }

    /**
     * @param pos The position in Queue to remove
     * @return The T that was in the position pos of the Queue
     * where 1 is the front of the Queue
     * @pre 1 <= pos <= length()
     * @post length() = #length() - 1 and [(positions > pos) = #position - 1]
     */
    default T remove(int pos) {
        pos -= 1;
        int queueSize = length();
        T removedObj = null;
        for(int i = 0; i < queueSize; i++) {
            T temp = dequeue();
            if(i != pos) {
                enqueue(temp);
            }
            else {
                removedObj = temp;
            }
        }
        return removedObj;
    }

    /**
     * @param pos The position in the Queue of an T you want to see
     *            where 1 is the front of the Queue
     * @return The T in position pos of the Queue
     * @pre 1 <= pos <= length()
     * @post Queue = #Queue
     */
    default T get(int pos) {
        pos -= 1;
        T temp = null;
        T popTmp = null;
        for(int i = 0; i < pos; i++){
            popTmp = dequeue();
            enqueue(popTmp);
        }
        temp = peek();
        for(int j = 0; j < (length() - pos); j++) {
            popTmp = dequeue();
            enqueue(popTmp);
        }
        return temp;
    }



    /**
     * @return [an empty Queue]
     * @pre 0 <= length() < MAX_DEPTH
     * @post Queue = 0
     */
    public void clear();

}
