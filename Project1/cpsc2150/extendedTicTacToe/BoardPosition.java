/*
  Kellen Haas
  CPSC 2150
  Project 1
  9/20/20
 */



package cpsc2150.extendedTicTacToe;

/**
 * @invariant [must track all positions inserted on the board that are valid]
 * @invariant [coordinates must always be displayed as (<row>, <column>)]
 * @invariant [(0,0) must be the top left of the board]
*/

public class BoardPosition {
    private int Row;
    private int Column;


    /**
     * BoardPosition Constructor
     * @param r = [the row of the position on the game board]
     * @param c = [the column of the position on the game board]
     * @pre (0 <= r <= 7) and (0 <= c <= 7)
     * @return [returns a BoardPosition Object]
     * @post [The GameBoard was successfully created and
     *       then used BoardPosition as a parameter for its methods
     *       to mark the various valid positions on the board.]
     */
    public BoardPosition(int r, int c) {
        Row = r;
        Column = c;
    }

    /**
     * @return returns the Row position
     */
    public int getRow() {return Row;}


    /**
     * @return returns the Column position
     */
    public int getColumn() {return Column;}


    /**
     * @pre [Position passed into the function must be valid]
     * @param pos = [position or pair of coordinates for the last player's move]
     * @return [true if the object passed in contains matching data to the object it is being compared with]
     * @return [false if the object passed in does not contain matching data to the object it is being compared with]
     * @post [Will be true if the two objects are equal and false otherwise]
     */
    @Override
    public boolean equals(Object pos) {return true;}



    /**
     * @pre [The position is checked for validity]
     * @pre [Both the row and column are passed into checkSpace to ensure validity]
     * @return [The String array of a position (aka a Row and Column pair)]
     * @post [Formats a pair of valid coordinates as a string]
     */
    @Override
    public String toString() {return "(" + Row + ", " + Column + ")";}


}

