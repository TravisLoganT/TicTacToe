public class Player {

    public static int getPlayerPosition() {

        //Let the User decided where they would like to start
        System.out.println("Enter where you would like to play (1-9)");
        int playerPosition = TicTacToe.consoleInput.nextInt();
        // Notify the user if their chosen place has been taken by the computer or themselves
        while(TicTacToe.playerPositions.contains(playerPosition) || TicTacToe.computerPositions.contains(playerPosition)) {
            System.out.println("This position has been taken");
            playerPosition = TicTacToe.consoleInput.nextInt();
        }
        return playerPosition;
    }

    public static void placePlayerSymbol(int playerPosition){

        // Add the players choice to the GameBoard
        char symbol = 'X';
        TicTacToe.playerPositions.add(playerPosition);
        GameBoard.symbolPlacement(playerPosition, symbol);
    }
}
