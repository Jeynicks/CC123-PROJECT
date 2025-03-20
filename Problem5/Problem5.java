import java.util.Scanner;
public class Problem5 {
    public static Scanner scan =  new Scanner(System.in);
    public static void main(String[] args) {

        char response = ' ';

        do {
            System.out.print("Enter a number: ");
            int limit = scan.nextInt();

            if (limit < 1) {
                System.out.println("Please enter a positive integer.");
                continue;
            }

            // USING BOOLEAN TO CHECK IF THERE'S A PERFECT NUM
            boolean foundPerfect = false;

            // CHECK NUM FROM 1 TO LIMIT
            for (int n = 1; n <= limit; n++) {
                int sum = 0;

                // FIND SUM OF PROPER DIVISOR
                for (int m = 1; m < n; m++) {
                    if (n % m == 0) {
                        sum += m; // ADD DIVISOR TO SUM
                    }
                }

                if (sum == n) {
                    if (!foundPerfect) {
                        System.out.print("Perfect numbers from 1 to " + limit + ": " + n);
                        foundPerfect = true;
                    } else {
                        System.out.print(", " + n);
                    }
                }
            }

            if (!foundPerfect) {
                System.out.println("Perfect numbers from 1 to " + limit + ": None");
            } else {
                System.out.println();
            }

            System.out.print("Do you wish to to continue (Y/N): ");
            response = Character.toUpperCase(scan.next().charAt(0));

        } while (response == 'Y');
        System.out.println("TERMINATING PROGRAM!!!");
        scan.close();
    }
}
