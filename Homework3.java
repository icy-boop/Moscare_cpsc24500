import java.util.Scanner;
import java.util.Random;
/**
 * Rock, Paper, Scissors Game against computer
 * User input 1 to 3: 1 for rock, 2 for paper, 3 for Scissors
 * user input greater than 1 and less than or equal 3
 * otherwise put error message to user and user input again
 * rock wins to scissors, scissors wins to paper, paper wins to rock
 * if both player choose the sam choice then the game must be play again
 * if a game ended, program asks the player if they want another game
 * 
 */

public class Homework3{

    public static int playerOneChoice(Scanner scanner) {      //User Validatio 
        int choice;
        do {
            System.out.print("Player One: please enter 1 for Rock 2 for Paper 3 for Scissors ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice < 1 || choice > 3) {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
            }
        } while (choice < 1 || choice > 3);
        return choice;
    }

    public static String getChoiceName(int choice) {
        switch (choice) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "";
        }
    }
    public static int isWinner(int playerOneChoice, int playerTwoChoice) {
        if (playerOneChoice == playerTwoChoice) {
            return 0; 
        } else if ((playerOneChoice == 1 && playerTwoChoice == 3) ||
                   (playerOneChoice == 2 && playerTwoChoice == 1) ||
                   (playerOneChoice == 3 && playerTwoChoice == 2)) {
            return 1;                       // player one wins
        } else {
            return -1;                     // player two wins
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        boolean playAgain = true;

        System.out.println("Welcome!!!!! Let's play Rock Paper Scissors Game");
        System.out.println("Here's the rules: Enter 1 for Rock, 2 for Paper, 3 for Scissors.");

        while (playAgain) {

            int playerOneChoice = playerOneChoice(input);
            int playerTwoChoice = rand.nextInt(3) + 1;

            System.out.println("You chose: " + getChoiceName(playerOneChoice));
            System.out.println("Player Two chose: " + getChoiceName(playerTwoChoice));

            int result = isWinner(playerOneChoice, playerTwoChoice);    //display the winner here
            if (result == 1) {
                System.out.println("You win!!!");
            } else if (result == -1) {
                System.out.println("Player Two wins!!!");
            } else {
                System.out.println("It's a tie!!! Let's play again.");
                continue;
            }

            System.out.print("Do you want to play again? (Y/N): ");
            String playAgainInput = input.next();
            playAgain = playAgainInput.equalsIgnoreCase("Y");
        }

        System.out.println("Thank you! Till next time... ");
        input.close();
    }

}
