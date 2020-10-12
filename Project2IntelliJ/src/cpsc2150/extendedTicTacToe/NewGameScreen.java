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
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NewGameScreen {
    public static final int rows = 8;
    public static final int columns = 8;
    public static final int winNum = 5;


    public static void main(String[] args) {


        System.out.println("Welcome to Extended Tic Tac Toe!\n");
        Scanner scan = new Scanner(System.in);
        boolean playAgain = true;
        IGameBoard mainBoard;
        mainBoard = new GameBoard(rows, columns, winNum);
        char[] player = {'X', 'O'};

        while (playAgain) {
            BoardPosition mainPos;
            for (int i = 0; i < 2; i++) {
                System.out.println(mainBoard);
                System.out.println("Player " + player[i] + " please enter your ROW:");
                String mainRow = scan.nextLine();
                System.out.println("Player " + player[i] + " please enter your COLUMN:");
                String mainCol = scan.nextLine();
                mainPos = new BoardPosition(Integer.parseInt(mainRow),
                        Integer.parseInt(mainCol));
                mainPos = move(scan, mainPos, player[i], mainBoard);
                mainBoard.placeMarker(mainPos, player[i]);
                if (mainBoard.checkForWinner(mainPos)) {
                    System.out.println(mainBoard);
                    System.out.println("Congratulations Player " + player[i] + "! You won!\n");

                    //Ask if the user wants to play again
                    System.out.println("Would you like to play again? (Y for yes, or N or n for no)\n");
                    String in = scan.nextLine();
                    if (in.equals("N") || in.equals("n")) {
                        playAgain = false;
                    }
                    else if (in.equals("Y") || (in.equals("y"))) {
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
