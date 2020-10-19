/*Kellen Haas
  CPSC 2150
  Lab8
  10/18/20
 */

package cpsc2150.MyQueue;

import java.lang.*;
import java.util.NoSuchElementException;

import static junit.framework.Assert.*;
import org.junit.Test;

public class TestArrayQueue {

    public static Double MY_DOUBLE = 10.0;
    public static Integer MY_INT = 10;

    private IQueue<Double> MakeAQueue(){
        IQueue<Double> thisQueue = new ArrayQueue<>();
        return thisQueue;
    }

    @Test
    public void test_enqueue_length_increase(){
        IQueue<Double> myQueue = MakeAQueue();
        int init_length = myQueue.length();

        myQueue.enqueue(MY_DOUBLE);

        assertTrue(myQueue.length() == (init_length + 1));
    }

    @Test
    public void test_enqueue_empty_queue(){
        IQueue<Double> myQueue = MakeAQueue();

        myQueue.enqueue(MY_DOUBLE);

        assertTrue(myQueue.get(1).equals(MY_DOUBLE));
    }

    @Test
    public void test_enqueue_MAX_DEPTH(){

        IQueue<Double> myQueue = MakeAQueue();
        for (int i = 1; i <= myQueue.MAX_DEPTH -1; i++) {
            myQueue.enqueue((double)i);
        }

        myQueue.enqueue(MY_DOUBLE);

        assertTrue(myQueue.get(100) == 10.0);
    }

    @Test
    public void test_dequeue_length_decrease() {
        IQueue<Double> myQueue = MakeAQueue();
        int init_length = myQueue.length();

        myQueue.dequeue();

        assertTrue(myQueue.length() == (init_length) - 1);
    }


    @Test
    public void test_dequeue_one_item() {
        IQueue<Double> myQueue = MakeAQueue();
        myQueue.enqueue(MY_DOUBLE);
        Double result = myQueue.dequeue();

        assertTrue(result.equals(MY_DOUBLE));
    }


    @Test
    public void test_dequeue_MAX_DEPTH() {
        IQueue<Double> myQueue = MakeAQueue();
        for (int i = 1; i <= myQueue.MAX_DEPTH - 1; i++) {
            myQueue.enqueue((double)i);
        }

        myQueue.enqueue(MY_DOUBLE);
        Double result = myQueue.dequeue();

        assertTrue(result == 1);
    }


    @Test
    public void test_clear_length() {
        IQueue<Double> myQueue = MakeAQueue();
        myQueue.clear();

        assertTrue(myQueue.length() == 0);
    }

    @Test
    public void test_clear_several_items() {
        IQueue<Double> myQueue = MakeAQueue();
        myQueue.enqueue(7.6);
        myQueue.enqueue(3.2);
        myQueue.enqueue(52.8);
        myQueue.clear();

        assertTrue(myQueue.length() == 0);
    }


    @Test
    public void test_clear_full_queue() {
        IQueue<Double> myQueue = MakeAQueue();
        for (int i = 1; i <= myQueue.MAX_DEPTH; i++) {
            myQueue.enqueue((double)i);
        }
        myQueue.clear();
        assertTrue(myQueue.length() == 0);
    }



    @Test
    public void test_peek_several_items(){
        IQueue<Double> myQueue = MakeAQueue();

        myQueue.enqueue(MY_DOUBLE);

        for(int i = 1; i <= MY_DOUBLE; i++){
            myQueue.enqueue((double)i);
        }

        assertTrue(myQueue.peek() == MY_DOUBLE);
    }

    @Test
    public void test_peek_one_item(){
        IQueue<Double> myQueue = MakeAQueue();
        myQueue.enqueue(MY_DOUBLE);

        assertTrue(myQueue.peek().equals(MY_DOUBLE));
    }

    @Test
    public void test_peek_full_queue(){
        IQueue<Double> myQueue = MakeAQueue();
        for (double i = 1; i <= myQueue.MAX_DEPTH; i++) {
            myQueue.enqueue(i);
        }
        double result = myQueue.dequeue();
        assertTrue(result == 1);
    }

