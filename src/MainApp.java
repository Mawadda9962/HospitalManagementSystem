import Services.PatientService;
import Utiles.MenuMassage;

import java.util.Scanner;

public class MainApp {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        PatientService patientService = new PatientService();

        Boolean mainMenuContinue = true;

        while (mainMenuContinue) {

            System.out.println("*********** Main Menu ***********");
            System.out.println(MenuMassage.MAIN_MENU_MESSAGE);

            Integer option = input.nextInt();
            input.nextLine();

            switch (option) {

                case 1 -> {
                    Boolean patientMenuContinue = true;
                    while (patientMenuContinue) {

                        System.out.println("*********** Patient Menu ***********");
                        System.out.println(MenuMassage.PATIENT_MENU_MESSAGE);

                        Integer patientOption = input.nextInt();
                        input.nextLine();

                        switch (patientOption) {

                            case 1 -> {
                                patientService.addPatient();
                            }
                            case 2 -> {


                            }
                            case 3 -> {
                                System.out.print("Enter Patient ID To Remove: ");
                                String patientId = input.nextLine();

                                patientService.removePatient(patientId);
                            }

                            case 4 -> {
                                System.out.print("Enter Patient ID: ");
                                String patientId = input.nextLine();

                                if (patientService.getPatientById(patientId) != null) {

                                    patientService.getPatientById(patientId).displayInfo();

                                } else {
                                    System.out.println("Patient Not Found.");
                                }
                            }
                            case 5 -> {
                                System.out.print("Enter Patient Name: ");
                                String patientName = input.nextLine();

                                patientService.searchPatientsByName(patientName);
                            }
                            case 6 -> {
                                patientService.displayAllPatients();
                            }
                            case 7 -> {
                                System.out.println("Returning To Main Menu...");
                                patientMenuContinue = false;
                            }
                            default -> {
                                System.out.println("Select A Valid Choice");
                            }
                        }
                    }
                }

                case 2 -> {
                    System.out.println("System Closed.");
                    mainMenuContinue = false;
                }

                default -> {
                    System.out.println("Select A Valid Choice");
                }
            }
        }
    }
}