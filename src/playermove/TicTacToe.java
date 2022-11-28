package playermove;

import java.util.Scanner;

public class TicTacToe extends check.TicTacToe {
    private static int waseeLocation;

    //To make the player move
    public static void waseeMove(Scanner scan, char player, char computer)
    {
        checkSpace();
        int position = blockUser(computer);
        if (position == 0)
        {
            System.out.println("No position to be blocked.\nTry to win");
        }
        else if (position != 0)
        {
            System.out.println("Block you opponent on position : "+position);
            System.out.println("If you don't want to block try to win");
        }
        System.out.println("Enter the position between (1-9) you want to make your move :");
        waseeLocation = scan.nextInt();
        if (waseeLocation > 0 && waseeLocation < 10)
        {
            if (board[waseeLocation] == ' ')
            {
                board[waseeLocation] = player;
                showBoard();
            }
            else if (board[waseeLocation] != ' ')
            {
                System.err.println("Ah-hh! Position is already chosen. Enter a valid position");
                showBoard();
                waseeMove(scan, player, computer);
                showBoard();
            }
        }
        else
        {
            System.err.println("Invalid choice. Provide a valid position between (1-9)");
            waseeMove(scan, player, computer);
        }
    }
}
