import java.util.Scanner;

public class Problem8 {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        final char ADDITION = '+';
        final char SUBTRACTION = '-';
        final char MULTIPLICATION = '*';
        final char DIVISION = '/';

        double num1, num2, num3, temp, result;
        char operator1, operator2;


        System.out.print("Enter 3 Decimal Numbers and 2 Arithmetic Operators (+, -, *, /)\n");
        while (true) {
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

            if (operator1 != ADDITION && operator1 != SUBTRACTION && operator1 != MULTIPLICATION && operator1 != DIVISION ||
                    operator2 != ADDITION && operator2 != SUBTRACTION && operator2 != MULTIPLICATION && operator2 != DIVISION) {
                System.out.println("Invalid operator. Try Again!");
                continue;
            }
            if ((operator1 == '/' && num2 == 0) || (operator2 == '/' && num3 == 0)) {
                System.out.print("Invalid denominator. Try Again!\n");
                continue;
            }

            // PEMDAS LOGIC
            if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-')) {
                switch (operator1) {
                    case MULTIPLICATION:
                        temp = num1 * num2;
                        break;
                    case DIVISION:
                        temp = num1 / num2;
                        break;
                    default:
                        temp = 0;
                }
                switch (operator2) {
                    case ADDITION:
                        result = temp + num3;
                        break;
                    case SUBTRACTION:
                        result = temp - num3;
                        break;
                    default:
                        result = 0;
                }
            } else if (operator2 == '*' || operator2 == '/') {
                switch (operator2) {
                    case MULTIPLICATION:
                        temp = num2 * num3;
                        break;
                    case DIVISION:
                        temp = num2 / num3;
                        break;
                    default:
                        temp = 0;
                }
                switch (operator1) {
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
                        result = 0;
                }
            } else {
                switch (operator1) {
                    case ADDITION:
                        temp = num1 + num2;
                        break;
                    case SUBTRACTION:
                        temp = num1 - num2;
                        break;
                    default:
                        temp = 0;
                }
                switch (operator2) {
                    case ADDITION:
                        result = temp + num3;
                        break;
                    case SUBTRACTION:
                        result = temp - num3;
                        break;
                    default:
                        result = 0;
                }
            }

            System.out.printf("%.2f %c %.2f %c %.2f = %.2f\n", num1, operator1, num2, operator2, num3, result);
            return;
        }
    }
}