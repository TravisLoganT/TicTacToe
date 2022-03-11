import java.util.*;

public class TicTacToe {

    public static Scanner consoleInput = new Scanner(System.in);
    public static ArrayList<Integer> playerPositions = new ArrayList<>();
    public static ArrayList<Integer> computerPositions = new ArrayList<>();
    public static String result = "";

    public static void main(String[] args) {
        // Show the user the GameBoard
        GameBoard.printGameBoard();

        // Start the Game
        while(true){
            int playerPos = Player.getPlayerPosition();
            Player.placePlayerSymbol(playerPos);
            Winner.checkWinner();

            int computerPos = Computer.getComputerPosition();
            Computer.placeComputerPosition(computerPos);
            Winner.checkWinner();

            GameBoard.printGameBoard();
        }
    }
}
