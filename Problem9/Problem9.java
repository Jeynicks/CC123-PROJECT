import java.util.Scanner;

public class Problem9 {
    public static Scanner scan =  new Scanner(System.in);
    public static void main(String[] args) {

        final int SAVINGS_SERVICE_CHARGE = 10;
        final int CHECKING_SERVICE_CHARGE = 25;

        double interest = 0;

        int accountNumber;
        char accountType;
        double minimumBalance, currentBalance, newBalance, excess;
        String message = " ";
        String strAccType;

        //FOR LOOP SO THAT IT ONLY RUN 5 TIMES
        for(int x = 0; x < 5; x++){
            //USER INPUT
            System.out.print("Enter account number: ");
            accountNumber = scan.nextInt();
            System.out.print("Enter account type (S for savings, C for checking: ");
            accountType = Character.toUpperCase(scan.next().charAt(0));
            System.out.print("Enter Minimum Balance: ");
            minimumBalance = scan.nextInt();
            System.out.print("Enter Current Balance: ");
            currentBalance = scan.nextInt();

            newBalance = currentBalance;

            if(currentBalance < minimumBalance){
                switch (accountType){
                    case 'S':
                        newBalance -= SAVINGS_SERVICE_CHARGE;
                        message = "Service charge applied: $10.00";
                        strAccType = "Savings";
                        break;
                    case 'C':
                        newBalance -= CHECKING_SERVICE_CHARGE;
                        message = "Service charge applied: $25.00";
                        strAccType = "Checking";
                        break;
                    default:
                        System.out.println("Invalid Account Type");
                        continue;
                }
            }
            else{
                switch (accountType){
                    case 'S':
                        interest = currentBalance * 0.04; //GET INTEREST 4%
                        newBalance += interest;
                        message = String.format("Interest earned: $%.2f", interest);
                        strAccType = "Savings";
                        break;
                    case 'C':
                        excess = currentBalance - minimumBalance;
                        if (excess <= 5000) interest = currentBalance * 0.03; //3% IF EXCESS <= 5000
                        else interest = currentBalance * 0.05; //5% IF EXCESS > 5000
                        newBalance += interest;
                        message = String.format("Interest earned: $%.2f", interest);
                        strAccType = "Checking";
                        break;
                    default:
                        System.out.println("Invalid Account Type");
                        continue;
                }
            }

            System.out.printf("Account Number: %d\n" +
                              "Account Type: %s\n" +
                              "Balance: $%.2f \n" +
                              "%s\n",accountNumber, strAccType, newBalance, message);

        }
        scan.close();
    }
}
