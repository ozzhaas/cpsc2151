package cpsc2150.extendedTicTacToe;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestGameBoard {

    private IGameBoard GameBoardFactory(int row, int col, int win) {
        return new GameBoard(row, col, win);
    }

    private String arrayToString(char arr[][]) {
        int r = 5;
        int c = 5;
        int w = 3;
        String gameBoardStr = " ";
        //Label the column indexes
        for (int i = 0; i < c; i++) {
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
        for (int i = 0; i < r; i++) {
            if (i < 10) {
                gameBoardStr = gameBoardStr + " " + i + "  " + '|';
            }
            else {
                gameBoardStr = gameBoardStr + " " + i + " " + '|';
            }
            for (int j = 0; j < c; j++) {
                if (j >= 10) {
                    gameBoardStr = gameBoardStr + " " + arr[i][j] + "  " + '|';
                }
                else {
                    gameBoardStr = gameBoardStr + " " + arr[i][j] + " " + '|';
                }
            }
            gameBoardStr = gameBoardStr + "\n";
        }
        return gameBoardStr;
    }


    @Test
    public void check_toString_and_PlaceMarker_Output() {
        int r = 5;
        int c = 5;
        int w = 3;
        char arr[][] = new char[r][c];

        IGameBoard gb = GameBoardFactory(r, c, w);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                gb.placeMarker(new BoardPosition(i, j), 'O');
                arr[i][j] = 'O';
            }
        }
        String lastString = arrayToString(arr);
        assertEquals(gb.toString(), lastString);
    }

    //Test the constructor
    @Test
    public void TestGameBoard_Minimums() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        assertEquals(gb.getNumRows(), 3);
        assertEquals(gb.getNumColumns(), 3);
        assertEquals(gb.getNumToWin(), 3);
    }

    @Test
    public void TestGameBoard_Maximums() {
        IGameBoard gb = GameBoardFactory(100, 100, 25);
        assertEquals(gb.getNumRows(), 100);
        assertEquals(gb.getNumColumns(), 100);
        assertEquals(gb.getNumToWin(), 25);
    }

    @Test
    public void TestGameBoard_Diff_RowsAndCols() {
        IGameBoard gb = GameBoardFactory(4, 6, 3);
        assertEquals(gb.getNumRows(), 4);
        assertEquals(gb.getNumColumns(), 6);
        assertEquals(gb.getNumToWin(), 3);
    }

    //Test placeMarker()
    @Test
    public void Test_PlaceMarker_in_Bottom_Right_Corner() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        BoardPosition testPos = new BoardPosition(2,2);
        gb.placeMarker(testPos, 'X');
        assertEquals(gb.whatsAtPos(testPos), 'X');
    }

    @Test
    public void Test_PlaceMarker_Top_Right_Corner() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        BoardPosition testPos = new BoardPosition(0, 2);
        gb.placeMarker(testPos, 'X');
        assertEquals(gb.whatsAtPos(testPos), 'X');
    }

    @Test
    public void Test_PlaceMarker_Bottom_Left_Corner() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        BoardPosition testPos = new BoardPosition(2, 0);
        gb.placeMarker(testPos, 'X');
        assertEquals(gb.whatsAtPos(testPos), 'X');
    }

    @Test
    public void Test_PlaceMarker_Top_Left_Corner() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        BoardPosition testPos = new BoardPosition(0, 0);
        gb.placeMarker(testPos, 'X');
        assertEquals(gb.whatsAtPos(testPos), 'X');
    }

    @Test
    public void Test_PlaceMarker_Last_Marker_on_Board() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        BoardPosition testPos;

        testPos = new BoardPosition(0, 0);
        gb.placeMarker(testPos, 'X');
        assertEquals(gb.whatsAtPos(testPos), 'X');
        testPos = new BoardPosition(0, 1);
        gb.placeMarker(testPos, 'O');
        assertEquals(gb.whatsAtPos(testPos), 'O');
        testPos = new BoardPosition(0, 2);
        gb.placeMarker(testPos, 'X');
        assertEquals(gb.whatsAtPos(testPos), 'X');
        testPos = new BoardPosition(1, 0);
        gb.placeMarker(testPos, 'O');
        assertEquals(gb.whatsAtPos(testPos), 'O');
        testPos = new BoardPosition(1, 2);
        gb.placeMarker(testPos, 'O');
        assertEquals(gb.whatsAtPos(testPos), 'O');
        testPos = new BoardPosition(2, 0);
        gb.placeMarker(testPos, 'X');
        assertEquals(gb.whatsAtPos(testPos), 'X');
        testPos = new BoardPosition(2, 1);
        gb.placeMarker(testPos, 'O');
        assertEquals(gb.whatsAtPos(testPos), 'O');
        testPos = new BoardPosition(2, 2);
        gb.placeMarker(testPos, 'X');
        assertEquals(gb.whatsAtPos(testPos), 'X');
        testPos = new BoardPosition(1, 1);
        gb.placeMarker(testPos, 'X');
        assertEquals(gb.whatsAtPos(testPos), 'X');
    }

    //Test whatsAtPos()
    @Test
    public void Test_whatsAtPos_Blank_Board() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        BoardPosition testPos = new BoardPosition(2, 2);
        assertEquals(gb.whatsAtPos(testPos), ' ');
    }

    @Test
    public void Test_whatsAtPos_One_Marker_Placed() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        BoardPosition testPos = new BoardPosition(0, 0);
        gb.placeMarker(testPos, 'X');
        assertEquals(gb.whatsAtPos(testPos), 'X');
    }

    @Test
    public void Test_whatsAtPos_Bottom_Right_Corner() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        BoardPosition testPos = new BoardPosition(2, 2);
        gb.placeMarker(testPos, 'X');
        assertEquals(gb.whatsAtPos(testPos), 'X');
    }

    @Test
    public void Test_whatsAtPos_Top_Right_Corner() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        BoardPosition testPos = new BoardPosition(0, 2);
        gb.placeMarker(testPos, 'O');
        assertEquals(gb.whatsAtPos(testPos), 'O');
    }

    @Test
    public void Test_whatsAtPos_Bottom_Left_Corner() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        BoardPosition testPos = new BoardPosition(2,0);
        gb.placeMarker(testPos, 'X');
        assertEquals(gb.whatsAtPos(testPos), 'X');
    }

    @Test
    public void Test_whatsAtPos_Top_Left_Corner() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        BoardPosition testPos = new BoardPosition(0, 0);
        gb.placeMarker(testPos, 'O');
        assertEquals(gb.whatsAtPos(testPos), 'O');
    }

    //Test checkSpace
    @Test
    public void Test_CheckSpace_Empty_Space() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        BoardPosition testPos = new BoardPosition(0, 0);
        assertTrue(gb.checkSpace(testPos));
    }

    @Test
    public void Test_CheckSpace_Unavailable_Space() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        BoardPosition testPos = new BoardPosition(2, 2);
        gb.placeMarker(testPos, 'X');
        assertFalse(gb.checkSpace(testPos));
    }

    @Test
    public void Test_CheckSpace_Out_of_Bounds() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        assertFalse(gb.checkSpace(new BoardPosition(3, 3)));
    }

    //Test isPlayerAtPos
    @Test
    public void Test_isPlayerAtPos_Empty_Board() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        BoardPosition testPos = new BoardPosition(1, 1);
        assertFalse(gb.isPlayerAtPos(testPos, 'X'));
    }

    @Test
    public void Test_isPlayerAtPos_with_Player_in_Pos() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        BoardPosition testPos = new BoardPosition(1, 1);
        gb.placeMarker(testPos, 'X');
        assertTrue(gb.isPlayerAtPos(testPos, 'X'));
    }

    @Test
    public void Test_isPlayerAtPos_with_Wrong_Player_in_Pos() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        gb.placeMarker(new BoardPosition(0, 0), 'A');
        gb.placeMarker(new BoardPosition(0, 1), 'B');
        BoardPosition testPos = new BoardPosition(0, 2);
        gb.placeMarker(testPos, 'C');
        assertFalse(gb.isPlayerAtPos(testPos, 'X'));
    }

    @Test
    public void Test_isPlayerAtPos_True_Row() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        gb.placeMarker(new BoardPosition(0,0), 'X');
        gb.placeMarker(new BoardPosition(0,1), 'X');
        BoardPosition testPos = new BoardPosition(0, 2);
        gb.placeMarker(testPos, 'X');
        assertTrue(gb.isPlayerAtPos(testPos, 'X'));
    }

    @Test
    public void Test_isPlayerAtPos_Middle() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        BoardPosition testPos = new BoardPosition(1, 1);
        gb.placeMarker(testPos, 'X');
        assertTrue(gb.isPlayerAtPos(testPos, 'X'));
    }

    //Test checkForDraw
    @Test
    public void Test_CheckForDraw_One_Empty_Row() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        gb.placeMarker(new BoardPosition(0,0), 'X');
        gb.placeMarker(new BoardPosition(0,1), 'O');
        gb.placeMarker(new BoardPosition(0,2), 'X');
        gb.placeMarker(new BoardPosition(2,0), 'O');
        gb.placeMarker(new BoardPosition(2,1), 'X');
        BoardPosition testPos = new BoardPosition(2, 2);
        gb.placeMarker(testPos, 'O');
        assertEquals(gb.checkForDraw(testPos), false);
    }

    @Test
    public void Test_CheckForDraw_One_Empty_Col() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        gb.placeMarker(new BoardPosition(0,0), 'X');
        gb.placeMarker(new BoardPosition(1,0), 'O');
        gb.placeMarker(new BoardPosition(2,0), 'X');
        gb.placeMarker(new BoardPosition(0,1), 'O');
        gb.placeMarker(new BoardPosition(1,1), 'X');
        BoardPosition testPos = new BoardPosition(2, 1);
        gb.placeMarker(testPos, 'O');
        assertEquals(gb.checkForDraw(testPos), false);
    }

    @Test
    public void Test_CheckForDraw_One_Empty_Space() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        gb.placeMarker(new BoardPosition(0,0), 'X');
        gb.placeMarker(new BoardPosition(0,1), 'O');
        gb.placeMarker(new BoardPosition(0,2), 'X');
        gb.placeMarker(new BoardPosition(1,0), 'O');
        gb.placeMarker(new BoardPosition(1,1), 'X');
        gb.placeMarker(new BoardPosition(1,2), 'O');
        gb.placeMarker(new BoardPosition(2,0), 'X');
        BoardPosition testPos = new BoardPosition(2, 1);
        gb.placeMarker(testPos, 'O');
        assertEquals(gb.checkForDraw(testPos), false);
    }

    @Test
    public void Test_CheckForDraw_Full_Board() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        gb.placeMarker(new BoardPosition(0,0), 'X');
        gb.placeMarker(new BoardPosition(0,1), 'O');
        gb.placeMarker(new BoardPosition(0,2), 'X');
        gb.placeMarker(new BoardPosition(1,0), 'O');
        gb.placeMarker(new BoardPosition(1,1), 'O');
        gb.placeMarker(new BoardPosition(1,2), 'X');
        gb.placeMarker(new BoardPosition(2,0), 'X');
        gb.placeMarker(new BoardPosition(2,1), 'O');
        BoardPosition testPos = new BoardPosition(2, 2);
        gb.placeMarker(testPos, 'X');
        assertEquals(gb.checkForDraw(testPos), true);
    }

    //Test Diagonal Win
    @Test
    public void Test_Diagonal_Win_Start_at_Bottom_Right() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        gb.placeMarker(new BoardPosition(0,0), 'X');
        gb.placeMarker(new BoardPosition(0,1), 'O');
        gb.placeMarker(new BoardPosition(0,2), 'X');
        gb.placeMarker(new BoardPosition(1,0), 'O');
        gb.placeMarker(new BoardPosition(1,1), 'X');
        gb.placeMarker(new BoardPosition(1,2), 'O');
        gb.placeMarker(new BoardPosition(2,0), 'X');
        gb.placeMarker(new BoardPosition(2,1), 'O');
        BoardPosition testPos = new BoardPosition(2, 2);
        gb.placeMarker(testPos, 'X');
        assertTrue(gb.checkDiagonalWin(testPos));
    }

    @Test
    public void Test_Diagonal_Win_Start_at_Top_Right() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        gb.placeMarker(new BoardPosition(0,2), 'X');
        gb.placeMarker(new BoardPosition(1,1), 'X');
        BoardPosition testPos = new BoardPosition(2, 0);
        gb.placeMarker(testPos, 'X');
        assertTrue(gb.checkDiagonalWin(testPos));
    }

    @Test
    public void Test_Diagonal_Win_Start_at_Bottom_Left() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        gb.placeMarker(new BoardPosition(2,0), 'X');
        gb.placeMarker(new BoardPosition(1,1), 'X');
        BoardPosition testPos = new BoardPosition(0, 2);
        gb.placeMarker(testPos, 'X');
        assertTrue(gb.checkDiagonalWin(testPos));
    }

    @Test
    public void Test_Diagonal_Win_Start_at_Top_Left() {
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        gb.placeMarker(new BoardPosition(0,0), 'X');
        gb.placeMarker(new BoardPosition(1,1), 'X');
        BoardPosition testPos = new BoardPosition(2, 2);
        gb.placeMarker(testPos, 'X');
        assertTrue(gb.checkDiagonalWin(testPos));
    }

    @Test
    public void Test_Diagonal_Win_Middle_of_Larger_Board() {
        IGameBoard gb = GameBoardFactory(8, 8, 5);
        gb.placeMarker(new BoardPosition(1, 2), 'X');
        gb.placeMarker(new BoardPosition(2,3), 'X');
        gb.placeMarker(new BoardPosition(3,4), 'X');
        gb.placeMarker(new BoardPosition(4,5), 'X');
        BoardPosition testPos = new BoardPosition(5, 6);
        gb.placeMarker(testPos, 'X');
        assertTrue(gb.checkDiagonalWin(testPos));
    }

    @Test
    public void Test_Diagonal_Win_Three_Out_of_Five_In_a_Row() {
        IGameBoard gb = GameBoardFactory(10, 10, 5);
        gb.placeMarker(new BoardPosition(0, 0), 'X');
        gb.placeMarker(new BoardPosition(1, 1), 'X');
        gb.placeMarker(new BoardPosition(2, 2), 'X');
        gb.placeMarker(new BoardPosition(3, 3), 'O');
        BoardPosition testPos = new BoardPosition(4, 4);
        gb.placeMarker(testPos, 'X');
        assertFalse(gb.checkDiagonalWin(testPos));
    }

    @Test
    public void Test_Diagonal_Win_Four_Out_of_Five_In_a_Row() {
        IGameBoard gb = GameBoardFactory(10, 10, 5);
        gb.placeMarker(new BoardPosition(0, 0), 'X');
        gb.placeMarker(new BoardPosition(1, 1), 'X');
        gb.placeMarker(new BoardPosition(2, 2), 'X');
        gb.placeMarker(new BoardPosition(3, 3), 'X');
        BoardPosition testPos = new BoardPosition(4, 4);
        gb.placeMarker(testPos, 'O');
        assertFalse(gb.checkDiagonalWin(testPos));
    }

    //Test Vertical Win
    @Test
    public void Test_CheckVerticalWin_Far_Left_Col_One_Short() {
        IGameBoard gb = GameBoardFactory(10, 10, 5);
        gb.placeMarker(new BoardPosition(0, 0), 'X');
        gb.placeMarker(new BoardPosition(1, 0), 'X');
        gb.placeMarker(new BoardPosition(2, 0), 'X');
        gb.placeMarker(new BoardPosition(3, 0), 'X');
        BoardPosition testPos = new BoardPosition(4, 0);
        gb.placeMarker(testPos, 'O');
        assertFalse(gb.checkVerticalWin(testPos));
    }

    @Test
    public void Test_CheckVerticalWin_Far_Right_Col_One_Short() {
        IGameBoard gb = GameBoardFactory(10, 10, 5);
        gb.placeMarker(new BoardPosition(0, 9), 'X');
        gb.placeMarker(new BoardPosition(1, 9), 'X');
        gb.placeMarker(new BoardPosition(2, 9), 'X');
        gb.placeMarker(new BoardPosition(3, 9), 'X');
        BoardPosition testPos = new BoardPosition(4, 9);
        gb.placeMarker(testPos, 'O');
        assertFalse(gb.checkVerticalWin(testPos));
    }

    @Test
    public void Test_CheckVerticalWin_Middle_Column_Five_In_a_Row() {
        IGameBoard gb = GameBoardFactory(10, 10, 5);
        gb.placeMarker(new BoardPosition(0, 5), 'X');
        gb.placeMarker(new BoardPosition(0, 0), 'O');
        gb.placeMarker(new BoardPosition(1, 5), 'X');
        gb.placeMarker(new BoardPosition(1, 1), 'O');
        gb.placeMarker(new BoardPosition(2, 5), 'X');
        gb.placeMarker(new BoardPosition(3, 4), 'O');
        gb.placeMarker(new BoardPosition(3, 5), 'X');
        gb.placeMarker(new BoardPosition(2, 7), 'O');
        BoardPosition testPos = new BoardPosition(4, 5);
        gb.placeMarker(testPos, 'X');
        assertTrue(gb.checkVerticalWin(testPos));
    }

    @Test
    public void Test_CheckVerticalWin_Two_In_a_Row_Separated_by_One() {
        IGameBoard gb = GameBoardFactory(10, 10, 5);
        gb.placeMarker(new BoardPosition(0, 8), 'X');
        gb.placeMarker(new BoardPosition(1, 8), 'X');
        gb.placeMarker(new BoardPosition(2, 8), 'O');
        gb.placeMarker(new BoardPosition(3, 8), 'X');
        BoardPosition testPos = new BoardPosition(4, 8);
        gb.placeMarker(testPos, 'X');
        assertFalse(gb.checkVerticalWin(testPos));
    }

    //Test Check Horizontal Win
    @Test
    public void Test_CheckHorizontalWin_Top_Row_One_Short() {
        IGameBoard gb = GameBoardFactory(10, 10, 5);
        gb.placeMarker(new BoardPosition(0, 0), 'X');
        gb.placeMarker(new BoardPosition(2, 2), 'O');
        gb.placeMarker(new BoardPosition(0, 1), 'X');
        gb.placeMarker(new BoardPosition(2,4), 'O');
        gb.placeMarker(new BoardPosition(0, 2), 'X');
        gb.placeMarker(new BoardPosition(7, 7), 'O');
        gb.placeMarker(new BoardPosition(0, 3), 'X');
        gb.placeMarker(new BoardPosition(9, 5), 'O');
        BoardPosition testPos = new BoardPosition(0, 4);
        gb.placeMarker(testPos, 'O');
        assertFalse(gb.checkHorizontalWin(testPos));
    }

    @Test
    public void Test_CheckHorizontalWin_Bottom_Row_One_Short() {
        IGameBoard gb = GameBoardFactory(10, 10, 5);
        gb.placeMarker(new BoardPosition(9, 0), 'X');
        gb.placeMarker(new BoardPosition(2, 2), 'O');
        gb.placeMarker(new BoardPosition(9, 1), 'X');
        gb.placeMarker(new BoardPosition(2,4), 'O');
        gb.placeMarker(new BoardPosition(9, 2), 'X');
        gb.placeMarker(new BoardPosition(7, 7), 'O');
        gb.placeMarker(new BoardPosition(9, 3), 'X');
        BoardPosition testPos = new BoardPosition(9, 4);
        gb.placeMarker(testPos, 'O');
        assertFalse(gb.checkHorizontalWin(testPos));
    }

    @Test
    public void Test_CheckHorizontalWin_Middle_5_in_a_Row() {
        IGameBoard gb = GameBoardFactory(10, 10, 5);
        gb.placeMarker(new BoardPosition(4, 3), 'X');
        gb.placeMarker(new BoardPosition(4, 2), 'O');
        gb.placeMarker(new BoardPosition(4, 4), 'X');
        gb.placeMarker(new BoardPosition(5, 7), 'O');
        gb.placeMarker(new BoardPosition(4, 5), 'X');
        gb.placeMarker(new BoardPosition(7, 7), 'O');
        gb.placeMarker(new BoardPosition(4, 6), 'X');
        gb.placeMarker(new BoardPosition(9, 5), 'O');
        BoardPosition testPos = new BoardPosition(4, 7);
        gb.placeMarker(testPos, 'X');
        assertTrue(gb.checkHorizontalWin(testPos));
    }

    @Test
    public void Test_CheckHorizontalWin_Two_In_a_Row_Separated_by_One() {
        IGameBoard gb = GameBoardFactory(10, 10, 5);
        gb.placeMarker(new BoardPosition(5, 0), 'X');
        gb.placeMarker(new BoardPosition(5, 1), 'X');
        gb.placeMarker(new BoardPosition(5, 2), 'O');
        gb.placeMarker(new BoardPosition(5, 3), 'X');
        BoardPosition testPos = new BoardPosition(5, 4);
        gb.placeMarker(testPos, 'X');
        assertFalse(gb.checkHorizontalWin(testPos));
    }
}
