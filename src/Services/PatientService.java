package Services;

import Entities.EmergencyPatient;
import Entities.InPatient;
import Entities.OutPatient;
import Entities.patient;
import Interfaces.Displayable;
import Interfaces.Manageable;
import Interfaces.Searchable;
import Utiles.Constant;
import Utiles.HelperUtils;
import Utiles.InputHandler;

import java.lang.foreign.PaddingLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PatientService extends Base implements Manageable, Searchable {

    private static Scanner scanner = new Scanner(System.in);

    // This list stores all patients in the system
    private static List<patient> patients = new ArrayList<>();


    public void addPatient() {
        System.out.println("********** Add New Patient ***********");

        // Get and validate the patient ID
        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine().trim();

        if (getPatientById(patientId) != null) {
            System.out.println("A patient with this ID already exists.");
            return;
        }


        String firstName = InputHandler.getStringInput("Enter First Name: ");
        String lastName = InputHandler.getStringInput("Enter Last Name: ");

        String dateOfBirth = InputHandler.getDateInput("Enter Date of Birth (YYYY-MM-DD): ").toString();

        String gender = InputHandler.getStringInput("Enter Gender (Male/Female/Other)");
        String phoneNumber = InputHandler.getStringInput("Enter Phone Number");
        String email = InputHandler.getStringInput("Enter Email");
        String address = InputHandler.getStringInput("Enter Address");
        String bloodGroup = InputHandler.getStringInput("Enter Blood Group (e.g., A+, O-)");
        String emergencyContact = InputHandler.getStringInput("Enter Emergency Contact Number");
        String insuranceId = InputHandler.getStringInput("Enter Insurance ID");

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

    //Implementing HelperUtils. isNotNull
    public patient getPatientById(String patientId) {
        for (patient p : patients) {
            if (HelperUtils.isNotNull(p.getPatientId()) && p.getPatientId().equals(patientId)) {
                return p;
            }
        }
        return null;
    }


    // Integrated your specific edit logic here
    public void editPatient(String patientId) {
        for (patient p : patients) {
            if (p.getPatientId().equals(patientId)) {

                p.setFirstName(InputHandler.getStringInput("Enter updated patient first name"));
                p.setLastName(InputHandler.getStringInput("Enter updated patient last name"));

                LocalDate dob = InputHandler.getDateInput("Enter updated patient DOB (dd-MM-yyyy)");
                p.setDateOfBirth(dob.toString());

                p.setGender(InputHandler.getStringInput("Enter updated patient gender"));
                p.setPhoneNumber(InputHandler.getStringInput("Enter updated patient phone number"));
                p.setEmail(InputHandler.getStringInput("Enter updated patient email"));
                p.setAddress(InputHandler.getStringInput("Enter updated patient address"));
                p.setBloodGroup(InputHandler.getStringInput("Enter updated patient blood Group"));

                String eContact = InputHandler.getStringInput("Enter updated patient emergency Contact");
                List<String> eList = new ArrayList<>();
                eList.add(eContact);
                p.setEmergencyContact(eList);

                p.setRegistrationDate(InputHandler.getDateInput("Enter updated registration Date (dd-MM-yyyy)"));
                p.setInsuranceId(InputHandler.getStringInput("Enter updated patient insurance Id"));

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

    //Implementing HelperUtils. isNotNull
    public void removePatient(String patientId) {
        patient found = getPatientById(patientId);

        if (HelperUtils.isNotNull(found)) {
            patients.remove(found);
            System.out.println(Constant.PATIENT_REMOVE_SUCCESSFULLY);
        } else {
            System.out.println("Patient with ID " + patientId + " not found.");
        }
    }


    public void searchPatientsByName(String name) {
        for (patient p : patients) {
            if (p.getFirstName().equalsIgnoreCase(name) || p.getLastName().equalsIgnoreCase(name)) {
                p.displayInfo();
            }
        }
    }


    public void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No Patients registered in the system! ");
            return;
        }
        System.out.println("Total Registered Patients: " + patients.size());
        for (patient p : patients) {
            p.displayInfo();
        }

    }

    public void addPatient(String firstName, String lastName, String phone) {
        patient p = new patient();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setPhoneNumber(phone);

        patients.add(p);
        System.out.println(Constant.PATIENT_ADDED_SUCCESSFULLY);
    }

    public void addPatient(String firstName, String lastName, String phone, String bloodGroup, String email) {
        patient p = new patient();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setPhoneNumber(phone);
        p.setBloodGroup(bloodGroup);
        p.setEmail(email);

        patients.add(p);
        System.out.println(Constant.PATIENT_ADDED_SUCCESSFULLY);

    }

    public void addPatient(patient patient) {
        if (HelperUtils.isNotNull(patient)) {
            patients.add(patient);
            System.out.println(Constant.PATIENT_ADDED_SUCCESSFULLY);
        }
    }

    public void searchPatients(String keyword) {
        patient p = new patient();
        System.out.println("You can search patient by any field:");
        keyword = scanner.nextLine();
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).equals(keyword)) {
                p.displayInfo();
            }
        }
    }

    public void searchPatients(String firstName, String lastName) {
        patient p = new patient();
    }

    public void displayPatients() {
        displayAllPatients();
    }

    public void displayPatients(String filter) {
        InPatient In = new InPatient();
        OutPatient Out = new OutPatient();
        EmergencyPatient Emergency = new EmergencyPatient();


        String choice = InputHandler.getStringInput("Enter Type (InPatient/OutPatient/EmergencyPatient");
        if (choice.equalsIgnoreCase("InPatient")) {
            In.displayInfo();
        } else if (choice.equalsIgnoreCase("OutPatient")) {
            Out.displayInfo();
        } else {
            Emergency.displayInfo();
        }
    }

    public void displayPatients(int limit) {

        System.out.println("DISPLAYING LIMITED PATIENTS");
        System.out.println("*******************************");

        limit = InputHandler.getIntInput("please enter the number of patients you want to display:");
        for (int i = 0; i < limit && i < patients.size(); i++) {
            patients.get(i).displayInfo();
        }
    }

    public void addInPatient() {
        System.out.println("********** Register InPatient **********");
        // Collect common data first
        String id = InputHandler.getStringInput("Enter Patient ID");
        String fName = InputHandler.getStringInput("Enter First Name");
        String lName = InputHandler.getStringInput("Enter Last Name");
        String roomNumber = InputHandler.getStringInput("Enter Assigned Room Number");

        InPatient inPatient = new InPatient();
        inPatient.setPatientId(id);
        inPatient.setFirstName(fName);
        inPatient.setLastName(lName);
        inPatient.setRoomNumber(roomNumber);

        patients.add(inPatient);
        System.out.println("InPatient registered successfully.");
    }

    public void OutPatient() {
        System.out.println("********** Register OutPatient **********");

        String id = InputHandler.getStringInput("Enter Patient ID");
        String fName = InputHandler.getStringInput("Enter First Name");
        String lName = InputHandler.getStringInput("Enter Last Name");
        OutPatient outPatient = new OutPatient();

        outPatient.setPatientId(id);
        outPatient.setFirstName(fName);
        outPatient.setLastName(lName);

        patients.add(outPatient);
        System.out.println("OutPatient registered successfully.");
    }


    public void addEmergencyPatient() {
        System.out.println("********** Register Emergency Patient **********");
        addPatient();
        EmergencyPatient emergencyPatient = new EmergencyPatient();

        String emergencyType = InputHandler.getStringInput("emergencyType");
        emergencyPatient.setEmergencyType(emergencyType);

        String arrivalMode = InputHandler.getStringInput("Arrival Mode");
        emergencyPatient.setEmergencyType(arrivalMode);

        System.out.println("Emergency Patient admitted immediately!");
    }

    public void viewMedicalHistory(String patientId) {
        patient p = getPatientById(patientId);
        if (HelperUtils.isNotNull(p)) {
            System.out.println("Medical Records for " + p.getFirstName());
            if (p.getMedicalRecords().isEmpty()) {
                System.out.println("No history found for this patient.");
            } else {
                // Loop through the String list of records
                for (String record : p.getMedicalRecords()) {
                    System.out.println(record);
                }
            }
        } else {
            System.out.println("Patient not found.");
        }
    }

    //instanceof keyword acts a security guard
    @Override
    public void add(Object entity) {
        if (entity instanceof patient) {
            patient p = (patient) entity;
            if (HelperUtils.isNotNull(p)) {
                patients.add(p);
                System.out.println("Patient added: " + p.getFirstName());
            }
        } else {
            System.out.println("Invalid");
        }
    }

    @Override
    public void remove(String id) {
        removePatient(id);
    }

    @Override
    public void getAll() {
        displayAllPatients();

    }

    @Override
    public void search(String keyword) {
        if (HelperUtils.isNull(keyword)) {
            System.out.println("Keyword is empty.");
            return;
        }
        System.out.println("Searching for: " + keyword);
        boolean found = false;
        for (patient p : patients) {
            if (HelperUtils.isNotNull(p) && (p.getFirstName().equalsIgnoreCase(keyword)
                    || p.getLastName().equalsIgnoreCase(keyword)
                    || p.getPatientId().equalsIgnoreCase(keyword))) {
                p.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No patients found matching: " + keyword);
        }
    }

    @Override
    public void searchById(String id) {
        patient p = getPatientById(id);
        if (HelperUtils.isNotNull(p)) {
            p.displayInfo();
        } else {
            System.out.println("No patient found with ID: " + id);
        }
    }

    public Boolean handlePatientsMenu(Integer PatientOption) {
        switch (PatientOption) {
            case 1 -> {
                addPatient();
            }
            case 2 -> {
                addInPatient();
            }
            case 3 -> {
                OutPatient();
            }
            case 4 -> {
                addEmergencyPatient();
            }
            case 5 -> {
                displayAllPatients();
            }
            case 6 -> {
                String keyword = InputHandler.getStringInput("Enter Name or ID to search");
                search(keyword);
            }
            case 7 -> {
                String id = InputHandler.getStringInput("Enter Patient ID to edit");
                editPatient(id);
            }
            case 8 -> {
                String id = InputHandler.getStringInput("Enter Patient ID to view history");
                viewMedicalHistory(id);
            }
            case 9 -> {
                String id = InputHandler.getStringInput("Enter Patient ID to view history");
                viewMedicalHistory(id);
            }
            case 10 ->{
                return false;
            }
            default -> System.out.println("Invalid option.");
        }
        return true;
    }
}