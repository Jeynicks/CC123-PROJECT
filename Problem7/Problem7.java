import java.util.Scanner;

public class Problem7 {
    public static Scanner scan =  new Scanner(System.in);
    public static void main(String[] args) {

        int townA, townB;
        double townAGrowth, townBGrowth;
        int years = 0;
        char response = ' ';

        do{
            //USER INPUT
            System.out.print("Enter population of Town A: ");
            townA = scan.nextInt();
            System.out.print("Enter growth rate of Town A (as percentage): ");
            townAGrowth = scan.nextDouble();

            System.out.print("Enter population of Town B: ");
            townB = scan.nextInt();
            System.out.print("Enter growth rate of Town B (as percentage): ");
            townBGrowth = scan.nextDouble();

            //CONVERT GROWTH INTO DECIMAL FOOR CALCULATION
            townAGrowth = townAGrowth / 100;
            townBGrowth = townBGrowth / 100;

            while(townA < townB){
                years++;
                townA = (int) (townA * (1 + townAGrowth));
                townB = (int) (townB * (1 + townBGrowth));

                if(townA >= townB) break; //IF TOWN A IS GREATER THAN OR EQUAL TO TOWN B THEN LOOP WILL WILL BREAK
            }
            System.out.printf("After %d years: \n" +
                    "Town A population: %d\n" +
                    "Town B population: %d\n", years, townA, townB);
            System.out.print("Do you wish to calculate again? (Y/N): ");
            response = Character.toUpperCase(scan.next().charAt(0));
        }
        while(response != 'N');

        scan.close();


    }
}
