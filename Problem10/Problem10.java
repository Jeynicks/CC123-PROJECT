import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Problem10 {
    public static Scanner scan =  new Scanner(System.in);
    public static void main(String[] args) {
        Random random = new Random();
        int guess = 0;
        int generatedNumber = random.nextInt(100)+1;
        String message = " ";

        System.out.print("Guess The Number in 5 Tries\n");
        for(int x = 0; x < 5; x++){
            System.out.print("Guess the Secret Number: ");
            guess = scan.nextInt();
            int difference = Math.abs(generatedNumber - guess);

            if (difference == 0) {
                System.out.print("You guessed the number correctly");
                return;
            }
            else if (difference >= 50) {
                message = (guess > generatedNumber) ? "very high" : "very low";
            } else if (difference >= 30 && difference < 50) {
                message = (guess > generatedNumber) ? "high" : "low";
            } else if (difference >= 15 && difference < 30) {
                message = (guess > generatedNumber) ? "moderately high" : "moderately low";
            } else if (difference > 0 && difference < 15) {
                message = (guess > generatedNumber) ? "somewhat high" : "somewhat low";
            }
            System.out.printf("%d is %s\n", guess, message);
        }
        System.out.printf("Secret Number: %d", generatedNumber);
    }
}
