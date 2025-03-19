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

            //READS ALL THE INPUT IN EmployeeData.Txt
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\s+"); // SPLIT WITH WHITESPACE

                // GET DATA
                String lastName = parts[0];
                String firstName = parts[1];
                double currentSalary = Double.parseDouble(parts[2]);
                char rank = parts[3].charAt(0);

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
                writer.printf("%s %s %.2f%n", firstName, lastName, updatedSalary);

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
