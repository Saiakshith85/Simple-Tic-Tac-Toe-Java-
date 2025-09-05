import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameOver = false;

        System.out.println("Welcome to Tic Tac Toe!");
        printBoard();

        while (!gameOver) {
            System.out.println("Player " + currentPlayer + ", choose a position (1-9): ");
            int position = sc.nextInt();

            if (position >= 1 && position <= 9) {
                int row = (position - 1) / 3;
                int col = (position - 1) % 3;

                if (board[row][col] == ' ') {
                    board[row][col] = currentPlayer;
                    printBoard();

                    if (checkWin(currentPlayer)) {
                        System.out.println("Player " + currentPlayer + " wins!");
                        gameOver = true;
                    } else if (isBoardFull()) {
                        System.out.println("It's a draw!");
                        gameOver = true;
                    } else {
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("That spot is already taken! Try again.");
                }
            } else {
                System.out.println("Invalid input! Please choose a number between 1 and 9.");
            }
        }

        sc.close();
    }

    // Print the board with position numbers for empty spaces
    public static void printBoard() {
        System.out.println("-------------");
        int position = 1;
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    System.out.print(position + " | "); // Show position number if empty
                } else {
                    System.out.print(board[i][j] + " | "); // Show X or O
                }
                position++;
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Check if the current player has won
    public static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            // Check rows and columns
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Check diagonals
 return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
        (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    // Check if the board is full
    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
