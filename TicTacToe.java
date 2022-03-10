import java.util.*;

public class TicTacToe {

    public static final Scanner consoleInput = new Scanner(System.in);

    public static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    public static ArrayList<Integer> computerPositions = new ArrayList<Integer>();


    public static void main(String[] args) {

        // create the game-board that the user will play on
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);

        while (true) {


            System.out.println("Enter where you would like to play (1-9)");
            int playerPosition = consoleInput.nextInt();

            placeSymbol(gameBoard, playerPosition, "Player");


            Random randomPosition = new Random();
            int computerPosition = randomPosition.nextInt(9) + 1;
            placeSymbol(gameBoard, computerPosition, "CPU");

            printGameBoard(gameBoard);

            String result = checkWinner();

            System.out.println(result);
        }

    }

    public static void printGameBoard(char[][] gameBoard){

        // print out each array in the game-board
        for (char[] row: gameBoard){
            // print out each symbol
            for (char c : row){
                System.out.print(c);
            }
            // create a new line when the line array of characters is finished
            System.out.println();
        }


    }

    public static void placeSymbol(char[][] gameBoard, int position, String user){

        char symbol = ' ';
        if (user.equals("Player")){
            symbol = 'X';
            playerPositions.add(position);
        } else if (user.equals("CPU")){
            symbol = 'O';
            computerPositions.add(position);
        }
        switch (position) {
            case 1 -> gameBoard[0][0] = symbol;
            case 2 -> gameBoard[0][2] = symbol;
            case 3 -> gameBoard[0][4] = symbol;
            case 4 -> gameBoard[2][0] = symbol;
            case 5 -> gameBoard[2][2] = symbol;
            case 6 -> gameBoard[2][4] = symbol;
            case 7 -> gameBoard[4][0] = symbol;
            case 8 -> gameBoard[4][2] = symbol;
            case 9 -> gameBoard[4][4] = symbol;
            default -> throw new IllegalStateException("Unexpected value: " + position);
        }
    }

    public static String checkWinner(){

        List topRow = Arrays.asList(1, 2, 3);
        List middleRow = Arrays.asList(4, 5, 6);
        List bottomeRow = Arrays.asList(7, 8, 9);

        List leftColumn = Arrays.asList(1, 4, 7);
        List middleColumn = Arrays.asList(2, 5, 8);
        List rightColumn = Arrays.asList(3, 6, 9);

        List leftToRightCross = Arrays.asList(1, 5, 9);
        List rightToLeftCross = Arrays.asList(7, 5, 3);

        List<List> winningConditions = new ArrayList<List>();
        winningConditions.add(topRow);
        winningConditions.add(middleRow);
        winningConditions.add(bottomeRow);
        winningConditions.add(leftColumn);
        winningConditions.add(middleColumn);
        winningConditions.add(rightColumn);
        winningConditions.add(leftToRightCross);
        winningConditions.add(rightToLeftCross);

        for (List chosenList: winningConditions){
            if (playerPositions.containsAll(chosenList)){
                return "You have won!";
            }
            else if (computerPositions.containsAll(chosenList)){
                return "CPU wins!";
            }
            else if(playerPositions.size() + computerPositions.size() == 9){
                return "Draw!";
            }
        }
        return "";
    }


}
