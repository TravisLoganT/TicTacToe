import java.util.*;

public class TicTacToe {

    public static Scanner consoleInput = new Scanner(System.in);

    public static ArrayList<Integer> playerPositions = new ArrayList<>();
    public static ArrayList<Integer> computerPositions = new ArrayList<>();
    public static String result = "";


    public static void main(String[] args) {

        // create the game-board that the user will play on
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        GameBoard.printGameBoard(gameBoard);

        while(true) {


            System.out.println("Enter where you would like to play (1-9)");
            int playerPosition = consoleInput.nextInt();
            while(playerPositions.contains(playerPosition) || computerPositions.contains(playerPosition)) {
                System.out.println("This position has been taken");
                playerPosition = consoleInput.nextInt();
            }



            placeSymbol(gameBoard, playerPosition, "Player");
            result = checkWinner();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }



            Random randomPosition = new Random();
            int computerPosition = randomPosition.nextInt(9) + 1;
            while(playerPositions.contains(computerPosition) || computerPositions.contains(computerPosition)) {
                computerPosition = randomPosition.nextInt(9 + 1 );
            }

            placeSymbol(gameBoard, computerPosition, "CPU");

            GameBoard.printGameBoard(gameBoard);
            result = checkWinner();

            if(result.length() > 0){
                System.out.println(result);
                break;
            }

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

        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> middleRow = Arrays.asList(4, 5, 6);
        List<Integer> bottomRow = Arrays.asList(7, 8, 9);

        List<Integer> leftColumn = Arrays.asList(1, 4, 7);
        List<Integer> middleColumn = Arrays.asList(2, 5, 8);
        List<Integer> rightColumn = Arrays.asList(3, 6, 9);

        List<Integer> leftToRightCross = Arrays.asList(1, 5, 9);
        List<Integer> rightToLeftCross = Arrays.asList(7, 5, 3);

        ArrayList<List> winningConditions = new ArrayList<>();
        winningConditions.add(topRow);
        winningConditions.add(middleRow);
        winningConditions.add(bottomRow);
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
