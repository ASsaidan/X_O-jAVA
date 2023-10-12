public class Players {
    // Each player has a name and a symbol.
    String playerName;
    char playerSymbol;

    // This is the constructor for the Players class.
    public Players(String playerName, char playerSymbol) {
        // It sets the player's name and symbol.
        this.playerName = playerName;
        this.playerSymbol = playerSymbol;
    }

    // This method allows a player to make a move on the game board.
    public void makeMove(GameBoard gameBoard, int row, int col) {
        // It marks a specific cell on the game board with the player's symbol.
        gameBoard.board[row][col] = playerSymbol;
    }

    // This method retrieves the player's symbol.
    public char getPlayerSymbol() {
        // It returns the symbol associated with the player.
        return playerSymbol;
    }

    // This method allows you to change the player's symbol.
    public void setPlayerSymbol(char playerSymbol) {
        // It updates the symbol associated with the player.
        this.playerSymbol = playerSymbol;
    }

    // This method retrieves the player's name.
    public String getPlayerName() {
        // It returns the name of the player.
        return playerName;
    }

    // This method allows you to change the player's name.
    public void setPlayerName(String playerName) {
        // It updates the name of the player.
        this.playerName = playerName;
    }
}
