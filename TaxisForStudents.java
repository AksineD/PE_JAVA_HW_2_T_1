import java.util.Scanner;

public class TaxisForStudents {

    // Class constants
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
     * Prompts the user to enter the number of students and validates the input.
     * Ensures the input is a positive integer, displaying an error message for invalid attempts.
     *
     * @param scanner The Scanner object used for input.
     * @param prompt The message used to prompt the user.
     * @param minValue The minimum valid value for the input.
     * @param errorMessage The error message displayed for invalid input.
     * @return The validated number of students entered by the user.
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

    /**
     * Calculates the number of full taxis required to accommodate the students.
     *
     * @param students The total number of students.
     * @return The number of full taxis required.
     */
    private static int calculateFullTaxis(int students) {
        return students / STUDENTS_PER_TAXI;
    }

    /**
     * Calculates the number of students left who cannot be accommodated in full taxis.
     *
     * @param students The total number of students.
     * @return The number of remaining students.
     */
    private static int calculateRemainingStudents(int students) {
        return students % STUDENTS_PER_TAXI;
    }

    /**
     * Calculates the total donation amount based on the number of taxis used.
     *
     * @param taxis The number of full taxis.
     * @return The total donation amount.
     */
    private static int calculateTotalDonation(int taxis) {
        return taxis * DONATION_PER_TAXI;
    }

    /**
     * Displays the results: number of full taxis, remaining students, and total donation.
     *
     * @param taxis The number of full taxis.
     * @param remaining The number of remaining students.
     * @param donation The total calculated donation.
     */
    private static void displayResults(int taxis, int remaining, int donation) {
        System.out.println("Number of full taxis: " + taxis);
        System.out.println("Number of remaining students: " + remaining);
        System.out.println("Total donation: " + donation + " ₪");
    }

    /**
     * Handles the processing of student data, including calculations for required taxis,
     * remaining students, and total donation, and displays the results.
     *
     * @param students The total number of students.
     */
    private static void processAndDisplayResults(int students) {
        int fullTaxis = calculateFullTaxis(students);
        int remainingStudents = calculateRemainingStudents(students);
        int totalDonation = calculateTotalDonation(fullTaxis);
        displayResults(fullTaxis, remainingStudents, totalDonation);
    }
}
