public class FirstPlayer extends Players {
    // This is the constructor for the FirstPlayer.
    public FirstPlayer(String playerName, char playerSymbol) {
        // It sets the player's name and symbol using the parent class's constructor (Players).
        super(playerName, playerSymbol);
    }

    // This method checks if the move is valid for the FirstPlayer on the game board.
    public boolean checkMove(GameBoard gameBoard, int row, int col) {
        // It looks to see if the cell at the specified row and column is empty.
        if (gameBoard.board[row][col] == ' ') {
            return true; // The move is valid because the cell is empty.
        } else {
            return false; // The move is not valid because the cell is already occupied.
        }
    }
}
