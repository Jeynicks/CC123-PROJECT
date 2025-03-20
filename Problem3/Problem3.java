import java.util.Scanner;

public class Problem3 {
    public static Scanner scan =  new Scanner(System.in);
    public static void main(String[] args) {

        //INPUT VARIABLES
        String accountNumber;
        char serviceCode = ' ';
        char response = ' ';
        int minsUsed;

        //CALCULATED VARIABLES
        double baseFee;
        double extraCharges, dayCharges, nightCharges;
        int dayMins, nightMins;
        double amtDue;

        do{
            System.out.print("Enter Account Number: ");
            accountNumber = scan.next();

            System.out.print("Enter Service Code 'P' for premium and 'R' for regular: ");
            serviceCode = Character.toUpperCase(scan.next().charAt(0));

            if(serviceCode == 'R'){
                baseFee = 10.00; //FLAT CHARGE
                extraCharges = 0.20; //CHARGES PER MINUTE IF minsUsed > 50

                System.out.print("Enter Minutes Used:  ");
                minsUsed = scan.nextInt();
                amtDue = minsUsed > 50 ? baseFee + (minsUsed - 50) * extraCharges : baseFee; //USING TERNARY FOR SIMPLE IF ELSE
                System.out.printf("Account Number: %s\n" +
                                  "Service Type: Regular\n" +
                                  "Total Minutes Used: %d\n" +
                                  "Amount Due: $%.2f\n", accountNumber, minsUsed, amtDue);
            }
            else if(serviceCode == 'P'){
                baseFee = 25.00; //FLAT CHARGE

                System.out.print("Enter Minutes Used (DAYTIME: 6:00 a.m. to 6:00 p.m.): ");
                dayMins = scan.nextInt();
                System.out.print("Enter Minutes Used (NIGHTTIME: 6:00 p.m. to 6:00 a.m.): ");
                nightMins = scan.nextInt();

                //TERNARY FOR CHECKING CHARGES
                dayCharges = dayMins > 75 ? (dayMins - 75) * 0.10 : 0.0;
                nightCharges = nightMins > 100 ? (nightMins - 100) * 0.05 : 0.0;

                amtDue = baseFee + dayCharges + nightCharges; // CALCULATE AMOUNT DUE

                System.out.printf("Account Number: %s\n" +
                                  "Service Type: Premium\n" +
                                  "Total Minutes Used (DAYTIME): %d\n" +
                                  "Total Minutes Used (NIGHTTIME): %d\n" +
                                  "Amount Due: $%.2f\n", accountNumber, dayMins, nightMins, amtDue);

            }
            else{
                System.out.print("Invalid Input do you wish to try again? (Y/N): ");
                response = Character.toUpperCase(scan.next().charAt(0));
            }

            System.out.print("Do you wish to calculate again? (Y/N): ");
            response = Character.toUpperCase(scan.next().charAt(0));

        }while(response != 'N');
        System.out.println("TERMINATING PROGRAM!!!");
        scan.close();
    }
}
