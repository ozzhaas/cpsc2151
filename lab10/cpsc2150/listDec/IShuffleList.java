package cpsc2150.listDec;

import java.util.*;

public interface IShuffleList<T> extends List<T> {

    /**
     * @param swaps [The number of swaps that need to take place]
     * @pre swaps > 0
     * @pre size() >= 2 [size() = List.size()]
     * @post List.at(1) = #List.at(random num) and List.at(2) = #List.at(random num)...List.at(n) = #List.at(random num)
     */
    default void shuffle (int swaps) {
        int r1, r2;
        int numOfShuffles = 0;
        Random rand = new Random();
        while (numOfShuffles < swaps) {
            r1 = rand.nextInt(size());
            r2 = rand.nextInt(size());
            swap(r1, r2);
            numOfShuffles++;
        }
    }


    /**
     * @param i List.at(i) [aka the first position to be swapped]
     * @param j List.at(j) [aka the second position to be swapped]
     * @pre i and j must be different numbers
     * @pre i >= 0 and i < List.size() && j >= 0 and j < List.size()
     * @pre List.size() >= 0
     * @post List.at(i) = #List.at(j) && List.at(j) = #List.at(i)
     */
    default void swap (int i, int j) {
        T temp = get(i);
        set(i, get(j));
        set(j, temp);
    }


}
