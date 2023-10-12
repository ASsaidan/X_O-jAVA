import java.util.Random;
import java.util.Scanner;

public class Game {
    private GameBoard gameBoard; // Create a game board.
    private FirstPlayer player1; // Create the first player.
    private SecondPlayer player2; // Create the second player.

    public Game(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        this.player1 = new FirstPlayer("", 'X'); // Initialize the first player with a symbol 'X'.
        this.player2 = new SecondPlayer("", 'O'); // Initialize the second player with a symbol 'O'.
    }

    public void startGame() {
        Scanner input = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            try {
                System.out.println("Welcome to our X-O game!");

                // Get player 1's name.
                System.out.println("Player 1 Name:");
                String player1Name = input.nextLine();
                player1.setPlayerName(player1Name);

                // Get player 2's name.
                System.out.println("Player 2 Name:");
                String player2Name = input.nextLine();
                player2.setPlayerName(player2Name);

                System.out.println("Hello " + player1Name + " and " + player2Name + ".");
                System.out.println("Turns and symbols will be randomized.");

                // Randomly choose which player goes first.
                Random random = new Random();
                int randomValue = random.nextInt(2);

                System.out.println(player1.getPlayerName() + " will be " + player1.getPlayerSymbol() +
                        " and " + player2.getPlayerName() + " will be " + player2.getPlayerSymbol() + ".");
                System.out.println("Let's begin!");
                System.out.println("Here is the board:");

                this.gameBoard.printBoard();

                while (true) {
                    // Player 1's turn
                    System.out.println(player1.getPlayerName() + ", enter row and column (ex., 1 2): With space between them.");
                    try {
                        String[] coordinates = input.nextLine().split(" ");
                        int row = Integer.parseInt(coordinates[0]);
                        int col = Integer.parseInt(coordinates[1]);

                        // Check if the move is valid.
                        if (this.gameBoard.isValidMove(row, col)) {
                            player1.makeMove(this.gameBoard, row, col);
                            this.gameBoard.printBoard();

                            // Check if player 1 wins.
                            if (this.gameBoard.checkWin(player1.getPlayerSymbol())) {
                                System.out.println(player1.getPlayerName() + " wins!");
                                break;
                            }

                            // Check if the game is a tie.
                            if (this.gameBoard.isBoardFull()) {
                                System.out.println("The game is a tie!");
                                break;
                            }

                            // Player 2's turn
                            while (true) {
                                System.out.println(player2.getPlayerName() + ", enter row and column (ex., 1 2): With space between them.");
                                try {
                                    coordinates = input.nextLine().split(" ");
                                    row = Integer.parseInt(coordinates[0]);
                                    col = Integer.parseInt(coordinates[1]);

                                    if (this.gameBoard.isValidMove(row, col)) {
                                        player2.makeMove(this.gameBoard, row, col);
                                        this.gameBoard.printBoard();

                                        // Check if player 2 wins.
                                        if (this.gameBoard.checkWin(player2.getPlayerSymbol())) {
                                            System.out.println(player2.getPlayerName() + " wins!");
                                            break;
                                        }

                                        // Check if the game is a tie.
                                        if (this.gameBoard.isBoardFull()) {
                                            System.out.println("The game is a tie!");
                                            break;
                                        }

                                        // Switch back to player 1's turn.
                                        break;
                                    } else {
                                        System.out.println("Invalid move. Please try again.");
                                    }
                                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                                    System.out.println("Invalid input. Please enter two integers separated by a space.");
                                }
                            }
                        } else {
                            System.out.println("Invalid move. Please try again.");
                        }
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                        System.out.println("Invalid input. Please enter two integers separated by a space.");
                    }
                }

                // Ask the user if they want to play again.
                System.out.println("Do you want to play again? (Y/N)");
                String playAgainInput = input.nextLine();
                playAgain = playAgainInput.equalsIgnoreCase("Y");
            } finally {
                this.gameBoard.resetBoard(); // Reset the game board for a new game.
            }
        }

        input.close(); // Close the input scanner when the game is finished.
    }
}
