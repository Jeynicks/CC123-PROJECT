import  java.util.Scanner;
public class Problem4 {
    public static Scanner scan =  new Scanner(System.in);
    public static void main(String[] args) {

        char response = ' ', choice;
        int num1, num2, sum = 0, count = 0, factorial = 1, squares = 1;
        double average;
        char firstLetter, secondLetter;

        do {
            //USER CHOICES
            System.out.print("-----M E N U-----\n" +
                    "A. ODD NUMBERS\n" +
                    "B. EVEN NUMBERS\n" +
                    "C. FACTORIAL\n" +
                    "D. SUM OF SQUARES\n" +
                    "E. UPPERCASE AND LOWERCASE\n" +
                    "F. TERMINATE\n" +
                    "Enter letter of your choice: ");
            choice = Character.toUpperCase(scan.next().charAt(0));
            //WHILE TRUE SO THAT IT ACCEPTS THE CORRECT INPUT
           while(true){
               switch (choice){
                   case 'A':
                       System.out.print("Enter first number: ");
                       num1 = scan.nextInt();
                       System.out.print("Enter second number (must be greater than first number): ");
                       num2 = scan.nextInt();
                       if (num1 > num2) continue;
                       for (int x = num1; x <= num2; x++){
                           if (x % 2 == 0) continue;
                           System.out.println(x+" is Odd");
                       }
                       break;
                   case 'B':
                       System.out.print("Enter first number: ");
                       num1 = scan.nextInt();
                       System.out.print("Enter second number (must be greater than first number): ");
                       num2 = scan.nextInt();
                       if (num1 > num2) continue;
                       for (int x = num1; x <= num2; x++){
                           if (x % 2 == 1) continue;
                           count += 1;
                           sum += x;
                           System.out.println(x+" is Even");
                       }
                           average = (double) sum / count;
                           System.out.printf("Sum of all the even integers is: %d\n" +
                                   "Average of all the even integers: %.2f\n", sum, average);
                       break;
                   case 'C':
                       System.out.print("Enter a positive number to find its factorial: ");
                       num1 = scan.nextInt();
                       if(num1 < 0) continue;
                       for (int x = num1; x >= 1; x--) factorial *= x;
                       System.out.printf("Factorial of %d is: %d \n",num1, factorial);

                       break;
                   case 'D':
                       System.out.print("Enter any Integer number: ");
                       num1 = scan.nextInt();
                       if (num1 < 0) num1 = num1 * -1;
                       for (int x = 1; x <= num1; x++){
                           squares = x * x;
                           sum += squares;
                       }
                       System.out.printf("Sum of the squares of %d is: %d \n", num1, sum);
                       break;
                   case 'E':
                       System.out.print("Enter first letter: ");
                       firstLetter = Character.toLowerCase(scan.next().charAt(0));
                       System.out.print("Enter second letter (must be greater than first letter): ");
                       secondLetter = Character.toLowerCase(scan.next().charAt(0));

                       if (firstLetter > secondLetter) continue;
                       for(char letter = firstLetter; letter <= secondLetter; letter++){
                           System.out.println(letter+" "+Character.toUpperCase(letter));
                       }
                       break;
                   case 'F':
                       System.out.println("TERMINATING PROGRAM!!!");
                       return;
               }
               System.out.print("Do you wish to go back to menu (Y/N): ");
               response = Character.toUpperCase(scan.next().charAt(0));
               break;
           }
        } while (response != 'N');
        System.out.println("TERMINATING PROGRAM!!!");
    }
}
