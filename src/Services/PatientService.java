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
        System.out.println("********** Added New Patient =====");
        System.out.println("Enter Patient id :");
        String id = scanner.nextLine();

        patient p = getPatientById(id);
        if (p != null) {
            System.out.println("ID already exit ");
            return; // Stop execution if ID exists
        }

        System.out.print("Enter First Name: ");
        String fname = scanner.nextLine();

        System.out.print("Enter last Name: ");
        String lname = scanner.nextLine();

        System.out.println("Enter date Of Birth (YYYY-MM-DD):");
        // We use LocalDate.parse to turn the String input into a LocalDate object
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());

        // Creating the patient object using the collected data
        // Note: Make sure your Patient entity constructor matches this order
        patient patient = new patient(id, fname, lname, dateOfBirth);

        patients.add(patient);
        System.out.println(Constant.PATIENT_ADDED_SUCCESSFULLY);
    }

    public patient getPatientById(String patientId) {
        for (patient p : patients) {
            if (p.getId().equals(patientId)) {
                return p;
            }
        }
        return null;
    }

    public void editPatient(String patientId, patient updatedPatient) {
        if (patientId != null) {
            for (int i = 0; i < patients.size(); i++) {
                if (patients.get(i).getId().equals(patientId)) {
                    patients.set(i, updatedPatient);
                    System.out.println(Constant.PATIENT_UPDATED);
                    return; // Exit after updating
                }
            }
        }
        System.out.println("Patient not found for update");
    }

    public void removePatient(String patientId) {
        patient p = getPatientById(patientId);
        // Check if p is not null before accessing its methods
        if (p != null) {
            patients.remove(p);
            System.out.println(Constant.PATIENT_REMOVE_SUCCESSFULLY);
        } else {
            System.out.println("Patient not found");
        }
    }

    public List<patient> searchPatientsByName(String name) {
        System.out.println("Search Results:");
        List<Patient> foundPatients = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getFirstName().toLowerCase().contains(name.toLowerCase())) {
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
        for (Patient p : patients) {
            p.displayInfo();
        }
    }
}