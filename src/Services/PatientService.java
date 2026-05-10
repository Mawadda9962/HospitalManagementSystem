package Services;

import Entities.patient;
import Utiles.Constant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientService {
    static Scanner scanner = new Scanner(System.in);
    static List<patient> patients = new ArrayList<>();

    public void addPatient() {
        System.out.println("********** Added New Patient ********");
        System.out.println("Enter Patient id :");
        String id = scanner.nextLine();

        patient p = getPatientById(id);
        if (p != null) {
            System.out.println("ID already exit ");
            return;
        }

        System.out.print("Enter First Name: ");
        String fname = scanner.nextLine();

        System.out.print("Enter last Name: ");
        String lname = scanner.nextLine();

        System.out.println("Enter date Of Birth (YYYY-MM-DD):");
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Hospital Patient ID: ");
        String pId = scanner.nextLine();

        System.out.print("Enter Blood Group: ");
        String bloodGroup = scanner.nextLine();

        System.out.print("Enter Emergency Contact: ");
        String emergencyContact = scanner.nextLine();

        System.out.print("Enter Insurance ID: ");
        String insuranceId = scanner.nextLine();

        // Initialize lists and automatic data
        LocalDate registrationDate = LocalDate.now();
        List<String> allergies = new ArrayList<>();
        List<String> medicalRecords = new ArrayList<>();
        List<String> appointments = new ArrayList<>();


        patient newPatient = new patient(
                id, fname, lname, dateOfBirth.toString(), gender, phoneNumber, email, address,
                insuranceId, pId, bloodGroup, new ArrayList<>(), registrationDate,
                medicalRecords, appointments
        );

        // Add the newly created object to the list
        patients.add(newPatient);
        System.out.println(Constant.PATIENT_ADDED_SUCCESSFULLY);
    }

    public patient getPatientById(String patientId) {
        for (patient p : patients) {
            // Note: Use getPatientId() if you are searching by hospital ID
            // or getId() if searching by the base Person ID.
            if (p.getPatientId().equals(patientId)) {
                return p;
            }
        }
        return null;
    }

    public void editPatient(String patientId, patient updatedPatient) {
        if (patientId != null) {
            for (int i = 0; i < patients.size(); i++) {
                if (patients.get(i).getPatientId().equals(patientId)) {
                    patients.set(i, updatedPatient);
                    System.out.println(Constant.PATIENT_UPDATED_SUCCESSFULLY);
                    return;
                }
            }
        }
        System.out.println("Patient not found for update");
    }

    public void removePatient(String patientId) {
        patient p = getPatientById(patientId);
        if (p != null) {
            patients.remove(p);
            System.out.println(Constant.PATIENT_REMOVE_SUCCESSFULLY);
        } else {
            System.out.println("Patient not found");
        }
    }

    public List<patient> searchPatientsByName(String name) {
        System.out.println("Search Results:");
        List<patient> foundPatients = new ArrayList<>();
        for (patient p : patients) {
            if (p.getFirstName().toLowerCase().contains(name.toLowerCase()) ||
                    p.getLastName().toLowerCase().contains(name.toLowerCase())) {
                p.displayInfo();
                foundPatients.add(p);
            }
        }
        return foundPatients;
    }

    public void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients in the system.");
            return;
        }
        System.out.println("===== All Patient =====");
        for (patient p : patients) {
            p.displayInfo();
        }
    }
}