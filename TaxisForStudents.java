import java.util.Scanner;

public class TaxisForStudents {
    static final int MINIMUM_STUDENTS = 1;
    static final int STUDENTS_PER_TAXI = 10;
    static final int DONATION_PER_TAXI = 200;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = getNumberOfStudents(scanner, "Enter the number of students (positive integer): ", MINIMUM_STUDENTS, "Please enter a positive integer.");
        scanner.close();
        processAndDisplayResults(numberOfStudents);
    }

    /**
     * This method validates that the user enters a positive integer number of students.
     *
     * @param scanner The scanner object used for reading input.
     * @param prompt The message to display to the user.
     * @param minValue The minimum acceptable value for the input.
     * @param errorMessage The error message displayed when the input is below the minimum.
     * @return The validated integer input representing the number of students.
     */
    private static int getNumberOfStudents(Scanner scanner, String prompt, int minValue, String errorMessage) {
        int inputValue;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                inputValue = scanner.nextInt();
                if (inputValue >= minValue) {
                    return inputValue;
                } else {
                    System.out.println(errorMessage);
                }
            } else {
                System.out.println(errorMessage);
                scanner.next();
            }
        }
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
