/*
  Kellen Haas
  CPSC 2150
  Project 1
  9/20/20
 */



package cpsc2150.extendedTicTacToe;


/**
 * @invariant [bounds must be valid], 0 <= Row <= 7, 0 <= Column <= 7 [in (<row>, <column)]
 * @invariant [only two players can play at a time]
 * @invariant [0, 0 is the top left corner]
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameScreen {

    /**
     * @pre [Bounds checking for the users input to
     * make sure it is a valid position on the board]
     * @pre Input: 1st get Row then Col
     * @pre Only enter integers between 0 and 7 are valid
     * @param args
     * @post [Checks if either player has won -> if yes prints winner
     * If not checks if all of the positions are taken -> if yes prints draw
     * -> If not, prints the current game board and prompts next player for their turn]
     * @return integer value of 0
     */

    public static void main(String[] args) {

        System.out.println("Welcome to Extended Tic Tac Toe!\n");
        Scanner scan = new Scanner(System.in);
        List<Character> playerArray = new ArrayList<>();
        boolean playAgain = true;


        System.out.println("How many players?\n");
        String numP = scan.nextLine();
        int numOfPlayers = Integer.parseInt(numP);
        while (numOfPlayers > 10 || numOfPlayers < 2) {
            System.out.println("Must be between 2 and 10 players. Try again.\n");
            System.out.println("How many players?\n");
            numP = scan.nextLine();
            numOfPlayers = Integer.parseInt(numP);
        }

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


        System.out.println("How many rows in your game board?\n");
        String rowsString = scan.nextLine();
        int rows = Integer.parseInt(rowsString);
        while (rows < 3 || rows > 100) {
            System.out.println("Rows must be between 3 and 100. Try again.\n");
            System.out.println("How many rows in your game board?\n");
            rowsString = scan.nextLine();
            rows = Integer.parseInt(rowsString);
        }

        System.out.println("How many columns in your game board?\n");
        String columnsString = scan.nextLine();
        int columns = Integer.parseInt(columnsString);
        while (columns < 3 || columns > 100) {
            System.out.println("Columns must be between 3 and 100. Try again.\n");
            System.out.println("How many columns in your game board?\n");
            columnsString = scan.nextLine();
            columns = Integer.parseInt(columnsString);
        }

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


            /***********************************************************************************
             * Loop through the first game as long as playAgain is true
             ************************************************************************************/
            //Loop for if checkSpace is true and the space is valid
            while (playAgain) {

                /***********************************************************************************
                 * Create the BoardPosition object and initialize it with a row and column of one
                 ***********************************************************************************/
                BoardPosition mainPos;


                for (int i = 0; i < numOfPlayers; i++) {
                    System.out.println(mainBoard);
                    System.out.println("\nPlayer " + playerArray.get(i) + ", please enter your ROW:");
                    String mainRow = scan.nextLine();
                    System.out.println("\nPlayer " + playerArray.get(i) + ", please enter your COLUMN:");
                    String mainColumn = scan.nextLine();
                    mainPos = new BoardPosition(Integer.parseInt(String.valueOf(mainRow)),
                            Integer.parseInt(String.valueOf(mainColumn)));
                    //Check the position
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
                            break;
                        }


                        //          There was a winner and now the user has chosen to play another game             //
                        else if (in.equals("y") || in.equals("Y")) {
                            playAgain = true;
                            playerArray.clear();
                            System.out.println("How many players?\n");
                            numP = scan.nextLine();
                            numOfPlayers = Integer.parseInt(numP);
                            while (numOfPlayers > 10 || numOfPlayers < 2) {
                                System.out.println("Must be between 2 and 10 players. Try again.\n");
                                System.out.println("How many players?\n");
                                numP = scan.nextLine();
                                numOfPlayers = Integer.parseInt(numP);
                            }

                            for (int p = 1; p <= numOfPlayers; p++) {
                                System.out.println("Enter the character to represent player " + p + "\n");
                                String playersChar = scan.nextLine();
                                while (playerArray.contains(playersChar.charAt(0))) {
                                    System.out.println(playersChar + " is already taken by another player. Choose a different character.\n");
                                    System.out.println("Enter the character to represent player " + p + "\n");
                                    playersChar = scan.nextLine();
                                }
                                playerArray.add(playersChar.charAt(0));
                            }


                            System.out.println("How many rows in your game board?\n");
                            rowsString = scan.nextLine();
                            rows = Integer.parseInt(rowsString);
                            while (rows < 3 || rows > 100) {
                                System.out.println("Rows must be between 3 and 100. Try again.\n");
                                System.out.println("How many rows in your game board?\n");
                                rowsString = scan.nextLine();
                                rows = Integer.parseInt(rowsString);
                            }

                            System.out.println("How many columns in your game board?\n");
                            columnsString = scan.nextLine();
                            columns = Integer.parseInt(columnsString);
                            while (columns < 3 || columns > 100) {
                                System.out.println("Columns must be between 3 and 100. Try again.\n");
                                System.out.println("How many columns in your game board?\n");
                                columnsString = scan.nextLine();
                                columns = Integer.parseInt(columnsString);
                            }

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
                            } else if (columns > rows) {
                                while (winNum <= columns) {
                                    System.out.println("The number in a row to win must be less than the number of columns.\n");
                                    System.out.println("How many characters in a row to win the game?\n");
                                    winNumString = scan.nextLine();
                                    winNum = Integer.parseInt(winNumString);
                                }
                            }


                            System.out.println("Would you like a Fast Game (F/f) or a Memory Efficient Game (M/m)?\n");
                            gameType = scan.nextLine();
                            gameType = gameType.toUpperCase();
                            gameInvalid = true;
                            while (gameInvalid) {
                                if ((gameType.equals("F")) || (gameType.equals("M"))) {
                                    gameInvalid = false;
                                } else {
                                    System.out.println("Please enter F or f for Fast Game, or M or m for Memory Efficient Game.\n");
                                    gameType = scan.nextLine();
                                    gameType = gameType.toUpperCase();
                                }
                            }

                            for (int k = 0; k < numOfPlayers; k++) {
                                mainBoard = new GameBoard(mainBoard.getNumRows(), mainBoard.getNumColumns(), mainBoard.getNumToWin());
                                System.out.println(mainBoard);
                                System.out.println("\nPlayer " + playerArray.get(k) + ", please enter your ROW:");
                                mainRow = scan.nextLine();
                                System.out.println("\nPlayer " + playerArray.get(k) + ", please enter your COLUMN:");
                                mainColumn = scan.nextLine();
                                mainPos = new BoardPosition(Integer.parseInt(String.valueOf(mainRow)),
                                        Integer.parseInt(String.valueOf(mainColumn)));
                                mainPos = move(scan, mainPos, playerArray.get(i), mainBoard);
                                mainBoard.placeMarker(mainPos, playerArray.get(i));
                            }
                        } else {
                            System.out.println("That is not a valid choice please try again (Y or y for Yes, or N or n for no)\n");
                            System.out.println("Would you like to play again? (Y for yes, or N or n for no)\n");
                            in = scan.nextLine();
                        }
                    }
                }
            }
        }
        else {
            mainBoard = new GameBoard(rows, columns, winNum);


            /***********************************************************************************
             * Loop through the first game as long as playAgain is true
             ************************************************************************************/
            //Loop for if checkSpace is true and the space is valid
            while (playAgain) {

                /***********************************************************************************
                 * Create the BoardPosition object and initialize it with a row and column of one
                 ***********************************************************************************/
                BoardPosition mainPos;


                for (int i = 0; i < numOfPlayers; i++) {
                    System.out.println(mainBoard);
                    System.out.println("\nPlayer " + playerArray.get(i) + ", please enter your ROW:");
                    String mainRow = scan.nextLine();
                    System.out.println("\nPlayer " + playerArray.get(i) + ", please enter your COLUMN:");
                    String mainColumn = scan.nextLine();
                    mainPos = new BoardPosition(Integer.parseInt(String.valueOf(mainRow)),
                            Integer.parseInt(String.valueOf(mainColumn)));
                    //Check the position
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
                            break;
                        }


                        //          There was a winner and now the user has chosen to play another game             //
                        else if (in.equals("y") || in.equals("Y")) {
                            playAgain = true;
                            playerArray.clear();
                            System.out.println("How many players?\n");
                            numP = scan.nextLine();
                            numOfPlayers = Integer.parseInt(numP);
                            while (numOfPlayers > 10 || numOfPlayers < 2) {
                                System.out.println("Must be between 2 and 10 players. Try again.\n");
                                System.out.println("How many players?\n");
                                numP = scan.nextLine();
                                numOfPlayers = Integer.parseInt(numP);
                            }

                            for (int p = 1; p <= numOfPlayers; p++) {
                                System.out.println("Enter the character to represent player " + p + "\n");
                                String playersChar = scan.nextLine();
                                while (playerArray.contains(playersChar.charAt(0))) {
                                    System.out.println(playersChar + " is already taken by another player. Choose a different character.\n");
                                    System.out.println("Enter the character to represent player " + p + "\n");
                                    playersChar = scan.nextLine();
                                }
                                playerArray.add(playersChar.charAt(0));
                            }


                            System.out.println("How many rows in your game board?\n");
                            rowsString = scan.nextLine();
                            rows = Integer.parseInt(rowsString);
                            while (rows < 3 || rows > 100) {
                                System.out.println("Rows must be between 3 and 100. Try again.\n");
                                System.out.println("How many rows in your game board?\n");
                                rowsString = scan.nextLine();
                                rows = Integer.parseInt(rowsString);
                            }

                            System.out.println("How many columns in your game board?\n");
                            columnsString = scan.nextLine();
                            columns = Integer.parseInt(columnsString);
                            while (columns < 3 || columns > 100) {
                                System.out.println("Columns must be between 3 and 100. Try again.\n");
                                System.out.println("How many columns in your game board?\n");
                                columnsString = scan.nextLine();
                                columns = Integer.parseInt(columnsString);
                            }

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
                            } else if (columns > rows) {
                                while (winNum <= columns) {
                                    System.out.println("The number in a row to win must be less than the number of columns.\n");
                                    System.out.println("How many characters in a row to win the game?\n");
                                    winNumString = scan.nextLine();
                                    winNum = Integer.parseInt(winNumString);
                                }
                            }


                            System.out.println("Would you like a Fast Game (F/f) or a Memory Efficient Game (M/m)?\n");
                            gameType = scan.nextLine();
                            gameType = gameType.toUpperCase();
                            gameInvalid = true;
                            while (gameInvalid) {
                                if ((gameType.equals("F")) || (gameType.equals("M"))) {
                                    gameInvalid = false;
                                } else {
                                    System.out.println("Please enter F or f for Fast Game, or M or m for Memory Efficient Game.\n");
                                    gameType = scan.nextLine();
                                    gameType = gameType.toUpperCase();
                                }
                            }

                            for (int k = 0; k < numOfPlayers; k++) {
                                mainBoard = new GameBoard(mainBoard.getNumRows(), mainBoard.getNumColumns(), mainBoard.getNumToWin());
                                System.out.println(mainBoard);
                                System.out.println("\nPlayer " + playerArray.get(k) + ", please enter your ROW:");
                                mainRow = scan.nextLine();
                                System.out.println("\nPlayer " + playerArray.get(k) + ", please enter your COLUMN:");
                                mainColumn = scan.nextLine();
                                mainPos = new BoardPosition(Integer.parseInt(String.valueOf(mainRow)),
                                        Integer.parseInt(String.valueOf(mainColumn)));
                                mainPos = move(scan, mainPos, playerArray.get(i), mainBoard);
                                mainBoard.placeMarker(mainPos, playerArray.get(i));
                            }
                        }
                        else {
                            System.out.println("That is not a valid choice please try again (Y or y for Yes, or N or n for no)\n");
                            System.out.println("Would you like to play again? (Y for yes, or N or n for no)\n");
                            in = scan.nextLine();
                        }
                    }
                }
            }
        }
    }


    public static BoardPosition move (Scanner scan, BoardPosition playersMove,char player, IGameBoard moveBoard){
        while (!moveBoard.checkSpace(playersMove) || moveBoard.whatsAtPos(playersMove) != ' ') {
            System.out.println("That space is unavailable or out of bounds. Please pick again.\n");
            System.out.println(moveBoard);
            System.out.println("\nPlayer " + player + " , Please enter your ROW:");
            String row = scan.nextLine();
            System.out.println("\nPlayer " + player + " , Please enter your ROW:");
            String column = scan.nextLine();
            BoardPosition pos = new BoardPosition(Integer.parseInt(String.valueOf(row)),
                    Integer.parseInt(String.valueOf(column)));
            if (!moveBoard.checkSpace(pos)) {
                System.out.println("That space is unavailable or out of bounds. Please pick again.\n");
                System.out.println(moveBoard);
                System.out.println("\nPlayer " + player + " , Please enter your ROW:");
                row = scan.nextLine();
                System.out.println("\nPlayer " + player + " , Please enter your ROW:");
                column = scan.nextLine();
                pos = new BoardPosition(Integer.parseInt(String.valueOf(row)),
                        Integer.parseInt(String.valueOf(column)));
            }
            else {
                return pos;
            }
        }
        return playersMove;
    }
}
