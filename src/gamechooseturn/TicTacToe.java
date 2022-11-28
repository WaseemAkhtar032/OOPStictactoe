package gamechooseturn;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe extends botmove.TicTacToe {
    private static char wasee, bot;
    private static int toss;//For tossing between player and computer
    private static boolean botFlag = false, waseeFlag = false;
    static Scanner scan = new Scanner(System.in);
    static Random random = new Random();

    //Asking user to play again.
    public static void playAgain() {
        System.out.println("\n\t*** Want to play again? ***\n\t *****Press 1 for continue 2 for stop.*****");
        char playAgain = scan.next().charAt(0);
        while (true) {
            if (playAgain == '1') {
                startGame();
                playAgain();
                break;
            }
            else if (playAgain == '2') {
                break;
            }
            else {
                System.out.println("\n\t*** Invalid Choice ***\n\t *** Provide the Valid Choice ***");
                break;
            }
        }
    }

    //Starts the game
    public static void startGame() {
        initialize();
        showBoard();
        chooseSymbol();
        toss();
        while (tie()) {
            System.out.println();
            turn();
            if (checkWinner(wasee, bot)) {
                break;
            }
            else if (!tie()) {
                System.out.println("Board is full");
                System.out.println("It is a tie");
            }
        }
        System.out.println("\nThe game is over.");
        botFlag = false;
        waseeFlag = false;
    }

    //Doing a toss for playing first
    public static void toss()
    {
        toss = random.nextInt(2);
        switch (toss) {
            case 0 :
                System.out.println("Flipping Tail.\n Bot starts first.");
                botMove(random, wasee, bot);//Computer move
                botFlag = true;
                break;
            case 1 :
                System.out.println("Flipping Head.\n Wasee starts first.");
                waseeMove(scan, wasee, bot);//Player move
                waseeFlag = true;
                break;
        }
    }

    //Allow player to choose X or O
    public static void chooseSymbol() {
        System.out.println("Please Select Your Choice Letter : \nProvide 'X' or 'O'");
        wasee = check();
        System.out.println("Wasee choosing option : "+ wasee);
    }
    public static char check()  //Sub method of chooseOption
    {
        char choice = scan.next().charAt(0);
        if (choice == 'X' || choice == 'x') {
            wasee = 'X';
            bot = 'O';
        }
        else if (choice == 'O' || choice == 'o') {
            wasee = 'O';
            bot = 'X';
        }
        else {
            System.out.println("Invalid option.\nProvide the valid one");
            check();
        }
        return wasee;
    }

    //Check for turn
    public static void turn() {
        check.TicTacToe CheckConditions = null;
        CheckConditions.checkGame(wasee, bot);
        System.out.println("Turn Changed");
        if (botFlag == true) {
            System.out.println("Now Wasee's Turn");
            waseeMove(scan, wasee, bot);
            botFlag = false;
            waseeFlag = true;
        }
        else if (waseeFlag == true) {
            System.out.println("Now Bot's Turn");
            botMove(random, wasee, bot);//Here it's how computer starts to play like me.
            waseeFlag = false;
            botFlag = true;
        }
    }
}
