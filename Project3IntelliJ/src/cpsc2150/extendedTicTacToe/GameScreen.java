package cpsc2150.extendedTicTacToe;

import java.lang.instrument.ClassDefinition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * @invariant [bounds must be valid], 0 <= Row <= 7, 0 <= Column <= 7 [in (<row>, <column)]
 * @invariant [only two players can play at a time]
 * @invariant [0, 0 is the top left corner]
 */


public class GameScreen {


    public static void main(String[] args) {
        int numOfPlayers = 0;
        System.out.println("Welcome to Extended Tic Tac Toe!\n");
        Scanner scan = new Scanner(System.in);
        List<Character> playerArray = new ArrayList<>();
        boolean playAgain = true;

        System.out.println("How many players?");
        String numPlay = scan.nextLine();
        numOfPlayers = Integer.parseInt(numPlay);



    /****************************************************************************************
     * Invalid if number of players in less than 2 or greater than 10
     ***************************************************************************************/
        while (numOfPlayers > 10 || numOfPlayers < 2) {
            if (numOfPlayers < 2) {
                System.out.println("Must be at least 2 players. Try again.\n");
            }
            else {
                System.out.println("Must be 10 players or fewer. Try again.\n");
            }
            System.out.println("How many players?\n");
            numPlay = scan.nextLine();
            numOfPlayers = Integer.parseInt(numPlay);
        }

    /****************************************************************************************
     * Get the players character and be sure it is not already taken
     ***************************************************************************************/
        for (int p = 1; p <= numOfPlayers; p++) {
            System.out.println("Enter the character to represent player " + p + "\n");
            String playersChar = scan.nextLine();
            while (playerArray.contains(playersChar.charAt(0))){
                System.out.println(playersChar + " is already taken by another player. Choose a different character.\n");
                System.out.println("Enter the character to represent player " + p + "\n");
                playersChar = scan.nextLine();
            }
            playerArray.add(p-1, playersChar.charAt(0));
        }
    /****************************************************************************************
     * Get the number of rows and be sure it is between 3 and 100
     ***************************************************************************************/
        System.out.println("How many rows in your game board?\n");
        String rowsString = scan.nextLine();
        int rows = Integer.parseInt(rowsString);
        while (rows < 3 || rows > 100) {
            System.out.println("Rows must be between 3 and 100. Try again.\n");
            System.out.println("How many rows in your game board?\n");
            rowsString = scan.nextLine();
            rows = Integer.parseInt(rowsString);
        }


    /****************************************************************************************
     * Get the number of columns and be sure it is between 3 and 100
     ***************************************************************************************/
        System.out.println("How many columns in your game board?\n");
        String columnsString = scan.nextLine();
        int columns = Integer.parseInt(columnsString);
        while (columns < 3 || columns > 100) {
            System.out.println("Columns must be between 3 and 100. Try again.\n");
            System.out.println("How many columns in your game board?\n");
            columnsString = scan.nextLine();
            columns = Integer.parseInt(columnsString);
        }


    /****************************************************************************************
     * Get the number of characters in a row to win the game and be sure it is between 3 and
     * the number of rows/columns whichever is larger
     ***************************************************************************************/
        System.out.println("How many characters in a row to win the game?\n");
        String winNumString = scan.nextLine();
        int winNum = Integer.parseInt(winNumString);
        if (rows > columns) {
            while (winNum <= rows) {
                System.out.println("The number in a row to win must be less than the number of rows.\n");
                System.out.println("How many characters in a row to win the game?\n");
                winNumString = scan.nextLine();
                winNum = Integer.parseInt(winNumString);
            }
        }
        else if (columns > rows) {
            while (winNum <= columns) {
                System.out.println("The number in a row to win must be less than the number of columns.\n");
                System.out.println("How many characters in a row to win the game?\n");
                winNumString = scan.nextLine();
                winNum = Integer.parseInt(winNumString);
            }
        }

    /****************************************************************************************
     * Ask the user what kind of implementation they would like Fast or Memory Efficient
     * and then create the game board based on their choice.
     ***************************************************************************************/
        System.out.println("Would you like a Fast Game (F/f) or a Memory Efficient Game (M/m)?\n");
        String gameType = scan.nextLine();
        gameType = gameType.toUpperCase();
        boolean gameInvalid = true;
        while (gameInvalid) {
            if ((gameType.equals("F")) || (gameType.equals("M"))) {
                gameInvalid = false;
            }
            else {
                System.out.println("Please enter F or f for Fast Game, or M or m for Memory Efficient Game.\n");
                gameType = scan.nextLine();
                gameType = gameType.toUpperCase();
            }
        }

        IGameBoard mainBoard;
        if (gameType.equals("F")) {
            mainBoard = new GameBoard(rows, columns, winNum);
        }
        else {
            mainBoard = new GameBoardMem(rows, columns, winNum);
        }

        while (playAgain) {

            BoardPosition mainPos;
            for (int i = 0; i < numOfPlayers; i++) {
                System.out.println(mainBoard);
                System.out.println("Player " + playerArray.get(i) + " please enter your ROW:");
                String mainRow = scan.nextLine();
                System.out.println("Player " + playerArray.get(i) + " please enter your COLUMN:");
                String mainCol = scan.nextLine();
                mainPos = new BoardPosition(Integer.parseInt(mainRow),
                        Integer.parseInt(mainCol));
                mainPos = move(scan, mainPos, playerArray.get(i), mainBoard);
                mainBoard.placeMarker(mainPos, playerArray.get(i));
                if (mainBoard.checkForWinner(mainPos)) {
                    System.out.println(mainBoard);
                    System.out.println("Congratulations Player " + playerArray.get(i) + "! You won!\n");

                    //Ask if the user wants to play again
                    System.out.println("Would you like to play again? (Y for yes, or N or n for no)\n");
                    String in = scan.nextLine();
                    if (in.equals("N") || in.equals("n")) {
                        playAgain = false;
                    }
                    else if (in.equals("Y") || (in.equals("y"))) {
                        playerArray.clear();
                        System.out.println("How many players?");
                        numPlay = scan.nextLine();
                        numOfPlayers = Integer.parseInt(numPlay);

                    /****************************************************************************************
                     * Invalid if number of players in less than 2 or greater than 10
                     ***************************************************************************************/
                        while (numOfPlayers > 10 || numOfPlayers < 2) {
                            if (numOfPlayers < 2) {
                                System.out.println("Must be at least 2 players. Try again.\n");
                            }
                            else {
                                System.out.println("Must be 10 players or fewer. Try again.\n");
                            }
                            System.out.println("How many players?\n");
                            numPlay = scan.nextLine();
                            numOfPlayers = Integer.parseInt(numPlay);
                        }

                    /****************************************************************************************
                     * Get the players character and be sure it is not already taken
                     ***************************************************************************************/
                        for (int p = 1; p <= numOfPlayers; p++) {
                            System.out.println("Enter the character to represent player " + p + "\n");
                            String playersChar = scan.nextLine();
                            while (playerArray.contains(playersChar.charAt(0))){
                                System.out.println(playersChar + " is already taken by another player. Choose a different character.\n");
                                System.out.println("Enter the character to represent player " + p + "\n");
                                playersChar = scan.nextLine();
                            }
                            playerArray.add(p-1, playersChar.charAt(0));
                        }
                    /****************************************************************************************
                     * Get the number of rows and be sure it is between 3 and 100
                     ***************************************************************************************/
                        System.out.println("How many rows in your game board?\n");
                        rowsString = scan.nextLine();
                        rows = Integer.parseInt(rowsString);
                        while (rows < 3 || rows > 100) {
                            System.out.println("Rows must be between 3 and 100. Try again.\n");
                            System.out.println("How many rows in your game board?\n");
                            rowsString = scan.nextLine();
                            rows = Integer.parseInt(rowsString);
                        }


                    /****************************************************************************************
                     * Get the number of columns and be sure it is between 3 and 100
                     ***************************************************************************************/
                        System.out.println("How many columns in your game board?\n");
                        columnsString = scan.nextLine();
                        columns = Integer.parseInt(columnsString);
                        while (columns < 3 || columns > 100) {
                            System.out.println("Columns must be between 3 and 100. Try again.\n");
                            System.out.println("How many columns in your game board?\n");
                            columnsString = scan.nextLine();
                            columns = Integer.parseInt(columnsString);
                        }


                    /****************************************************************************************
                     * Get the number of characters in a row to win the game and be sure it is between 3 and
                     * the number of rows/columns whichever is larger
                     ***************************************************************************************/
                        System.out.println("How many characters in a row to win the game?\n");
                        winNumString = scan.nextLine();
                        winNum = Integer.parseInt(winNumString);
                        if (rows > columns) {
                            while (winNum <= rows) {
                                System.out.println("The number in a row to win must be less than the number of rows.\n");
                                System.out.println("How many characters in a row to win the game?\n");
                                winNumString = scan.nextLine();
                                winNum = Integer.parseInt(winNumString);
                            }
                        }
                        else if (columns > rows) {
                            while (winNum <= columns) {
                                System.out.println("The number in a row to win must be less than the number of columns.\n");
                                System.out.println("How many characters in a row to win the game?\n");
                                winNumString = scan.nextLine();
                                winNum = Integer.parseInt(winNumString);
                            }
                        }

                    /****************************************************************************************
                     * Ask the user what kind of implementation they would like Fast or Memory Efficient
                     * and then create the game board based on their choice.
                     ***************************************************************************************/
                        System.out.println("Would you like a Fast Game (F/f) or a Memory Efficient Game (M/m)?\n");
                        gameType = scan.nextLine();
                        gameType = gameType.toUpperCase();
                        gameInvalid = true;
                        while (gameInvalid) {
                            if ((gameType.equals("F")) || (gameType.equals("M"))) {
                                gameInvalid = false;
                            }
                            else {
                                System.out.println("Please enter F or f for Fast Game, or M or m for Memory Efficient Game.\n");
                                gameType = scan.nextLine();
                                gameType = gameType.toUpperCase();
                            }
                        }
                        if (gameType.equals("F")) {
                            mainBoard = new GameBoard(rows, columns, winNum);
                        }
                        else {
                            mainBoard = new GameBoardMem(rows, columns, winNum);
                        }
                        i = 0;
                        playAgain = true;
                    }
                    else {
                        System.out.println("That is not a valid choice please try again\n");
                        System.out.println("Would you like to play again? (Y for yes, or N or n for no)\n");
                        in = scan.nextLine();
                    }
                }
                else if (mainBoard.checkForDraw(mainPos)) {
                    System.out.println(mainBoard);
                    System.out.println("It's a draw!\n");
                }
            }
        }
    }


    public static BoardPosition move (Scanner scan, BoardPosition playersMove, char player, IGameBoard moveBoard){

        while (!moveBoard.checkSpace(playersMove)) {
            System.out.println("That space is unavailable or out of bounds. Please pick again.\n");
            System.out.println(moveBoard);
            System.out.println("\nPlayer " + player + " , Please enter your ROW:");
            String row = scan.nextLine();
            System.out.println("\nPlayer " + player + " , Please enter your ROW:");
            String column = scan.nextLine();
            BoardPosition pos = new BoardPosition(Integer.parseInt(String.valueOf(row)),
                    Integer.parseInt(String.valueOf(column)));
            while (!moveBoard.checkSpace(pos)) {
                System.out.println("That space is unavailable or out of bounds. Please pick again.\n");
                System.out.println(moveBoard);
                System.out.println("\nPlayer " + player + " , Please enter your ROW:");
                row = scan.nextLine();
                System.out.println("\nPlayer " + player + " , Please enter your ROW:");
                column = scan.nextLine();
                pos = new BoardPosition(Integer.parseInt(row),
                        Integer.parseInt(column));
            }
            return pos;

        }
        return playersMove;
    }
}

