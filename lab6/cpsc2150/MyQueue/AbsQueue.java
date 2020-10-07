/* Kellen Haas
   CPSC 2150
   Lab5
   10/02/20
 */

package cpsc2150.MyQueue;

import java.lang.*;
import java.util.*;

public abstract class AbsQueue<T> implements IQueue<T>{

    @Override
    public String toString(){

        String qString = "";

        for(int i = 1; i < length() + 1;i++){
            qString += get(i) + " ";
        }

        return qString;
    }
}