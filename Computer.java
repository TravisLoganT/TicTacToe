import java.util.Random;

public class Computer {

    public static int getComputerPosition(){

        // Have the computer choose a random position on the board
        Random randomPosition = new Random();
        int computerPosition = randomPosition.nextInt(9) + 1;
        //Ensure that the computer doesn't choose a position that has already been taken by the user or itself
        while(TicTacToe.playerPositions.contains(computerPosition) || TicTacToe.computerPositions.contains(computerPosition)) {
            computerPosition = randomPosition.nextInt(9 + 1 );
        }
        return computerPosition;
    }

    public static void placeComputerPosition(int computerPosition){
        // Place the position to the GameBoard
        char symbol = 'O';
        TicTacToe.computerPositions.add(computerPosition);
        GameBoard.symbolPlacement(computerPosition, symbol);
    }
}
