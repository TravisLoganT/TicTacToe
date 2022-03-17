import java.util.Random;
import java.lang.Thread;
import java.util.concurrent.TimeUnit;

public class Computer {

    public static int getComputerPosition(){
        String computerDisplay = "Computer is thinking";
        String ellipsis = "...";

        for (char c: computerDisplay.toCharArray()){
            System.out.print(c);
            try{
                Thread.sleep(50);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        for (char c: ellipsis.toCharArray()){
            System.out.print(c);
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        // Have the computer choose a random position on the board;
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
