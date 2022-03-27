public class Player {
    static int playerPosition = 0;
    static int player2Position = 0;

    public static int getPlayerPosition(String player) {

        if (player.equals("1")) {
            //Let the User decided where they would like to start
            System.out.println("Enter where you would like to play (1-9)");
            playerPosition = TicTacToe.consoleInput.nextInt();

            // Notify the user if their chosen place has been taken by the computer or themselves
            while (TicTacToe.playerPositions.contains(playerPosition) || TicTacToe.computerPositions.contains(playerPosition)
                        || TicTacToe.player2Positions.contains(playerPosition)) {
                    System.out.println("This position has been taken");
                    playerPosition = TicTacToe.consoleInput.nextInt();
                }

                return playerPosition;

        } else if (player.equals("2")) {
            //Let the User decided where they would like to start
            System.out.println("Enter where you would like to play (1-9)");
            player2Position = TicTacToe.consoleInput.nextInt();

                // Notify the user if their chosen place has been taken by the computer or themselves
                while (TicTacToe.player2Positions.contains(player2Position) || TicTacToe.playerPositions.contains(player2Position)) {
                    System.out.println("This position has been taken");
                    player2Position = TicTacToe.consoleInput.nextInt();
                }
                return player2Position;
            }

        return -1;
    }
    public static void placePlayerSymbol(int position, char symbol, String player){

        if (player.equals("1")) {
            // Add the players choice to the GameBoard
            TicTacToe.playerPositions.add(playerPosition);
            GameBoard.symbolPlacement(position, symbol);
        }
        else if (player.equals("2")){
            TicTacToe.player2Positions.add(player2Position);
            GameBoard.symbolPlacement(position, symbol);
        }
    }
}