    @Test
    public void test_endOfQueue_several_items(){
        IQueue<Double> myQueue = MakeAQueue();

        for(double i = 1; i <= MY_DOUBLE; i++){
            myQueue.enqueue(i);
        }

        assertTrue(myQueue.get(myQueue.length()) == 10.0);
    }

    @Test
    public void test_endOfQueue_one(){
        IQueue<Double> myQueue = MakeAQueue();
        myQueue.enqueue(MY_DOUBLE);

        assertTrue(myQueue.get(myQueue.length()).equals(MY_DOUBLE));
    }

    @Test
    public void test_endOfQueue_MAX_DEPTH(){
        IQueue<Double> myQueue = MakeAQueue();

        for(int i = 1; i <= myQueue.MAX_DEPTH; i++){
            myQueue.enqueue((double) i);
        }

        assertEquals(myQueue.get(myQueue.length()), 100.0);
    }

    @Test
    public void test_insert_empty_length(){
        IQueue<Double> myQueue = MakeAQueue();
        int init_length = myQueue.length();
        myQueue.insert(MY_DOUBLE,1);

        assertTrue(myQueue.length() == (init_length + 1));
    }

    @Test
    public void test_insert_back(){
        IQueue<Double> myQueue = MakeAQueue();
        for(double i = 1; i <= MY_DOUBLE; i++){
            myQueue.enqueue(i);
        }
        myQueue.insert(17.0,  11);
        assertTrue(myQueue.get(myQueue.length()) == 17.0);
    }

    @Test
    public void test_insert_front(){
        IQueue<Double> myQueue = MakeAQueue();
        for (double i = 1.0; i <= MY_DOUBLE; i++) {
            myQueue.enqueue(i);
        }
        myQueue.insert(7.0, 1);
        assertTrue(myQueue.get(1).equals(7.0));
    }

    @Test
    public void test_remove_one(){
        IQueue<Double> myQueue = MakeAQueue();

        myQueue.enqueue(MY_DOUBLE);


        assertTrue(myQueue.remove(1) == 10.0);
    }

    @Test
    public void test_remove_MAX_DEPTH(){
        IQueue<Double> myQueue = MakeAQueue();

        for(int i = 1; i <= myQueue.MAX_DEPTH; i++){
            myQueue.enqueue((double)i);
        }
        myQueue.remove(myQueue.length()-1);

        assertTrue(myQueue.get(myQueue.length()) == 100);
    }

    @Test
    public void test_remove_middle(){
        IQueue<Double> myQueue = MakeAQueue();
        for (double i = 1; i <= 3.0; i++) {
            myQueue.enqueue(i);
        }
        double rem = myQueue.remove(2);
        assertTrue(rem == 2.0);
    }

    @Test
    public void test_get_end_of_Queue(){
        IQueue<Double> myQueue = MakeAQueue();

        for(double i = 1.0; i <= myQueue.MAX_DEPTH;i++){
            myQueue.enqueue(i);
        }
        assertTrue(myQueue.get(myQueue.length()) == 100.0);
    }

    @Test
    public void test_get_middle(){
        IQueue<Double> myQueue = MakeAQueue();

        for(int i = 1; i <= MY_DOUBLE; i++){
            myQueue.enqueue(MY_DOUBLE);
        }

        myQueue.enqueue(MY_DOUBLE + 1);

        for(int i = 1; i <= MY_DOUBLE; i++){
            myQueue.enqueue(MY_DOUBLE);
        }

        assertTrue(!myQueue.get((int) (MY_DOUBLE + 1)).equals(MY_DOUBLE));
    }

    @Test
    public void test_get_beginning(){
        IQueue<Double> myQueue = MakeAQueue();

        myQueue.enqueue(MY_DOUBLE + 1);

        for(int i = 1; i <= MY_DOUBLE; i++){
            myQueue.enqueue(MY_DOUBLE);
        }

        assertTrue(myQueue.get(myQueue.length()-1).equals(MY_DOUBLE));
    }
}