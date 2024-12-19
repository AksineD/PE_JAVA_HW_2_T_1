import java.util.Scanner;

public class TaxisForStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        // Calculate the number of full taxis (each can hold 10 students)
        int fullTaxis = numberOfStudents / 10;

        // Calculate the number of students remaining (not in a full taxi)
        int remainingStudents = numberOfStudents % 10;

        // Calculate the total donation (200 ₪ per full taxi)
        int totalDonation = fullTaxis * 200;

        // Print the results
        System.out.println("Number of full taxis: " + fullTaxis);
        System.out.println("Number of remaining students: " + remainingStudents);
        System.out.println("Total donation: " + totalDonation + " ₪");

        scanner.close();
    }
}