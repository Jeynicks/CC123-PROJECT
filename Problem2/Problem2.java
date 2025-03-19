import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        // FILE FOR INPUT AND OUTPUT
        File inputFile = new File("src/EmployeeData.txt");
        File outputFile = new File("src/EmployeeOutput.dat");

        try {
            Scanner scanner = new Scanner(inputFile);
            PrintWriter writer = new PrintWriter(outputFile);

            // READS ALL THE INPUT IN EmployeeData.Txt
            while (scanner.hasNext()) {
                // GET DATA USING INDIVIDUAL CALLSS
                String lastName = scanner.next();
                String firstName = scanner.next();
                double currentSalary = scanner.nextDouble();
                char rank = scanner.next().charAt(0);

                // CALCULATE UPDATED SALARY
                double increasePercentage;
                switch (rank) {
                    case 'A':
                        increasePercentage = 1.10;
                        break;
                    case 'B':
                        increasePercentage = 1.085;
                        break;
                    case 'C':
                        increasePercentage = 1.075;
                        break;
                    case 'D':
                        increasePercentage = 1.05;
                        break;
                    case 'E':
                        increasePercentage = 1.04;
                        break;
                    default:
                        increasePercentage = 1.0;
                        System.out.println("Invalid rank for " + firstName + " " + lastName);
                }
                double updatedSalary = currentSalary * increasePercentage;

                // OUTPUT
                writer.printf("Full Name: %s %s\nUpdated Salary: Php %.2f%n", firstName, lastName, updatedSalary);
            }

            System.out.println("Output: Check EmployeeOutput.dat");
            scanner.close();
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: Could not find EmployeeData.txt or issue with EmployeeOutput.dat.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
