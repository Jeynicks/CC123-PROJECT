import java.util.Scanner;

public class Problem6 {
    public static Scanner scan =  new Scanner(System.in);
    public static void main(String[] args) {

        char response;

        do {
            System.out.print("Enter an integer: ");
            int num = scan.nextInt();

            // NUM MUST BE POSITIVE AND GREATER THAN  0
            if (num <= 1) {
                System.out.println(num + " is not prime.");
            } else {
                // CHECK IF NUM IS PRIME
                boolean isPrime = true;
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (!isPrime) {
                    System.out.println(num + " is not prime.");
                } else {
                    // REVERSE NUM
                    int reversed = 0;
                    int temp = num;
                    while (temp > 0) {
                        int digit = temp % 10;
                        reversed = reversed * 10 + digit;
                        temp /= 10;
                    }

                    // CHECK IF REVERSED NUM IS PRIME
                    boolean reverseIsPrime = true;
                    for (int i = 2; i <= Math.sqrt(reversed); i++) {
                        if (reversed % i == 0) {
                            reverseIsPrime = false;
                            break;
                        }
                    }

                    //CHECK IF EMIRP AND PRIME OR PRIME ONLY
                    if (reverseIsPrime) {
                        System.out.println(num + " is both prime and emirp.");
                    } else {
                        System.out.println(num + " is prime only.");
                    }
                }
            }

            System.out.print("Do you wish to to continue (Y/N): ");
            response = Character.toUpperCase(scan.next().charAt(0));
        } while (response == 'Y');
        System.out.println("TERMINATING PROGRAM!!!");
        scan.close();

    }
}
