import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class TicTacToe {

    public static Scanner consoleInput = new Scanner(System.in);
    public static ArrayList<Integer> playerPositions = new ArrayList<>();
    public static ArrayList<Integer> computerPositions = new ArrayList<>();
    public static String result = "";

    public static void main(String[] args) {
        gameChoice();


    }

    public static void playAgainstComputer(){

        while(true) {
            // Ask the user what symbol they would like to be
            System.out.println("Would you like to be:\n" +
                    "1. O's\n" +
                    "2. X's\n");
            String choice = consoleInput.nextLine();

            if (choice.equals("1")) {

                // Start the Game
                while (true) {
                    int playerPos = Player.getPlayerPosition();
                    Player.placePlayerSymbol(playerPos, 'O');
                    Winner.checkWinner();

                    int computerPos = Computer.getComputerPosition();
                    Computer.placeComputerPosition(computerPos, 'X');
                    Winner.checkWinner();

                    GameBoard.printGameBoard();
                }
            } else if (choice.equals("2")) {
                // Start the Game
                while (true) {
                    int playerPos = Player.getPlayerPosition();
                    Player.placePlayerSymbol(playerPos, 'X');
                    Winner.checkWinner();

                    int computerPos = Computer.getComputerPosition();
                    Computer.placeComputerPosition(computerPos, 'O');
                    Winner.checkWinner();

                    GameBoard.printGameBoard();
                }
            } else {
                System.out.println("You have not inputted a correct symbol please try again");
            }


            // Show the user the GameBoard
            GameBoard.printGameBoard();
        }


    }

    public static void gameChoice(){

        System.out.println("What mode would you like to play?\n-------------------------------");
        System.out.println("1. Against the computer" +
                "\n2. Against another player");
        String choice = consoleInput.nextLine();

        while (true) {

            if (choice.equals("1")) {
                playAgainstComputer();
            } else if (choice.equals("2")) {
                // playAgainstPlayer();
            } else {
                System.out.println("You have not inputted a correct choice");
            }
        }
    }
}
