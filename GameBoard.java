public class GameBoard {

    // create the game-board that the user will play on
    char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};

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
}
