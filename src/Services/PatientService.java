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
        return null;
    }


    // Integrated your specific edit logic here
    public void editPatient(String patientId) {
        for (patient p : patients) {
            if (p.getPatientId().equals(patientId)) {

                System.out.println("Enter updated patient first name :");
                p.setFirstName(scanner.nextLine());

                System.out.println("Enter updated patient last name :");
                p.setLastName(scanner.nextLine());

                System.out.println("Enter updated patient DOB (YYYY-MM-DD): ");
                String dateOfBirth = scanner.nextLine();
                LocalDate DOB = LocalDate.parse(dateOfBirth);
                p.setDateOfBirth(DOB.toString()); // Adapted to match your entity type if needed

                System.out.println("Enter updated patient gender :");
                p.setGender(scanner.nextLine());

                System.out.println("Enter updated patient phone number :");
                p.setPhoneNumber(scanner.nextLine());

                System.out.println("Enter updated patient email :");
                p.setEmail(scanner.nextLine());

                System.out.println("Enter updated patient address :");
                p.setAddress(scanner.nextLine());

                System.out.println("Enter updated patient blood Group :");
                p.setBloodGroup(scanner.nextLine());

                System.out.println("Enter updated patient emergency Contact :");
                String eContact = scanner.nextLine();
                List<String> eList = new ArrayList<>();
                eList.add(eContact);
                p.setEmergencyContact(eList);

                System.out.println("Enter updated registration Date (YYYY-MM-DD):");
                String dateOfRegistration = scanner.nextLine();
                LocalDate DOR = LocalDate.parse(dateOfRegistration);
                p.setRegistrationDate(DOR);

                System.out.println("Enter updated patient insurance Id :");
                p.setInsuranceId(scanner.nextLine());

                System.out.println("Enter updated patient allergies :");
                Boolean continueFlag = true;
                List<String> allergies = new ArrayList<>();
                while (continueFlag) {
                    System.out.print("Allergy: ");
                    allergies.add(scanner.nextLine());
                    System.out.println("Enter 'a' to add more allergies, and 'q' to exit");
                    if (scanner.nextLine().equalsIgnoreCase("q")) {
                        continueFlag = false;
                    }
                }
                // Assuming your patient entity has this method
                // p.setAllergies(allergies);

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

        // Safety check for the search term itself
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Search term cannot be empty.");
            return results;
        }

        String searchTerm = name.toLowerCase().trim();

        for (patient p : patients) {
            // Use a null-safe check before calling toLowerCase()
            String fName = (p.getFirstName() != null) ? p.getFirstName().toLowerCase() : "";
            String lName = (p.getLastName() != null) ? p.getLastName().toLowerCase() : "";

            if (fName.contains(searchTerm) || lName.contains(searchTerm)) {
                results.add(p);
            }
        }

        if (results.isEmpty()) {
            System.out.println("No patients found with name: " + name);
        } else {
            System.out.println("Search Results for: " + name);
            for (patient p : results) {
                p.displayInfo();
            }
        }

        return results;

    }

    public void displayAllPatients() {
        if (patients.isEmpty()){
            System.out.println("No Patients registered in the system! ");
            return;
        }
        System.out.println("Total Registered Patients: " + patients.size());
        for (patient p : patients) {
            p.displayInfo();
        }

//        if (patients.isEmpty()) {
//            System.out.println("No patients registered in the system.");
//            return;
//        }
//
//        System.out.println("All Patients" + patients.size() + " total");
//        for (patient p : patients) {
//            p.displayInfo();
//            System.out.println();
//        }
    }

    public Boolean handlePatientsMenu(Integer PatientOption) {
        switch (PatientOption) {
            case 1 -> {
                addPatient();
            }
            case 2 -> {
                System.out.print("Enter Patient ID to edit: ");
                String id = scanner.nextLine().trim();
                editPatient(id);
            }
            case 3 -> {
                System.out.print("Enter Patient ID to remove: ");
                String id = scanner.nextLine().trim();
                removePatient(id);
            }
            case 4 -> {
                System.out.print("Enter name to search: ");
                String name = scanner.nextLine().trim();
                searchPatientsByName(name);
            }
            case 5 -> {
                displayAllPatients();
            }
            case 6 -> {
                return false;
            }
            default -> System.out.println("Invalid option.");
        }
        return true;
    }
}