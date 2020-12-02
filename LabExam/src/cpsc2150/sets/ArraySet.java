package cpsc2150.sets;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.util.ArrayList;
import java.util.Random;

public class ArraySet<T> extends SetAbs<T> implements ISet<T> {
    private T[] mySet;

    private int count;

    public ArraySet() {
        count = 0;
        mySet = (T[])(new Object[MAX_SIZE]);
    }


    public void add(T val) {
        mySet[count] = val;
        count++;
    }

    public T remove() {
        int index = 0;
        for (int i = 0; i < count; i++) {
            if (mySet[i].equals(this.remove())) {
                index = i;
            }
        }
        return mySet[index];
    }


    public boolean contains(T val) {
        int index = 0;
        for (int i = 0; i < count; i++) {
            if (mySet[i].equals(val)) {
                index = i;
            }
        }
        return (mySet[index].equals(val));
    }



    public int getSize() {
        return count;
    }
}
