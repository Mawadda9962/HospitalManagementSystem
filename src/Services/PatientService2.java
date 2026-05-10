package Services;

import Entities.Patient;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientService {

    private static final List<Patient> patients = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    // ─────────────────────────────────────────────
    //  ADD
    // ─────────────────────────────────────────────
    public void addPatient() {
        System.out.println("\n========== Add New Patient ==========");

        // ── Person fields ──
        System.out.print("Enter Person ID         : ");
        String id = scanner.nextLine().trim();

        if (getPatientById(id) != null) {
            System.out.println("⚠  A patient with this ID already exists.");
            return;
        }

        System.out.print("Enter First Name        : ");
        String firstName = scanner.nextLine().trim();

        System.out.print("Enter Last Name         : ");
        String lastName = scanner.nextLine().trim();

        System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine().trim();

        System.out.print("Enter Gender            : ");
        String gender = scanner.nextLine().trim();

        System.out.print("Enter Phone Number      : ");
        String phoneNumber = scanner.nextLine().trim();

        System.out.print("Enter Email             : ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter Address           : ");
        String address = scanner.nextLine().trim();

        // ── Patient-specific fields ──
        System.out.print("Enter Patient ID        : ");
        String patientId = scanner.nextLine().trim();

        System.out.print("Enter Blood Group       : ");
        String bloodGroup = scanner.nextLine().trim();

        System.out.print("Enter Emergency Contact : ");
        String emergencyContact = scanner.nextLine().trim();

        System.out.print("Enter Insurance ID      : ");
        String insuranceId = scanner.nextLine().trim();

        System.out.print("Enter Allergies (comma-separated, or press Enter to skip): ");
        String allergiesInput = scanner.nextLine().trim();
        List<String> allergies = new ArrayList<>();
        if (!allergiesInput.isEmpty()) {
            for (String allergy : allergiesInput.split(",")) {
                allergies.add(allergy.trim());
            }
        }

        // registrationDate is always today
        LocalDate registrationDate = LocalDate.now();

        // Create and store the new patient
        Patient newPatient = new Patient(
                id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address,
                patientId, bloodGroup, allergies, emergencyContact, registrationDate,
                insuranceId, new ArrayList<>(), new ArrayList<>()
        );

        patients.add(newPatient);
        System.out.println("✔  Patient added successfully!");
    }

    // ─────────────────────────────────────────────
    //  READ – single
    // ─────────────────────────────────────────────
    public Patient getPatientById(String patientId) {
        for (Patient p : patients) {
            if (p.getPatientId().equals(patientId)) {
                return p;
            }
        }
        return null;    // not found
    }

    // ─────────────────────────────────────────────
    //  READ – all
    // ─────────────────────────────────────────────
    public void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered yet.");
            return;
        }
        System.out.println("\n========== All Patients ==========");
        for (Patient p : patients) {
            p.displayInfo();
            System.out.println("----------------------------------");
        }
    }

    // ─────────────────────────────────────────────
    //  UPDATE
    // ─────────────────────────────────────────────
    public void editPatient() {
        System.out.println("\n========== Edit Patient ==========");
        System.out.print("Enter the Patient ID to edit: ");
        String patientId = scanner.nextLine().trim();

        // Find the index of the patient in the list
        int index = -1;
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getPatientId().equals(patientId)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("⚠  Patient not found.");
            return;
        }

        Patient existing = patients.get(index);
        System.out.println("Leave a field blank to keep the current value.");

        // ── Update Person fields ──
        System.out.print("First Name [" + existing.getFirstName() + "]: ");
        String firstName = scanner.nextLine().trim();
        if (!firstName.isEmpty()) existing.setFirstName(firstName);

        System.out.print("Last Name  [" + existing.getLastName() + "]: ");
        String lastName = scanner.nextLine().trim();
        if (!lastName.isEmpty()) existing.setLastName(lastName);

        System.out.print("Phone      [" + existing.getPhoneNumber() + "]: ");
        String phone = scanner.nextLine().trim();
        if (!phone.isEmpty()) existing.setPhoneNumber(phone);

        System.out.print("Email      [" + existing.getEmail() + "]: ");
        String email = scanner.nextLine().trim();
        if (!email.isEmpty()) existing.setEmail(email);

        System.out.print("Address    [" + existing.getAddress() + "]: ");
        String address = scanner.nextLine().trim();
        if (!address.isEmpty()) existing.setAddress(address);

        // ── Update Patient-specific fields ──
        System.out.print("Blood Group        [" + existing.getBloodGroup() + "]: ");
        String bloodGroup = scanner.nextLine().trim();
        if (!bloodGroup.isEmpty()) existing.setBloodGroup(bloodGroup);

        System.out.print("Emergency Contact  [" + existing.getEmergencyContact() + "]: ");
        String emergencyContact = scanner.nextLine().trim();
        if (!emergencyContact.isEmpty()) existing.setEmergencyContact(emergencyContact);

        System.out.print("Insurance ID       [" + existing.getInsuranceId() + "]: ");
        String insuranceId = scanner.nextLine().trim();
        if (!insuranceId.isEmpty()) existing.setInsuranceId(insuranceId);

        // The list already holds the same object reference, so edits apply automatically.
        System.out.println("✔  Patient updated successfully!");
    }

    // ─────────────────────────────────────────────
    //  DELETE
    // ─────────────────────────────────────────────
    public void removePatient() {
        System.out.println("\n========== Remove Patient ==========");
        System.out.print("Enter the Patient ID to remove: ");
        String patientId = scanner.nextLine().trim();

        Patient p = getPatientById(patientId);
        if (p == null) {
            System.out.println("⚠  Patient not found.");
            return;
        }

        // Show the patient's name and ask for confirmation
        System.out.println("Found: " + p.getFirstName() + " " + p.getLastName());
        System.out.print("Are you sure you want to remove this patient? (yes/no): ");
        String confirm = scanner.nextLine().trim();

        if (confirm.equalsIgnoreCase("yes")) {
            patients.remove(p);
            System.out.println("✔  Patient removed successfully!");
        } else {
            System.out.println("Removal cancelled.");
        }
    }

    // ─────────────────────────────────────────────
    //  SEARCH
    // ─────────────────────────────────────────────
    public void searchPatientsByName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine().trim().toLowerCase();

        List<Patient> results = new ArrayList<>();
        for (Patient p : patients) {
            boolean firstNameMatches = p.getFirstName().toLowerCase().contains(name);
            boolean lastNameMatches  = p.getLastName().toLowerCase().contains(name);
            if (firstNameMatches || lastNameMatches) {
                results.add(p);
            }
        }

        if (results.isEmpty()) {
            System.out.println("No patients found with name: " + name);
        } else {
            System.out.println("Found " + results.size() + " patient(s):");
            for (Patient p : results) {
                p.displayInfo();
                System.out.println("----------------------------------");
            }
        }
    }
}