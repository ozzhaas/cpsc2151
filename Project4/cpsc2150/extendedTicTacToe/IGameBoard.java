package cpsc2150.extendedTicTacToe;

import java.util.Objects;

/**
 * IGameboard Object is a 2D gameboard that contains markers for the players who are playing the game of TicTacToe.
 * The current markers are only X and O. Markers cannot be placed on top of other markers (aka in a position already
 * taken) and they cannot be placed out of the bounds of the game board which is currently an 8x8 grid. In the future
 * the size of the board may change in which case its size would be the number of rows * the number of columns.
 *
 * @Defines: numRows: Z - the number of rows in the game board
 *           numCols: Z - the number of columns in the game board
 *
 * @Initialization Ensures: [The game board does not have any markers as all spaces are initialized to ' ']
 *
 * @Constraints: number of rows > 0 and < 100
 *               number of columns > 0 and < 100
 *               number of markers in-a-row to win must be >= 2 and < 25
 */


public interface IGameBoard {
    public static final int MIN_LEN = 3;
    public static final int MAX_LEN = 100;
    public static final int count = 0;


    /**
     * @param pos [the position the user chose] and [must have both a Row and a Column value]
     * @pre [The user chose a position that is an integer between 0 and 7]
     * @return (True [if pos is empty and in the bounds of the board]) and
     *         (False [if pos is out of bounds or already taken])
     * @post [The position pos is a valid choice]
     */
    default boolean checkSpace(BoardPosition pos) {
        //returns true if the position specified in pos is available,
        //false otherwise. If a space is not in bounds, then it is not available
        if ((pos.getRow() >= 0) && (pos.getRow() < getNumRows()) && (pos.getColumn() >= 0) && (pos.getColumn() < getNumColumns()) && (whatsAtPos(pos) == ' ')) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @param marker = [position to place the character player on the game board]
     * @pre [The position passed in as marker must be valid and if it is not, then this
     *      function shouldn't be called]
     * @return void
     * @post [Makes sure to place a marker in a position that is not already taken or is invalid]
     */
    public void placeMarker(BoardPosition marker, char player);


    /**
     * @param lastPos = [the last position placed on the game board]
     * @pre [The position passed in must be valid and in bounds before it can
     *      be checked for a potential winner]
     * @return (True [if lastPos won the game]) or (False [if lastPos didn't win the game])
     * @post [Will determine if there is a winner from only the specific position. Since
     *       it will be called every time a game piece is placed, you can assume it would've
     *       caught a previous win if there was one.]
     */

    default boolean checkForWinner(BoardPosition lastPos) {
        //this function will check to see if the lastPos placed resulted in
        //a winner. If so it will return true, otherwise false.
        boolean horizontal = false;
        boolean vertical = false;
        boolean diagonal = false;

        horizontal = checkHorizontalWin(lastPos);
        vertical = checkVerticalWin(lastPos);
        diagonal = checkDiagonalWin(lastPos);

        if (horizontal || vertical || diagonal) {
            return true;
        }
        return false;
    }


    /**
     * @param lastPos
     * @pre [Assumes that all positions are placed in a valid fashion]
     * @return (True [if the game is a tie]) or (False [if the game is not a tie]
     * @post [If true, there is a tie]
     */
    default boolean checkForDraw(BoardPosition lastPos) {
        //this function will check to see if the game has resulted in a tie.
        //A game is tied if there are no free board positions remaining.
        //It will return true if the game is tied, and false otherwise.
        System.out.println("Count = " + count);
        if (count == getNumColumns() * getNumRows() && !checkForWinner(lastPos)) {
            return true;
        }
        else {
            return false;
        }
    }



    /**
     * @param lastPos = [last position placed on the board]
     * @pre [The last marker that was placed is valid and was passed properly to this function]
     * @return (True [if the move lastPos won the game horizontally]) or
     *         (False [if the move lastPos did not win the game horizontally])
     * @post [The specified Row of the board is checked for a win]
     */

    default boolean checkHorizontalWin(BoardPosition lastPos) {
        //checks to see if the last marker placed resulted in 5 in a row horizontally
        //by checking if it matches the other 4 players in a sequence next to it
        //Returns true if it does, otherwise false
        int numOfHMatches = 1;
        int row = lastPos.getRow();
        //Move the column left one space
        int column = lastPos.getColumn() - 1;

        //Loop through all of the columns holding the row (in which the marker was
        //just placed) constant.
        while (column >= 0 && numOfHMatches < getNumToWin()) {
            if (whatsAtPos(new BoardPosition(row, column)) == whatsAtPos(lastPos)) {
                numOfHMatches++;
            }
            else {
                break;}
            column--;
        }

        //Now move the column to the right one space
        column = lastPos.getColumn() + 1;
        while (column < getNumColumns() && numOfHMatches < getNumToWin()) {
            if (whatsAtPos(new BoardPosition(row, column)) == whatsAtPos(lastPos)) {
                numOfHMatches++;
            }
            else {
                break;}
            column++;
        }
        if (numOfHMatches >= getNumToWin()) {
            return true;
        }
        return false;
    }



    /**
     * @param lastPos = [last position placed on the board]
     * @pre [The last marker that was placed is valid and was passed properly to this function]
     * @return (True [if the move lastPos won the game vertically]) or
     *         (False [if the move lastPos did not win the game vertically])
     * @post [The specified Column of the board is checked for a win]
     */
    default boolean checkVerticalWin(BoardPosition lastPos) {
        //checks to see if the last marker placed resulted in 5 in a row vertically.
        //Returns true if it does, otherwise false
        int numOfVMatches = 1;
        //Move the column left one space
        int column = lastPos.getColumn();

        //Loop through all of the rows holding the row (in which the marker was
        //just placed) constant.
        int row = lastPos.getRow() - 1;

        while (row >= 0 && numOfVMatches < getNumToWin()) {
            if (whatsAtPos(new BoardPosition(row, column)) == whatsAtPos(lastPos)) {
                numOfVMatches++;
            }
            else {
                break;}
            row--;
        }


        //Now move the row up one space
        row = lastPos.getRow() + 1;

        while (row < getNumRows() && numOfVMatches < getNumToWin()) {
            if (whatsAtPos(new BoardPosition(row, column)) == whatsAtPos(lastPos)) {
                numOfVMatches++;
            }
            else {
                break;}
            row++;
        }
        if (numOfVMatches >= getNumToWin()) {
            return true;
        }
        return false;
    }



    /**
     * @param lastPos = [last position placed on the board]
     * @pre [The last marker that was placed is valid and was passed properly to this function]
     * @return (True [if the move lastPos won the game diagonally]) or
     *         (False [if the move lastPos did not win the game diagonally])
     * @post [The specified diagonal of the board is checked for a win]
     */
    default boolean checkDiagonalWin(BoardPosition lastPos) {
        //checks to see if the last marker placed resulted in 5 in a row diagonally.
        // Returns true if it does, otherwise false
        int countInARow = 1;
        int secondCountInARow = 1;
        int row = lastPos.getRow() - 1;
        int col = lastPos.getColumn() - 1;

        //First scan from lastPos to the top left
        while (countInARow < getNumToWin() && row >= 0 && col >= 0) {
            if (isPlayerAtPos(new BoardPosition(row, col), whatsAtPos(lastPos))) {
                countInARow++;
            }
            else {
                break;
            }
            //Decrement to go diagonally up to the top left
            row--;
            col--;
        }


        //Next scan from lastPos to the top right
        row = lastPos.getRow() - 1;
        col = lastPos.getColumn() + 1;

        while (secondCountInARow < getNumToWin() && row >= 0 && col < getNumColumns()) {
            if (countInARow >= getNumToWin()) {
                break;
            }
            else if (isPlayerAtPos(new BoardPosition(row, col), whatsAtPos(lastPos))) {
                secondCountInARow++;
            }
            else {
                break;
            }
            //Increment the column and decrement the row to go diagonally up from
            //lastPos to the top right
            row--;
            col++;
        }


        //Next scan from lastPos to the bottom right
        row = lastPos.getRow() + 1;
        col = lastPos.getColumn() + 1;
        while (row < getNumRows() && col < getNumColumns() && countInARow < getNumToWin()) {
            if (secondCountInARow >= getNumToWin()) {
                break;
            }
            else if (isPlayerAtPos(new BoardPosition(row, col), whatsAtPos(lastPos))) {
                countInARow++;
            }
            else {
                break;
            }
            //Increment the column and the rows to go diagonally down from lastPos
            //to the bottom right
            row++;
            col++;
        }

        //Next scan from lastPos to the bottom left
        row = lastPos.getRow() + 1;
        col = lastPos.getColumn() - 1;
        while (row < getNumRows() && col >= 0 && secondCountInARow < getNumToWin()) {
            if (countInARow >= getNumToWin()) {
                break;
            }
            if (isPlayerAtPos(new BoardPosition(row, col), whatsAtPos(lastPos))) {
                secondCountInARow++;
            }
            else {
                break;
            }
            //Increment the row and decrement the columns to go diagonally
            //down from lastPos to the bottom left of the game board.
            row++;
            col--;
        }
        if (countInARow == getNumToWin() || secondCountInARow == getNumToWin()) {
            return true;
        }
        return false;
    }




    public char whatsAtPos(BoardPosition pos);

    default boolean isPlayerAtPos(BoardPosition pos, char player) {
        if (whatsAtPos(pos) == player) {
            return true;
        }
        else {
            return false;
        }
    }

    public int getNumRows();

    public int getNumColumns();

    public int getNumToWin();

}

