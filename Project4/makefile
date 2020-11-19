default: cpsc2150/extendedTicTacToe/GameScreen.java cpsc2150/extendedTicTacToe/GameBoard.java cpsc2150/extendedTicTacToe/GameBoardMem.java /extendedTicTacToe/IGameBoard.java cpsc2150/extendedTicTacToe/BoardPosition.java cpsc2150/extendedTicTacToe/AbsGameBoard.java
	javac cpsc2150/extendedTicTacToe/GameScreen.java cpsc2150/extendedTicTacToe/GameBoard.java cpsc2150/extendedTicTacToe/GameBoardMem.java cpsc2150/extendedTicTacToe/IGameBoard.java cpsc2150/extendedTicTacToe/BoardPosition.java cpsc2150/extendedTicTacToe/AbsGameBoard.java

run: cpsc2150/extendedTicTacToe/GameScreen.java cpsc2150/extendedTicTacToe/GameBoard.java cpsc2150/extendedTicTacToe/GameBoardMem.java cpsc2150/extendedTicTacToe/IGameBoard.java cpsc2150/extendedTicTacToe/BoardPosition.java cpsc2150/extendedTicTacToe/AbsGameBoard.java
	java cpsc2150/extendedTicTacToe/GameScreen

test: cpsc2150/extendedTicTacToe/TestGameBoard.java cpsc2150/extendedTicTacToe/TestGameBoardMem.java cpsc2150/extendedTicTacToe/GameScreen.java cpsc2150/extendedTicTacToe/GameBoard.java cpsc2150/extendedTicTacToe/GameBoardMem.java cpsc2150/extendedTicTacToe/IGameBoard.java cpsc2150/extendedTicTacToe/BoardPosition.java cpsc2150/extendedTicTacToe/AbsGameBoard.java
	javac -cp .:/usr/share/java/junit4.jar cpsc2150/extendedTicTacToe/TestGameBoard.java cpsc2150/extendedTicTacToe/TestGameBoardMem.java cpsc2150/extendedTicTacToe/GameScreen.java cpsc2150/extendedTicTacToe/GameBoard.java cpsc2150/extendedTicTacToe/GameBoardMem.java cpsc2150/extendedTicTacToe/IGameBoard.java cpsc2150/extendedTicTacToe/BoardPosition.java cpsc2150/extendedTicTacToe/AbsGameBoard.java

testGB: cpsc2150/extendedTicTacToe/TestGameBoard.java cpsc2150/extendedTicTacToe/GameScreen.java cpsc2150/extendedTicTacToe/GameBoard.java cpsc2150/extendedTicTacToe/GameBoardMem.java cpsc2150/extendedTicTacToe/IGameBoard.java cpsc2150/extendedTicTacToe/BoardPosition.java cpsc2150/extendedTicTacToe/AbsGameBoard.java
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150/extendedTicTacToe/TestGameBoard

testGBMem: cpsc2150/extendedTicTacToe/TestGameBoardMem.java cpsc2150/extendedTicTacToe/GameScreen.java cpsc2150/extendedTicTacToe/GameBoard.java cpsc2150/extendedTicTacToe/GameBoardMem.java cpsc2150/extendedTicTacToe/IGameBoard.java cpsc2150/extendedTicTacToe/BoardPosition.java cpsc2150/extendedTicTacToe/AbsGameBoard.java
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150/extendedTicTacToe/TestGameBoardMem

clean:
	rm cpsc2150/extendedTicTacToe/*.class
