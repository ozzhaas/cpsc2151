/*Kellen Haas
  CPSC 2150
  Lab8
  10/18/20
 */

package cpsc2150.MyQueue;

public class ArrayQueue<T> extends AbsQueue<T> implements IQueue<T>{

    /**
     * @invariants 0 <= depth <= MAX_DEPTH and
     *          [depth = number of Ts in myQ]
     * Correspondence IQueue = myQ
     */

	private T [] myQ;
    private int depth;

    /**
     * @post myQ size = MAX_DEPTH and depth = 0
     */
    public ArrayQueue() {
	    myQ = (T[]) new Object [IQueue.MAX_DEPTH];
        depth = 0;
    }


    public void enqueue(T x){
        if(depth == MAX_DEPTH){
            return;
        }
        myQ[depth] = x;
        depth++;
    }


    public T dequeue() {
        T x = myQ[0];

        for(int i = 0; i < depth-1;i++){
            myQ[i] = myQ[i+1];
        }
        depth--;
        return x;
    }


    public int length() {
        return depth;
    }


    public void clear() {
        depth = 0;
    }

}
