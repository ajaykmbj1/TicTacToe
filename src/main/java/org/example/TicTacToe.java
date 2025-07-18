package org.example;
import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {  // Spielwiederholungsschleife
            board.clear();
            currentPlayer = player1;

            while (true) {  // Eine Spielrunde
                System.out.println("Current Player: " + currentPlayer.getMarker());
                board.print();

                System.out.print("row (0-2): ");
                int row = scanner.nextInt();
                System.out.print("column (0-2): ");
                int col = scanner.nextInt();

                if (board.isCellEmpty(row, col)) {
                    board.place(row, col, currentPlayer.getMarker());

                    if (board.checkWin(currentPlayer.getMarker())) {
                        board.print();
                        System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                        break;
                    }

                    if (board.isFull()) {
                        board.print();
                        System.out.println("It's a draw!");
                        break;
                    }

                    switchCurrentPlayer();
                } else {
                    System.out.println("Cell is not empty, try again.");
                }
            }

            System.out.print("Play again? (y/n): ");
            String response = scanner.next().trim().toLowerCase();
            if (!response.equals("y")) {
                System.out.println("Thanks for playing!");
                break;
            }
        }
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}
