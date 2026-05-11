import Services.*;
import Utiles.MenuMassage;

import java.util.Scanner;

public class MainApp {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

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
                        // Calling the Patient Menu from MenuMassage class
                        System.out.print(MenuMassage.PATIENT_MENU_MESSAGE);
                        System.out.print("Enter your choice: ");

                        Integer patientOption = Integer.parseInt(input.nextLine());
                        patientMenuContinue = patientService.handlePatientsMenu(patientOption);
                    }
                }
                case 2 -> {
                    Boolean doctorMenuContinue = true;
                    while (doctorMenuContinue) {
                        System.out.println("*********** Doctor Menu ***********");
                        System.out.print(MenuMassage.DOCTOR_MENU_MESSAGE);
                        Integer doctorOption = Integer.parseInt(input.nextLine());
                        doctorMenuContinue = doctorService.handleDoctorMenu(doctorOption);
                    }
                }
                case 3 -> {
                    Boolean nurseMenuContinue = true;
                    while (nurseMenuContinue) {
                        System.out.println("*********** Nurse Menu ***********");
                        System.out.print(MenuMassage.NURSE_MENU_MESSAGE);
                        Integer nurseOption = Integer.parseInt(input.nextLine());
                        nurseMenuContinue = nurseService.handleNurseMenu(nurseOption);
                    }
                }
                case 4 -> {
                    Boolean recordMenuContinue = true;
                    while (recordMenuContinue) {
                        System.out.println("*********** Medical Record Menu ***********");
                        System.out.print(MenuMassage.MEDICAL_RECORD_MENU_MESSAGE);
                        Integer recordOption = Integer.parseInt(input.nextLine());
                        recordMenuContinue = medicalRecordService.handleMedicalRecordMenu(recordOption);
                    }
                }
                case 5 -> {
                    Boolean deptMenuContinue = true;
                    while (deptMenuContinue) {
                        System.out.println("*********** Department Menu ***********");
                        System.out.print(MenuMassage.APPOINTMENT_MENU_MESSAGE);
                        Integer deptOption = Integer.parseInt(input.nextLine());
                        deptMenuContinue = departmentService.handleDepartmentMenu(deptOption);
                    }
                }
                case 6 -> {
                    Boolean appointmentMenuContinue = true;
                    while (appointmentMenuContinue) {
                        System.out.println("*********** Appointment Menu ***********");
                        System.out.print(MenuMassage.DEPARTMENT_MENU_MESSAGE);
                        Integer appointmentOption = Integer.parseInt(input.nextLine());
                        appointmentMenuContinue = appointmentService.handleAppointmentMenu(appointmentOption);
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