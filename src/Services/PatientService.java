package Services;

import Entities.patient;
import Utiles.Constant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PatientService {

    private static final Scanner scanner = new Scanner(System.in);

    // This list stores all patients in the system (acts as our in-memory database)
    private static final List<patient> patients = new ArrayList<>();



    public void addPatient() {
        System.out.println("********** Add New Patient ***********");

        // Get and validate the patient ID
        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine().trim();

        if (getPatientById(patientId) != null) {
            System.out.println(":warning: A patient with this ID already exists.");
            return;
        }

        // Collect personal information
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine().trim();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine().trim();

        System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine().trim();

        System.out.print("Enter Gender (Male/Female/Other): ");
        String gender = scanner.nextLine().trim();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine().trim();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine().trim();

        // Collect patient-specific information
        System.out.print("Enter Blood Group (e.g., A+, O-): ");
        String bloodGroup = scanner.nextLine().trim();

        System.out.print("Enter Emergency Contact Number: ");
        String emergencyContact = scanner.nextLine().trim();

        System.out.print("Enter Insurance ID: ");
        String insuranceId = scanner.nextLine().trim();

        // Set automatic values
        LocalDate registrationDate = LocalDate.now();

        // Emergency contact is stored in a list (can hold multiple contacts)
        List<String> emergencyContacts = new ArrayList<>();
        emergencyContacts.add(emergencyContact);

        // Medical records and appointments start empty for a new patient
        List<String> medicalRecords = new ArrayList<>();
        List<String> appointments = new ArrayList<>();

        // Create and save the new patient object
        patient newPatient = new patient(
                patientId,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phoneNumber,
                email,
                address,
                insuranceId,
                patientId,
                bloodGroup,
                emergencyContacts,
                registrationDate,
                medicalRecords,
                appointments
        );

        patients.add(newPatient);
        System.out.println(Constant.PATIENT_ADDED_SUCCESSFULLY);
    }


    public patient getPatientById(String patientId) {
        for (patient p : patients) {
            if (p.getPatientId().equals(patientId)) {
                return p;
            }
        }
        return null; // Not found
    }



    public void editPatient(String patientId, patient updatedPatient) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getPatientId().equals(patientId)) {
                patients.set(i, updatedPatient); // Replace old record with updated one
                System.out.println(Constant.PATIENT_UPDATED_SUCCESSFULLY);
                return;
            }
        }
        System.out.println("Patient with ID " + patientId + " not found.");
    }



    public void removePatient(String patientId) {
        patient found = getPatientById(patientId);

        if (found != null) {
            patients.remove(found);
            System.out.println(Constant.PATIENT_REMOVE_SUCCESSFULLY);
        } else {
            System.out.println("Patient with ID " + patientId + " not found.");
        }
    }



    public List<patient> searchPatientsByName(String name) {
        List<patient> results = new ArrayList<>();
        String searchTerm = name.toLowerCase();

        for (patient p : patients) {
            boolean matchesFirst = p.getFirstName().toLowerCase().contains(searchTerm);
            boolean matchesLast  = p.getLastName().toLowerCase().contains(searchTerm);

            if (matchesFirst || matchesLast) {
                results.add(p);
            }
        }

        // Show results
        if (results.isEmpty()) {
            System.out.println("No patients found with name: " + name);
        } else {
            System.out.println("Search Results for " + name );
            for (patient p : results) {
                p.displayInfo();
            }
        }

        return results;
    }



    public void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered in the system.");
            return;
        }

        System.out.println("All Patients" + patients.size() + " total");
        for (patient p : patients) {
            p.displayInfo();
            System.out.println(); // Blank line between patients for readability
        }
    }
}