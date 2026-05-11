package Services;

import Services.PatientService;
import java.util.Scanner;

public class MainApp {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize the service
        PatientService patientService = new PatientService();

        boolean mainMenuContinue = true;

        while (mainMenuContinue) {
            System.out.println("\n********** Hospital Management System **********");
            System.out.println("1. Patient Management Menu");
            System.out.println("2. Exit");
            System.out.print("Select an option: ");

            // Use nextLine() and parse to avoid skip issues after input.nextInt()
            String choice = input.nextLine();
            int option;

            try {
                option = Integer.parseInt(choice);
            } catch (NumberFormatException e) {
                option = 0; // Default to invalid
            }

            switch (option) {
                case 1 -> {
                    boolean patientMenuContinue = true;
                    while (patientMenuContinue) {
                        System.out.println("\n*********** Patient Menu ***********");
                        System.out.println("1. Add New Patient");
                        System.out.println("2. Edit Patient");
                        System.out.println("3. Remove Patient");
                        System.out.println("4. Search Patient by Name");
                        System.out.println("5. Display All Patients");
                        System.out.println("6. Back to Main Menu");
                        System.out.print("Enter your choice: ");

                        String subChoiceStr = input.nextLine();
                        int patientOption;
                        try {
                            patientOption = Integer.parseInt(subChoiceStr);
                        } catch (NumberFormatException e) {
                            patientOption = 0;
                        }

                        // Calling your handlePersonMenu logic
                        patientMenuContinue = patientService.handlePersonMenu(patientOption);
                    }
                }
                case 2 -> {
                    System.out.println("Exiting System...");
                    mainMenuContinue = false;
                }
                default -> System.out.println("Select a valid choice from the list (1-2).");
            }
        }
    }
}