// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        GameBoard gameBoard = new GameBoard();
        Game game = new Game(gameBoard);
        game.startGame();
    }
}