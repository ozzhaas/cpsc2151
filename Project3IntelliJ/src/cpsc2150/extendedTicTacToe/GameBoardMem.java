package cpsc2150.extendedTicTacToe;

import java.sql.SQLType;
import java.util.*;
import java.util.Map;
import java.util.HashMap;

public class GameBoardMem extends AbsGameBoard implements IGameBoard {
    private int numRows;
    private int numCols;
    private int numToWin;
    private int count;
    private int length;
    private Map<Character, List<BoardPosition>> ticTacMap;


    /**
     * @pre [the user wants to play Extended Tic Tac Toe]
     * @post [a game board is created and is empty and ready for the users to play]
     */
    public GameBoardMem(int rows, int cols, int win) {
        //Create the game board//
        this.count = 0;
        this.numRows = rows;
        this.numCols = cols;
        this.numToWin = win;
        ticTacMap = new HashMap<>();
        if (numCols > numRows) {
            this.length = numCols;
        }
        else {
            this.length = numRows;
        }
    }

    public void placeMarker(BoardPosition marker, char player) {
        //places the character in marker on the position specified by marker,
        //and should not be called if the space is not available.
        if (ticTacMap.containsKey(player)) {
            ticTacMap.get(player).add(marker);
        } else {
            List<BoardPosition> tempList = new ArrayList<>();
            tempList.add(marker);
            ticTacMap.put(player, tempList);
        }
        count++;
    }


    /**
     * @param lastPos
     * @pre [Assumes that all positions are placed in a valid fashion]
     * @return (True [if the game is a tie] or False [if the game is not a tie])
     * @post [If true, there is a tie]
     */

    @Override
    public boolean checkForDraw(BoardPosition lastPos) {
        //this function will check to see if the game has resulted in a tie.
        //A game is tied if there are no free board positions remaining.
        //It will return true if the game is tied, and false otherwise.
        int totalPlacements = numRows * numCols;
        if (count == totalPlacements) {
            return true;
        }
        else {
            return false;
        }
    }
//
//    @Override
//    public boolean isPlayerAtPos(BoardPosition pos, char player) {
//        if (ticTacMap.containsKey(player)) {
//            return true;
//
//        } else {
//            return false;
//        }
//    }


    public char whatsAtPos(BoardPosition pos) {
        for (Map.Entry <Character, List<BoardPosition>> m : ticTacMap.entrySet()) {
            if (m.getValue().contains(pos)) {
                return m.getKey();
            }
        }
        return ' ';
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