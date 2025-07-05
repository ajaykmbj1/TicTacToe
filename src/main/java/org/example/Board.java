package org.example;

public class Board {
    private final char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear(); // Initialize board
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    public void place(int x, int y, char marker) {
        if (isCellEmpty(x, y)) {
            cells[x][y] = marker;
        }
    }

    public char getCell(int x, int y){
        return cells[x][y];
    }

    public void clear() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                cells[i][j] = ' ';
    }

    public void print() {
        System.out.println("━━━━━━━");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j] == ' ' ? " " : cells[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("━━━━━━━");
    }
    public boolean checkWin(char marker) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((cells[i][0] == marker && cells[i][1] == marker && cells[i][2] == marker) ||
                    (cells[0][i] == marker && cells[1][i] == marker && cells[2][i] == marker)) {
                return true;
            }
        }

        return (cells[0][0] == marker && cells[1][1] == marker && cells[2][2] == marker) ||
                (cells[0][2] == marker && cells[1][1] == marker && cells[2][0] == marker);
    }
    public boolean isFull(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (cells[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }
}
