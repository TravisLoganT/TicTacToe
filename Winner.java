import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Winner {

    public static void exit(){
        // close the application
        System.exit(0);
    }

    public static void checkWinner(){

        // List all the row possibilities for a win
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> middleRow = Arrays.asList(4, 5, 6);
        List<Integer> bottomRow = Arrays.asList(7, 8, 9);

        // List all the column possibilities for a win
        List<Integer> leftColumn = Arrays.asList(1, 4, 7);
        List<Integer> middleColumn = Arrays.asList(2, 5, 8);
        List<Integer> rightColumn = Arrays.asList(3, 6, 9);

        // List all the diagonal possibilities for a win
        List<Integer> leftToRightCross = Arrays.asList(1, 5, 9);
        List<Integer> rightToLeftCross = Arrays.asList(7, 5, 3);

        // Add all the winning combinations to a List
        ArrayList<List> winningConditions = new ArrayList<>();
        winningConditions.add(topRow);
        winningConditions.add(middleRow);
        winningConditions.add(bottomRow);
        winningConditions.add(leftColumn);
        winningConditions.add(middleColumn);
        winningConditions.add(rightColumn);
        winningConditions.add(leftToRightCross);
        winningConditions.add(rightToLeftCross);

        // If a winning combination is made by the user or computer, display who won. Or display a draw.
        for (List chosenList: winningConditions){
            if (TicTacToe.playerPositions.containsAll(chosenList)){
                System.out.println("You have won!");
                exit();
            }
            else if (TicTacToe.computerPositions.containsAll(chosenList)){
                System.out.println("CPU Wins!");
                exit();
            }
            else if(TicTacToe.playerPositions.size() + TicTacToe.computerPositions.size() == 9){
                System.out.println("Draw");
            exit();
            }
        }

    }
    
}
