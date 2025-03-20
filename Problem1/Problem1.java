import java.util.Scanner;
public class Problem1 {

    public static Scanner scan =  new Scanner(System.in);
    public static void main(String[] args) {

        //PAY RATE VARIABLES
        final double REGULAR_PAY = 68.75;
        double OVERTIME_PAY = REGULAR_PAY * 1.5;
        double deductHours;
        //TAX VARIABLES
        final double SOCIAL_SECURITY_TAX = 0.07;
        final double FEDERAL_INCOME_TAX = 0.11;
        final double STATE_INCOME_TAX = 0.06;
        final int UNION_DUES = 100;
        int HEALTH_INSURANCE = 0;

        //USER INPUT VARIABLES
        double hoursWorked;
        int dependents;

        //OUTPUT VARIABLES
        double grossPay;
        double totalDeductions = 0;
        double netPay;

        //User Input
        System.out.print("Enter hours worked: ");
        hoursWorked = scan.nextDouble();

        //CHECK IF OVERTIME
        if (hoursWorked < 40){
            grossPay = hoursWorked * REGULAR_PAY;
        }
        else {
            deductHours =  hoursWorked - 40;
            grossPay = 40 * REGULAR_PAY + (deductHours * OVERTIME_PAY);
        }
        System.out.print("Enter dependents: ");
        dependents = scan.nextInt();

        //CHECK DEPENDENTS
        if (dependents < 3){
            totalDeductions += (grossPay * SOCIAL_SECURITY_TAX);
            totalDeductions += (grossPay * FEDERAL_INCOME_TAX);
            totalDeductions += (grossPay * STATE_INCOME_TAX);
            totalDeductions += UNION_DUES;
        }
        else{
            totalDeductions += (grossPay * SOCIAL_SECURITY_TAX);
            totalDeductions += (grossPay * FEDERAL_INCOME_TAX);
            totalDeductions += (grossPay * STATE_INCOME_TAX);
            totalDeductions += UNION_DUES;
            HEALTH_INSURANCE = 350;
            totalDeductions += HEALTH_INSURANCE;
        }

        netPay = grossPay - totalDeductions;

        //OUTPUT
        System.out.println("WEEKLY PAY SUMMARY");
        System.out.println("------------------");
        System.out.printf("Gross Pay: Php %.2f\n" +
                          "Social Security Tax: Php %.2f\n" +
                          "Federal Income Tax: Php %.2f\n" +
                          "State Income Tax: Php %.2f\n" +
                          "Union Dues: Php %d.00\n" +
                          "Health Insurance: Php %d.00\n" +
                          "Total Deductions: Php %.2f\n" +
                          ".\n" +
                          "Net Pay: Php %.2f\n" +
                          "------------------", grossPay, (grossPay * SOCIAL_SECURITY_TAX), (grossPay * FEDERAL_INCOME_TAX), (grossPay * STATE_INCOME_TAX), UNION_DUES, HEALTH_INSURANCE, totalDeductions, netPay);
        scan.close();
    }
}