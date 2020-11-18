package cpsc2150.extendedTicTacToe;

public interface IGameBoardFactory {
    IGameBoard makeBoard(int row, int col, int win);
}

class MemFactory implements IGameBoardFactory {
    public IGameBoard makeBoard(int row, int col, int win) {
        return new GameBoardMem(row, col, win);
    }
}

class FastFactory implements IGameBoardFactory {
    public IGameBoard makeBoard(int row, int col, int win) {
        return new GameBoard(row, col, win);
    }
}
