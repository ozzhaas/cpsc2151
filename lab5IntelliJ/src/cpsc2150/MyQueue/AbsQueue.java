/* Kellen Haas
   CPSC 2150
   Lab5
   9/23/20
 */

package cpsc2150.MyQueue;

import java.lang.*;
import java.util.*;

public abstract class AbsQueue implements IQueue{

    @Override
    public String toString(){

        String qString = "";

        for(int i = 1; i < size() + 1;i++){
            qString += get(i).toString();
        }

        return qString;
    }
}