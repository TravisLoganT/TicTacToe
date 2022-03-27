import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class TicTacToe {

    public static Scanner consoleInput = new Scanner(System.in);
    public static ArrayList<Integer> playerPositions = new ArrayList<>();
    public static ArrayList<Integer> player2Positions = new ArrayList<>();
    public static ArrayList<Integer> computerPositions = new ArrayList<>();
    public static String result = "";

    public static void main(String[] args) {
        gameChoice();

    }

    public static void playAgainstPlayer(){

        while(true){
            // Ask Player 1 what symbol they would like
            System.out.println("""
                    Player 1, choose your symbol:
                    1. O's
                    2. X's
                    """);
            String choice = consoleInput.nextLine();

            if (choice.equals("1")) {
                GameBoard.printGameBoard();

                while (true) {
                    int player1Pos = Player.getPlayerPosition("1");
                    Player.placePlayerSymbol(player1Pos, 'O', "1");
                    GameBoard.printGameBoard();
                    Winner.checkWinnerPlayerVSPlayer();

                    int player2Pos = Player.getPlayerPosition("2");
                    Player.placePlayerSymbol(player2Pos, 'X', "2");
                    GameBoard.printGameBoard();
                    Winner.checkWinnerPlayerVSPlayer();
                }
            } else if(choice.equals("2")){
                int player1Pos = Player.getPlayerPosition("2");
                Player.placePlayerSymbol(player1Pos, 'X', "2");
                GameBoard.printGameBoard();
                Winner.checkWinnerPlayerVSPlayer();

                int player2Pos = Player.getPlayerPosition("1");
                Player.placePlayerSymbol(player2Pos, 'O', "1");
                GameBoard.printGameBoard();
                Winner.checkWinnerPlayerVSPlayer();
            }
            else {
                System.out.println("You have not inputted a correct symbol please try again");
            }

        }
    }

    public static void playAgainstComputer(){

        while(true) {
            // Ask the user what symbol they would like to be
            System.out.println("""
                    Would you like to be:
                    1. O's
                    2. X's
                    """);
            String choice = consoleInput.nextLine();



            if (choice.equals("1")) {
                GameBoard.printGameBoard();

                // Start the Game
                while (true) {
                    int playerPos = Player.getPlayerPosition("1");
                    Player.placePlayerSymbol(playerPos, 'O', "1");
                    GameBoard.printGameBoard();
                    Winner.checkWinnerPlayerVSComputer();

                    int computerPos = Computer.getComputerPosition();
                    Computer.placeComputerPosition(computerPos, 'X');
                    GameBoard.printGameBoard();
                    Winner.checkWinnerPlayerVSComputer();
                }
            } else if (choice.equals("2")) {
                GameBoard.printGameBoard();
                // Start the Game
                while (true) {
                    int playerPos = Player.getPlayerPosition("1");
                    Player.placePlayerSymbol(playerPos, 'X', "1");
                    GameBoard.printGameBoard();
                    Winner.checkWinnerPlayerVSComputer();

                    int computerPos = Computer.getComputerPosition();
                    Computer.placeComputerPosition(computerPos, 'O');
                    GameBoard.printGameBoard();
                    Winner.checkWinnerPlayerVSComputer();

                }
            } else {
                System.out.println("You have not inputted a correct symbol please try again");
            }
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
                playAgainstPlayer();
            } else {
                System.out.println("You have not inputted a correct choice");
            }
        }
    }
}
