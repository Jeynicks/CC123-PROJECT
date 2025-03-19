import java.util.Scanner;

public class Problem8 {
    public static Scanner scan =  new Scanner(System.in);
    public static void main(String[] args) {
        final char ADDITION = '+';
        final char SUBTRACTION = '-';
        final char MULTIPLICATION = '*';
        final char DIVISION = '/';

        double num1, num2, num3, temp;
        double numerator, multiplier, result;
        char operator1, operator2;

        System.out.print("Enter 3 Decimal Numbers and 2 Arithmetic Operator(+, -, *, /)\n");
        while(true){
            System.out.print("Enter 1st Decimal Number: ");
            num1 = scan.nextDouble();
            System.out.print("Enter 2nd Decimal Number: ");
            num2 = scan.nextDouble();
            System.out.print("Enter 3rd Decimal Number: ");
            num3 = scan.nextDouble();

            System.out.print("Enter 1st Arithmetic Operator: ");
            operator1 = scan.next().charAt(0);
            System.out.print("Enter 2nd Arithmetic Operator: ");
            operator2 = scan.next().charAt(0);

            switch (operator2){
                case ADDITION:
                    temp = num2 + num3;
                    break;
                case SUBTRACTION:
                    temp = num2 - num3;
                    break;
                case MULTIPLICATION:
                    temp = num2 * num3;
                    break;
                case DIVISION:
                    if (num3 == 0){
                        System.out.print("Invalid denominator. Try Again!\n");
                        continue;
                    }
                    temp = num2 / num3;
                    break;
                default:
                    System.out.println("Invalid 2nd operator. Terminating Program!!!");
                    return;

            }

            switch (operator1){
                case ADDITION:
                    result = num1 + temp;
                    break;
                case SUBTRACTION:
                    result = num1 - temp;
                    break;
                case MULTIPLICATION:
                    result = num1 * temp;
                    break;
                case DIVISION:
                    result = num1 / temp;
                    break;
                default:
                    System.out.println("Invalid 1st operator. Terminating Program!!!");
                    return;

            }
            System.out.printf("%.2f %c %.2f %c %.2f = %.2f", num1, operator1, num2, operator2, num3, result);
            return;

        }
    }
}
