package Services;

import Entities.EmergencyPatient;
import Entities.InPatient;
import Entities.OutPatient;
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
                patientId,          // id
                firstName,          // firstName
                lastName,           // lastName
                dateOfBirth,        // dateOfBirth
                gender,             // gender
                phoneNumber,        // phoneNumber
                email,              // email
                address,            // address
                null,               // specialization (Not for patients)
                null,               // qualification (Not for patients)
                0,                  // experienceYears (Not for patients)
                null,               // departmentId (Not for patients)
                0.0,                // consultationFee (Not for patients)
                null,               // availableSlots (Not for patients)
                null,               // assignedPatients (Not for patients)
                patientId,          // patientId
                bloodGroup,         // bloodGroup
                emergencyContacts,  // emergencyContact
                registrationDate,   // registrationDate
                insuranceId,        // insuranceId
                medicalRecords,     // medicalRecords
                appointments        // appointments
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


    public void searchPatientsByName(String name){
        for(patient p : patients){
            if(p.getFirstName().equalsIgnoreCase(name) || p.getLastName().equalsIgnoreCase(name)){
                p.displayInfo();
            }
        }
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

    }

    public void addPatient(String firstName, String lastName, String phone){
        patient p =new patient();
        System.out.println("Enter patient first name: ");
        firstName = scanner.nextLine();
        p.setFirstName(firstName);

        System.out.println("Enter patient last name: ");
        lastName = scanner.nextLine();
        p.setLastName(lastName);

        System.out.println("Enter patient phone: ");
        phone = scanner.nextLine();
        p.setPhoneNumber(phone);
    }

    public void addPatient(String firstName, String lastName, String phone, String bloodGroup, String email){
        patient p =new patient();
        System.out.println("Enter patient first name: ");
        firstName = scanner.nextLine();
        p.setFirstName(firstName);

        System.out.println("Enter patient last name: ");
        lastName = scanner.nextLine();
        p.setLastName(lastName);

        System.out.println("Enter patient phone: ");
        phone = scanner.nextLine();
        p.setPhoneNumber(phone);

        System.out.println("Enter patient bloodGroup: ");
        phone = scanner.nextLine();
        p.setBloodGroup(bloodGroup);

        System.out.println("Please enter Email: ");
        email = scanner.nextLine();
        p.setEmail(email);

    }

    public void addPatient(patient patient) {
        patient p =new patient();
        patients.add(patient);
        addPatient();
    }

    public void searchPatients(String keyword) {
        patient p =new patient();
        System.out.println("You can search patient by any field:");
        keyword = scanner.nextLine();
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).equals(keyword)) {
                p.displayInfo();
            }
        }
    }

    public void searchPatients(String firstName, String lastName) {
        patient p =new patient();
    }

    public void displayPatients() {
        displayAllPatients();
    }

    public void displayPatients(String filter) {
        InPatient In = new InPatient();
        OutPatient Out = new OutPatient();
        EmergencyPatient Emergency = new EmergencyPatient();



        System.out.println("Please enter the type of patient you want to display(InPatient/OutPatient/EmergencyPatient)");
        filter = scanner.nextLine();
        if (filter.equalsIgnoreCase("InPatient")) {
            In.displayInfo();
        } else if (filter.equalsIgnoreCase("OutPatient")) {
            Out.displayInfo();
        } else {
            Emergency.displayInfo();
        }
    }

    public void displayPatients(int limit) {

        System.out.println("DISPLAYING LIMITED PATIENTS");
        System.out.println("-------------------");

        System.out.println("please enter the number of patients you want to display:");
        limit = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < limit && i < patients.size(); i++) {
            displayPatients();
        }
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