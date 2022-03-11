public class GameBoard {

    // create the game-board that the user will play on
    public static char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};

    public static void printGameBoard(){

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

    public static void symbolPlacement(int position, char symbol){

        // Initialize all the possible places of the GameBoard that are valid places to put 'O's or 'X's
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
}
