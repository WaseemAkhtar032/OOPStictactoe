package botmove;

import java.util.Random;

public class TicTacToe extends playermove.TicTacToe {
    private static int botLocation;

    //To make the computer move
    public static void botMove(Random random, char player, char computer) {
        int position = blockUser(player);
        if (position == 0) {
            botLocation = random.nextInt(8)+1;//Random gives 0 to 8 so +1 give you 1 to 9 position.
        }
        else if (position != 0) {
            System.out.println("Computer block the position : "+position);
            botLocation = position;
        }
        if (botLocation > 0 && botLocation < 10) {
            if (board[botLocation] == ' ') {
                board[botLocation] = computer;
                showBoard();
            }
            else if (board[botLocation] != ' ') {
                botMove(random, player, computer);
            }
        }
    }
}
