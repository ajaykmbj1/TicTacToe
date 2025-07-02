package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    void testPrintBoardShowsCorrectState(){
        Board board = new Board();
        board.place(0,0,'X');
        board.place(1,1,'O');

        String expected =
                "━━━━━━━\n" +
                        "|X| | |\n" +
                        "| |O| |\n" +
                        "| | | |\n" +
                        "━━━━━━━\n";

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        board.print();

        System.setOut(System.out);

        assertEquals(expected, outContent.toString());
    }

    @Test
    void testPrintBoardInitialEmpty(){
        Board board = new Board();

        String expected =
                "━━━━━━━\n" +
                        "| | | |\n" +
                        "| | | |\n" +
                        "| | | |\n" +
                        "━━━━━━━\n";

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        board.print();

        System.setOut(System.out);

        assertEquals(expected, outContent.toString());
    }
}
