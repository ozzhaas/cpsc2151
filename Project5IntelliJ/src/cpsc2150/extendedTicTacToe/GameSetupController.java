package cpsc2150.extendedTicTacToe;

import java.time.chrono.MinguoChronology;

import static cpsc2150.extendedTicTacToe.IGameBoard.*;

/**
 * The GameSetupController class will handle communication between our GameSetupScreen
 * and start a new game when all the required fields to build an IGameBoard is met.
 * <p>
 * You do not need to make any changes to this code.
 */
public class GameSetupController {

    private GameSetupScreen view;

    public GameSetupController(GameSetupScreen v) {
        view = v;
    }

    public void processButtonClick(int rows, int cols, int players, int numWin) {
        String errorMsg = "";
        if (rows < MIN_LEN || rows > MAX_LEN) {
            errorMsg += "Rows must be between " + MIN_LEN + " and " + MAX_LEN;
        }

        if (cols < MIN_LEN || cols > MAX_LEN) {
            errorMsg += "Columns must be between " + MIN_LEN + " and " + MAX_LEN;
        }

        if (numWin > rows) {
            errorMsg += "Can't have more to win than the number of rows";
        }
        if (numWin > rows) {
            errorMsg += "Can't have more to win than the number of Columns";
        }

        if (numWin < MIN_LEN) {
            errorMsg += "Number to win must be at least " + MIN_LEN;
        }

        if (!errorMsg.equals("")) {
            view.displayError(errorMsg);
        } else {
            view.closeScreen();
            IGameBoard model;
            if (rows * cols <= MAX_MEM) {
                model = new GameBoard(rows, cols, numWin);
            } else {
                model = new GameBoardMem(rows, cols, numWin);
            }
            char[] playerArray = {'X', 'O', 'T', 'K', 'L', 'E', 'A', 'S', 'W', 'H'};
            TicTacToeView tview = new TicTacToeView(rows, cols, playerArray);
            TicTacToeController tcontroller = new TicTacToeController(model, tview, players);

            tview.registerObserver(tcontroller);
        }
    }
}