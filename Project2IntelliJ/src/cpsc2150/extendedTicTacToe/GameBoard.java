package cpsc2150.extendedTicTacToe;

import java.util.Objects;

public class GameBoard extends AbsGameBoard implements IGameBoard {
    private char[][] ticTacBoard;
    private int numRows;
    private int numCols;
    private int numToWin;
    private int count = 0;


    /**
     * @post [a game board is created and is empty and ready for the users to play]
     */

    public GameBoard(int rows, int cols, int win) {
        //Create the game board//
        this.numRows = rows;
        this.numCols = cols;
        this.numToWin = win;
        ticTacBoard = new char [rows][cols];
        //Initialize all positions on the board to blank space//
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ticTacBoard[i][j] = ' ';
            }
        }
    }



    public void placeMarker(BoardPosition marker, char player) {
        //places the character in marker on the position specified by marker,
        //and should not be called if the space is not available.
        ticTacBoard[marker.getRow()][marker.getColumn()] = player;
        count++;

    }


    @Override
    public boolean checkForDraw(BoardPosition lastPos) {
        //this function will check to see if the game has resulted in a tie.
        //A game is tied if there are no free board positions remaining.
        //It will return true if the game is tied, and false otherwise.
        if (count == MAX_LEN) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean isPlayerAtPos(BoardPosition pos, char player) {
        if (whatsAtPos(pos) == player) {
            return true;
        }
        else {
            return false;
        }
    }

    public char whatsAtPos(BoardPosition pos) {
        return ticTacBoard[pos.getRow()][pos.getColumn()];
    }


    public int getNumRows() {
        return numRows;
    }

    public int getNumColumns() {
        return numCols;
    }

    public int getNumToWin() {
        return numToWin;
    }

}