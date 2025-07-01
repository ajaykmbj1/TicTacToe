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
}
