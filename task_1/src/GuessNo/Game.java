package GuessNo;

import java.util.*;

public class Game {
    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int attempts, max_attempts = 5, score = 0, ch;
        int flag;
        do {
            attempts = 0;
            flag = 0;
            int no_guess = rand.nextInt(100) + 1;
            while (attempts < max_attempts) {
                System.out.println("Enter your guess:");
                int guess = sc.nextInt();
                attempts++;
                if (guess == no_guess) {
                    System.out.println("Your guess is correct!!");
                    score++;
                    flag = 1;
                    break;
                } else if (guess < no_guess) {
                    System.out.println("Your guess is too low!!");
                } else {
                    System.out.println("Your guess is too High!!");
                }
            }
            if (flag == 0) {
                System.out.println("Game over");
                System.out.println("The correct ans is: " + no_guess);
            }
            System.out.println("Score: " + score);
            System.out.println("Do you wish to play again?\n1) Play Again\n2) End");
            ch = sc.nextInt();
        } while (ch == 1);
    }
}
