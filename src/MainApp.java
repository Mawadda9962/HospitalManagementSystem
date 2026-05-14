import Services.*;
import Utiles.InputHandler;
import Utiles.MenuMassage;
import jdk.jshell.execution.Util;

import java.util.Scanner;

public class MainApp {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Utiles.SampleDataTesting.Testing();

        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        NurseService nurseService = new NurseService();
        MedicalRecordService medicalRecordService = new MedicalRecordService();
        DepartmentService departmentService = new DepartmentService();
        AppointmentService appointmentService = new AppointmentService();


        Boolean mainMenuContinue = true;
        while (mainMenuContinue) {
            System.out.println("********** Hospital Management System **********");
            System.out.print(MenuMassage.MAIN_MENU_MESSAGE);
            System.out.print("Select an option: ");

            Integer option = Integer.parseInt(input.nextLine());

            switch (option) {
                case 1 -> {
                    Boolean patientMenuContinue = true;
                    while (patientMenuContinue) {
                        System.out.println(" *********** Patient Menu ***********");
                        System.out.print(MenuMassage.PATIENT_MENU_MESSAGE);

                        Integer patientOption = InputHandler.getIntInput("Enter your choice: ");
                        patientMenuContinue = patientService.handlePatientsMenu(patientOption);
                    }
                }
                case 2 -> {
                    Boolean doctorMenuContinue = true;
                    while (doctorMenuContinue) {
                        System.out.println("*********** Doctor Menu ***********");
                        System.out.print(MenuMassage.DOCTOR_MENU_MESSAGE);
                        Integer doctorOption = InputHandler.getIntInput("Enter your choice");
                        doctorMenuContinue = doctorService.handleDoctorMenu(doctorOption);
                    }
                }
                case 3 -> {
                    Boolean nurseMenuContinue = true;
                    while (nurseMenuContinue) {
                        System.out.println("*********** Nurse Menu ***********");
                        System.out.print(MenuMassage.NURSE_MENU_MESSAGE);
                        Integer nurseOption = InputHandler.getIntInput("Enter your choice");
                        nurseMenuContinue = nurseService.handleNurseMenu(nurseOption);
                    }
                }
                case 4 -> {
                    Boolean recordMenuContinue = true;
                    while (recordMenuContinue) {
                        System.out.println("*********** Medical Record Menu ***********");
                        System.out.print(MenuMassage.MEDICAL_RECORD_MENU_MESSAGE);
                        Integer recordOption = InputHandler.getIntInput("Enter your Choice");
                        recordMenuContinue = medicalRecordService.handleMedicalRecordMenu(recordOption);
                    }
                }
                case 5 -> {
                    Boolean appointmentMenuContinue = true;
                    while (appointmentMenuContinue) {
                        System.out.println("*********** Appointment Menu ***********");
                        System.out.print(MenuMassage.APPOINTMENT_MENU_MESSAGE);
                        Integer appointmentOption = InputHandler.getIntInput("Enter your Choice");
                        appointmentMenuContinue = appointmentService.handleAppointmentMenu(appointmentOption);
                    }
                }

                case 6 -> {
                    Boolean deptMenuContinue = true;
                    while (deptMenuContinue) {
                        System.out.println("*********** Department Menu ***********");
                        System.out.print(MenuMassage.DEPARTMENT_MENU_MESSAGE);
                        Integer deptOption = InputHandler.getIntInput("Enter your Choice");
                        deptMenuContinue = departmentService.handleDepartmentMenu(deptOption);
                    }
                }
                case 7 -> {
                    System.out.println("Exiting System...");
                    mainMenuContinue = false;
                }
                default -> System.out.println("Select a choice from the list.");
            }
        }
    }
}