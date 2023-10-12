public class GameBoard {
    char[][] board = new char[3][3]; // Create a 3x3 game board as a 2D array.

    public GameBoard() {
        // Initialize the game board with empty spaces.
        for (int i = 0; i < 3; i++) {
            board[i][0] = ' ';
            board[i][1] = ' ';
            board[i][2] = ' ';
        }
    }

    public void printBoard() {
        // Print the current state of the game board.
        System.out.println("  0 1 2");
        System.out.println("0 " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("  -----");
        System.out.println("1 " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("  -----");
        System.out.println("2 " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }

    public boolean isValidMove(int row, int col) {
        // Check if a move is valid (i.e., the cell is empty).
        if (board[row][col] == ' ') {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBoardFull() {
        // Check if the game board is completely filled.
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == ' ' || board[i][1] == ' ' || board[i][2] == ' ') {
                return false;
            }
        }
        return true;
    }

    public boolean checkWin(char playerSymbol) {
        // Check if the player with the specified symbol has won the game.
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == playerSymbol && board[i][1] == playerSymbol && board[i][2] == playerSymbol) {
                return true;
            }
        }
        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == playerSymbol && board[1][j] == playerSymbol && board[2][j] == playerSymbol) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == playerSymbol && board[1][1] == playerSymbol && board[2][2] == playerSymbol) {
            return true;
        }
        if (board[0][2] == playerSymbol && board[1][1] == playerSymbol && board[2][0] == playerSymbol) {
            return true;
        }
        return false;
    }

    public void resetBoard() {
        // Reset the game board by clearing all cells.
        for (int i = 0; i < 3; i++) {
            board[i][0] = ' ';
            board[i][1] = ' ';
            board[i][2] = ' ';
        }
    }
}
