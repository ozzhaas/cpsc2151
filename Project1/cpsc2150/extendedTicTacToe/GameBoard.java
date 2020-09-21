/*
  Kellen Haas
  CPSC 2150
  Project 1
  9/20/20
 */



package cpsc2150.extendedTicTacToe;

/**
 * @invariant [All empty positions must be filled with blank space when the board is created
 * in the constructor]
 * @invariant [Originally, the markers must use either X or O to be valid]
 * @invariant lastPos = [expected to be valid] and pos = [position to check for validity]
 */


public class GameBoard {


    /**
     * @pre [the user wants to play Extended Tic Tac Toe]
     * @return [fully created, functional game board]
     * @post [a game board is created and is empty and ready for the users to play]
     */
    public GameBoard() {

    }



    /**
     * @param pos [the position the user chose] and [must have both a Row and a Column value]
     * @pre 0 <= pos <= 7 [The user chose a position that is an integer between 0 and 7]
     * @return (True [if pos is empty and in the bounds of the board]) and
     *         (False [if pos is out of bounds or already taken])
     * @post [The position pos is a valid choice]
     */
    public boolean checkSpace(BoardPosition pos) {
        // Returns true if the position specified in pos is available,
        // false otherwise. If a space is not in bounds, then it is not available

        return false;
    }



    /**
     * @param marker = [position to place the character player on the game board]
     * @pre [The position passed in as marker must be valid and if it is not, then this
     *      function shouldn't be called]
     * @return void
     * @post [Makes sure to place a marker in a position that is not already taken or is invalid]
     */
    public void placeMarker(BoardPosition marker, char player)
    {
        // Places the character in marker on the position specified by marker,
        // and should not be called if the space is not available.
    }




    /**
     * @param lastPos = [the last position placed on the game board]
     * @pre [The position passed in must be valid and in bounds before it can
     *      be checked for a potential winner]
     * @return (True [if lastPos won the game]) or (False [if lastPos didn't win the game])
     * @post [Will determine if there is a winner from only the specific position. Since
     *       it will be called every time a game piece is placed, you can assume it would've
     *       caught a previous win if there was one.]
     */
    public boolean checkForWinner(BoardPosition lastPos) {
        // This function will check to see if the lastPos placed resulted in
        // a winner. It so it will return true, otherwise false.
        // Passing in the last position will help limit the possible places
        // to check for a win condition, since you can assume that any win
        // condition that did not include the most recent play made would have
        // been caught earlier.
        // You may call other methods to complete this method
        return false;
    }




    /**
     * @pre [Assumes that all positions are placed in a valid fashion]
     * @return (True [if the game is a tie]) or (False [if the game is not a tie]
     * @post [If true, there is a tie]
     */
    public boolean checkForDraw()
    {
        // This function will check to see if the game has resulted in a tie.
        // A game is tied if there are no free board positions remaining.
        // You do not need to check for any potential wins, because we can assume that
        // the players were checking for win conditions as they played the game.
        // It will return true if the game is tied, and false otherwise.
        return false;
    }



    /**
     * @param lastPos = [last position placed on the board]
     * @pre [The last marker that was placed is valid and was passed properly to this function]
     * @return (True [if the move lastPos won the game horizontally]) or
     *         (False [if the move lastPos did not win the game horizontally])
     * @post [The specified Row of the board is checked for a win]
     */
    public boolean checkHorizontalWin(BoardPosition lastPos, char player) {
        // Checks to see if the last marker placed resulted in 5 in a row horizontally
        // by checking if it matches the other 4 players in a sequence next to it
        // Returns true if it does, otherwise false
        return false;
    }



    /**
     * @param lastPos = [last position placed on the board]
     * @pre [The last marker that was placed is valid and was passed properly to this function]
     * @return (True [if the move lastPos won the game vertically]) or
     *         (False [if the move lastPos did not win the game vertically])
     * @post [The specified Column of the board is checked for a win]
     */
    public boolean checkVerticalWin(BoardPosition lastPos, char player)
    {
        // Checks to see if the last marker placed resulted in 5 in a row vertically.
        // Returns true if it does, otherwise false
        return false;
    }



    /**
     * @param lastPos = [last position placed on the board]
     * @pre [The last marker that was placed is valid and was passed properly to this function]
     * @return (True [if the move lastPos won the game diagonally]) or
     *         (False [if the move lastPos did not win the game diagonally])
     * @post [The specified diagonal of the board is checked for a win]
     */
    public boolean checkDiagonalWin(BoardPosition lastPos, char player) {
        // Checks to see if the last marker placed resulted in 5 in a row diagonally.
        // Returns true if it does, otherwise false
        return false;
    }


    /**
     * @param pos = [position in the GameBoard]
     * @return [the char at the specified board position or a blank space
     * if there is no marker at that position]
     */

    public char whatsAtPos(BoardPosition pos) {
        // Returns what is in the GameBoard at position pos
        // If no marker is there it returns a blank space char ' '
        return ' ';
    }

    /**
     *
     * @param pos = [position in the GameBoard]
     * @param player [the character that identifies the player (either "X" or "O")]
     * @return [true if the character in that position matches player and false otherwise]
     */
    public boolean isPlayerAtPos (BoardPosition pos, char player) {
        // Returns true if the player is at pos, otherwise returns false
        return false;
    }


    /**
     * @pre [The game board is empty at the start of the game] and [The game board has
     *      valid positions on it if the game has started or finished]
     * @return [The String array of the Row and Column positions making the game board]
     *         [printed during the game]
     * @post [Formats a full game board string to print out in GameScreen]
     */
    @Override
    public String toString() {
        return "eventually this will be a formatted game board.";
    }


}