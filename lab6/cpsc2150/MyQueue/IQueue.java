/* Kellen Haas
   CPSC 2150
   Lab5
   10/02/20
 */

package cpsc2150.MyQueue;

/**
 * A queue containing T.
 * A queue is a data structure where the first item enqueueed to the
 * structure is the first item removed from the structure
 * This queue is bounded by MAX_DEPTH
 */
public interface IQueue<T> {
    int MAX_DEPTH = 100;

    /**
     * @pre Queue length() < MAX_DEPTH
     * @param x The T being pushed into the end of the Queue
     * @post [x is in the last position of the Queue] and
     *      length() = #length() + 1
     * @return void
     */
    public void enqueue(T x);

    /**
     * @pre Queue length() > 0
     * @post length() = #length() - 1
     * @return the T from the front of the Queue
     */
    public T dequeue();

    /**
     * @pre 0 <= amount of objects in Queue <= MAX_DEPTH
     * @post 0 <= length <= MAX_DEPTH
     * @return the number of T in the Queue
     */
    public int length();

    /**
     * @pre length() > 0
     * @post Queue = #Queue
     * @return The T in the front of the Queue
     */
    default T peek(){
        return get(1);
    }

    /**
     * @pre depth > 0
     * @post Queue = #Queue
     * @return The T at the end of the Queue
     */
    default T endOfQueue(){
        return get(length());
    }

    /**
     * @pre 1 <= pos <= length() + 1 < MAX_DEPTH
     * @post length() = #length() + 1 and [(positions > pos) = #position + 1]
     * @param x The T being inserted into the Queue
     * @param pos The position in the Queue where x will be placed
     */
    default void insert(T x, int pos){

        int length = length()+1;

        //temporary array to store the Queue
		@SuppressWarnings("unchecked")
        T [] tempQ = (T[]) new Object [length];

        //Ts from 0-pos into tempQ
        for(int i = 1;i < pos;i++) {
            tempQ[i-1] = dequeue();
        }

        //enqueue x into tempQ
        tempQ[pos-1] = x;

        //enqueue the rest of the Queue into tempQ
        for(int i = 0; i < length - pos;i++){
            tempQ[pos+i] = dequeue();
        }

        //refill the Queue from tempQ
        for(int k = 0; k < length; k++){
            enqueue(tempQ[k]);
        }
    }

    /**
     * @pre 1 <= pos <= length()
     * @post length() = #length() - 1 and [(positions > pos) = #position - 1]
     * @param pos The position in Queue to remove
     * @return The T that was in the position pos of the Queue
     *          where 1 is the front of the Queue
     */
    default T remove(int pos){

        int length = length()-1;
        T rem;

        //temporary array to store the Queue
		@SuppressWarnings("unchecked")
        T [] tempQ = (T[]) new Object [length];

        //Ts from 0-pos into tempQ
        for(int i = 1;i < pos;i++) {
            tempQ[i-1] = dequeue();
        }

        rem = dequeue();

        //enqueue the rest of the Queue into tempQ
        for(int i = -1; i < length - pos;i++){
            tempQ[pos+i] = dequeue();
        }

        //refill the Queue from tempQ
        for(int k = 0; k < length; k++){
            enqueue(tempQ[k]);
        }

        return rem;
    }

    /**
     * @pre 1 <= pos <= length()
     * @post Queue = #Queue
     * @param pos The position in the Queue of an T you want to see
     *              where 1 is the front of the Queue
     * @return The T in position pos of the Queue
     */
    default T get(int pos) {
        pos -= 1;
        T atPos = null;

        for(int i = 0;i < length();i++) {
            T tmp = dequeue();
            if (i == pos) {
                atPos = tmp;
            }
            enqueue(tmp);
        }
        return atPos;
    }
}
