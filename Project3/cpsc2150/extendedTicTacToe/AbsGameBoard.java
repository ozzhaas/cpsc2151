/* Kellen Haas
   CPSC 2150
   Project 3
   10/28/20
 */

package cpsc2150.extendedTicTacToe;


public abstract class AbsGameBoard implements cpsc2150.extendedTicTacToe.IGameBoard {

    /**
     * @pre [The game board is empty at the start of the game] and [The game board has
     *      valid positions on it if the game has started or finished]
     * @return [The String array of the Row and Column positions making the game board]
     *         [printed during the game]
     * @post [The string is formatted to return to GameScreen and print to the terminal]
     */
    @Override
    public String toString() {
        String gameBoardStr = " ";
        int strRow = getNumRows();
        int strCol = getNumColumns();

        //Label the column indexes
        for (int i = 0; i < strCol; i++) {
            if (i == 0) {
                gameBoardStr = gameBoardStr + "\t  " + i + " " + '|';
            }
            else if (i < 10) {
                gameBoardStr = gameBoardStr + " " + i + " " + '|';
            }
            else {
                gameBoardStr = gameBoardStr  + " " + i + " " + '|';
            }
        }

        gameBoardStr = gameBoardStr + "\n";

        //Create the rows
        for (int i = 0; i < strRow; i++) {
            if (i < 10) {
                gameBoardStr = gameBoardStr + " " + i + "  " + '|';
            }
            else {
                gameBoardStr = gameBoardStr + " " + i + " " + '|';
            }
            for (int c = 0; c < strCol; c++) {
                BoardPosition stringPos;
                stringPos = new BoardPosition(i, c);
                if (c >= 10) {
                    gameBoardStr = gameBoardStr + " " + whatsAtPos(stringPos) + "  " + '|';
                }
                else {
                    gameBoardStr = gameBoardStr + " " + whatsAtPos(stringPos) + " " + '|';
                }
            }
            gameBoardStr = gameBoardStr + "\n";
        }

        return gameBoardStr;
    }

}
