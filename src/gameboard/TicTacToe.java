package gameboard;

public class TicTacToe {
    public static char[] board = new char[10];

    //Initialization of game
    public static void initialize() {
        for (int i = 1; i < 10; i++)
        {
            board[i] = ' ';
        }
    }

    //To see board
    public static void showBoard() {
        System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("---------");
        System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("---------");
        System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
    }

    //To check free space
    public static void checkSpace() {
        boolean isSpaceAvailable = false;
        int numofEmptySpaces = 0;
        for(int index=1; index<board.length; index++)
        {
            if((board[index] == ' '))
            {
                isSpaceAvailable = true;
                numofEmptySpaces++;
            }
        }
        if(isSpaceAvailable == false)
        {
            System.err.println("Board is full!!!");
        }
        else
        {
            System.out.println("Free space is available! you have "+ numofEmptySpaces + " moves left");
        }
    }
}
