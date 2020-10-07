/* Kellen Haas
   CPSC 2150
   Lab5
   9/23/20
 */

package cpsc2150.MyQueue;

import java.awt.*;

/**
 * Initialization Ensures: Queue is less than MAX_DEPTH and will only contain Integers
 * Defines: length() = the length of the Queue
 *          MAX_DEPTH -> the maximum length of the Queue
 * Constraints: 0 < length of Queue < MAX_DEPTH
 *
 * A queue containing integers.
 * A queue is a data structure where the first item added to the
 * structure is the first item removed from the structure
 * This queue is bounded by MAX_DEPTH
 */
public interface IQueue {
    int MAX_DEPTH = 100;

    /**
     * @pre Queue length() < MAX_DEPTH
     * @param x The Integer being pushed into the end of the Queue
     * @post [x is in the last position of the Queue] and
     *      length() = #length() + 1
     * @return void
     */
    public void enqueue(Integer x);


    /**
     * @pre Queue length() > 0
     * @post length() = #length() - 1
     * @return the Integer from the front of the Queue
     */
    public Integer dequeue();


    /**
     * @pre Queue != 0 and Queue != NULL
     * @post 0 <= length() < MAX_DEPTH
     * @return the number of Integers in the Queue
     */
    public int length();


    /**
     * @pre 0 <= length() < MAX_DEPTH
     * @post Queue = 0
     * @return [an empty Queue]
     */
    public void clear();


    /**
     * @pre length() > 0
     * @post Queue = #Queue
     * @return The Integer in the front of the Queue
     */
    default Integer peek(){
        return get(1);
    }


    /**
     * @pre 1 <= pos <= length() + 1 < MAX_DEPTH
     * @post length() = #length() + 1 and [(positions > pos) = #position + 1]
     * @param x The Integer being inserted into the Queue
     * @param pos The position in the Queue where x will be placed
     *              where 1 is the front of the Queue
     */
    default void insert(Integer x, int pos){

        int size = length()+1;

        //temporary array to store the Queue
        Integer [] tempQ = new Integer[size];

        //Integers from 0-pos into tempQ
        for(int i = 1;i < pos;i++) {
            tempQ[i-1] = dequeue();
        }

        //add x into tempQ
        tempQ[pos-1] = x;

        //add the rest of the Queue into tempQ
        for(int i = 0; i < size - pos;i++){
            tempQ[pos+i] = dequeue();
        }

        //refill the Queue from tempQ
        for(int k = 0; k < size; k++){
            enqueue(tempQ[k]);
        }
    }


    /**
     * @pre 1 <= pos <= length()
     * @post length() = #length() - 1 and [(positions > pos) = #position - 1]
     * @param pos The position in Queue to remove
     * @return The Integer that was in the position pos of the Queue
     *          where 1 is the front of the Queue
     */
    default Integer remove(int pos){

        int size = length()-1;
        Integer rem;

        //temporary array to store the Queue
        Integer [] tempQ = new Integer[size];

        //Integers from 0-pos into tempQ
        for(int i = 1;i < pos;i++) {
            tempQ[i-1] = dequeue();
        }

        rem = dequeue();

        //add the rest of the Queue into tempQ
        for(int i = -1; i < size - pos;i++){
            tempQ[pos+i] = dequeue();
        }

        //refill the Queue from tempQ
        for(int k = 0; k < size; k++){
            enqueue(tempQ[k]);
        }

        return rem;
    }

    /**
     * @pre depth > 0
     * @post Queue = #Queue
     * @return The T at the end of the Queue
     */
    default Integer endOfQueue(){
        return get(length());
    }

    /**
     * @pre 1 <= pos <= length()
     * @post Queue = #Queue
     * @param pos The position in the Queue of an Integer you want to see
     *              where 1 is the front of the Queue
     * @return The Integer in position pos of the Queue
     */
    default Integer get(int pos){
        Integer atPos = null;
        pos -= 1;
        for(int i = 0;i < length();i++) {
            Integer tmp = dequeue();
            if (i == pos) {
                atPos = tmp;
            }
            enqueue(tmp);
        }
        return atPos;
    }

}