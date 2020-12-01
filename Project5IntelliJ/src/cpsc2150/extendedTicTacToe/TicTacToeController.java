package cpsc2150.extendedTicTacToe;

/**
 * The TicTacToe controller class will handle communication between our TicTacToeView and our Model (IGameBoard and BoardPosition)
 * <p>
 * This is where you will write code
 * <p>
 * You will need to include your BoardPosition class, the IGameBoard interface
 * and the implementations from previous homeworks
 * If your code was correct you will not need to make any changes to your IGameBoard classes
 */
public class TicTacToeController {

    //our current game that is being played
    private IGameBoard curGame;

    //The screen that provides our view
    private TicTacToeView screen;

    public static final int MAX_PLAYERS = 10;

    public static int playerCount = 0;
    public static char[] playerArray = {'X', 'O', 'T', 'K', 'L', 'E', 'A', 'S', 'W', 'H'};
    public static int playerTotal;
    private boolean gameEnd = false;

    /**
     * @param model the board implementation
     * @param view  the screen that is shown
     * @param np    The number of players for the game
     *
     * @post the controller will respond to actions on the view using the model.
     */
    public TicTacToeController(IGameBoard model, TicTacToeView view, int np) {
        this.curGame = model;
        this.screen = view;
        playerTotal = np; //number of players
        // Some code is needed here.
    }

    /**
     * @param row the row of the activated button
     * @param col the column of the activated button
     *
     * @pre row and col are in the bounds of the game represented by the view
     * @post The button pressed will show the right token and check if a player has won.
     */
    public void processButtonClick(int row, int col) {
        // Your code goes here.
        if (gameEnd) {
            gameEnd = false;
            playerCount = 0;
            newGame();
        }
        BoardPosition newPos = new BoardPosition(row, col);
        screen.setMessage("It's player " + playerArray[(playerCount + 1) % playerTotal] + "'s turn...");
        if (!curGame.checkSpace(newPos)) {
            screen.setMessage("Position is out of bounds or already taken. Try again.");
        }
        else {
            curGame.placeMarker(newPos, playerArray[playerCount]);
            screen.setMarker(row, col, playerArray[playerCount]);
            if (curGame.checkForWinner(newPos)) {
                screen.setMessage("Congrats player " + curGame.whatsAtPos(newPos) + "! You have won! Click any button to play again!\n");
                playerCount = 0;
                gameEnd = true;
            }
            else {
                if (curGame.checkForDraw(newPos)) {
                    screen.setMessage("It's a draw! Click any button to play again!");
                    playerCount = 0;
                    gameEnd = true;
                }
            }
            playerCount = (playerCount + 1) % playerTotal;

        }
    }

    private void newGame() {
        // You do not need to make any changes to this code.
        screen.dispose();
        GameSetupScreen screen = new GameSetupScreen();
        GameSetupController controller = new GameSetupController(screen);
        screen.registerObserver(controller);
    }
}