import java.util.Scanner;

public class TaxisForStudents {
    static final int STUDENTS_PER_TAXI = 10;
    static final int DONATION_PER_TAXI = 200;

    public static void main(String[] args) {

        int numberOfStudents = getNumberOfStudents();
        processAndDisplayResults(numberOfStudents);
    }

    private static int getNumberOfStudents() {
        final int MINIMUM_STUDENTS = 1;
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents;
        do {
            System.out.print("Enter the number of students (positive integer): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. \nPlease enter a positive integer: ");
                scanner.next();
            }
            numberOfStudents = scanner.nextInt();
        } while (numberOfStudents < MINIMUM_STUDENTS);
        scanner.close();
        return numberOfStudents;
    }

    private static int calculateFullTaxis(int students) {
        return students / STUDENTS_PER_TAXI;
    }

    private static int calculateRemainingStudents(int students) {
        return students % STUDENTS_PER_TAXI;
    }

    private static int calculateTotalDonation(int taxis) {
        return taxis * DONATION_PER_TAXI;
    }

    private static void displayResults(int taxis, int remaining, int donation) {
        System.out.println("Number of full taxis: " + taxis);
        System.out.println("Number of remaining students: " + remaining);
        System.out.println("Total donation: " + donation + " ₪");
    }

    private static void processAndDisplayResults(int students) {
        int fullTaxis = calculateFullTaxis(students);
        int remainingStudents = calculateRemainingStudents(students);
        int totalDonation = calculateTotalDonation(fullTaxis);
        displayResults(fullTaxis, remainingStudents, totalDonation);
    }
}
