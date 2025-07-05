package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    void testValidMove(){
        Board board = new Board();
        board.place(0, 0, 'X');
        assertEquals('X', board.getCell(0,0));
    }

    @Test
    void testPlaceInvalidMoveSameCell(){
        Board board = new Board();
        board.place(0,0,'X');
        board.place(0,0,'O');
        assertEquals('X', board.getCell(0,0));
    }
    @Test
    void testCheckWinTrue() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'X');
        assertTrue(board.checkWin('X'), "Player X should win with top row");
    }
    @Test
    void testDrawSituation() {
        Board board = new Board();
        // Fill the board with a draw (no winner)
        board.place(0, 0, 'X');
        board.place(0, 1, 'O');
        board.place(0, 2, 'X');
        board.place(1, 0, 'X');
        board.place(1, 1, 'O');
        board.place(1, 2, 'O');
        board.place(2, 0, 'O');
        board.place(2, 1, 'X');
        board.place(2, 2, 'X');

        assertFalse(board.checkWin('X'));
        assertFalse(board.checkWin('O'));
        assertTrue(board.isFull(), "Board should be full (draw)");
    }

}
