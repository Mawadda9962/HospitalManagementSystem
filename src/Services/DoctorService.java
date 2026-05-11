package Services;

import Entities.Doctor;
import Entities.patient;
import Utiles.Constant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DoctorService {

    private static Scanner scanner = new Scanner(System.in);

    //Adding static list to store all doctors
    private static List<Doctor> doctors = new ArrayList<>();


    public void addDoctor() {
        System.out.println("********** Add New Doctor **********");

        //Get the doctor ID
        System.out.print("Enter Doctor ID: ");
        String doctorId = scanner.nextLine();

        //If Doctor ID is already exists
        if (getDoctorById(doctorId) != null) {
            System.out.println("A doctor with this ID already exists.");
            return;
        }

        //Collect personal information
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

        //Collect doctor-specific information
        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine().trim();

        System.out.print("Enter Qualification (e.g., MBBS, MD): ");
        String qualification = scanner.nextLine().trim();

        System.out.print("Enter Years of Experience: ");
        int experienceYears = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter Department ID: ");
        String departmentId = scanner.nextLine().trim();

        System.out.print("Enter Consultation Fee: ");
        double consultationFee = Double.parseDouble(scanner.nextLine().trim());

        //Set automatic values
        // Available slots and assigned patients start empty for a new doctor
        List<String> availableSlots    = new ArrayList<>();
        List<String> assignedPatients  = new ArrayList<>();

        //Creating and save the new doctor object
        Doctor newDoctor = new Doctor(
                doctorId,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phoneNumber,
                email,
                address,
                specialization,
                qualification,
                experienceYears,
                departmentId,
                consultationFee,
                availableSlots,
                assignedPatients
        );

        doctors.add(newDoctor);
        System.out.println(Constant.DOCTOR_ADDED_SUCCESSFULLY);
    }


    public Doctor getDoctorById(String doctorId) {
        for (Doctor d : doctors) {
            if (d.getDoctorId().equals(doctorId)) {
                return d;
            }
        }
        return null; // Not found
    }

    public void editDoctor(String doctorId, Doctor updatedDoctor) {
        for (Doctor D : doctors) {
            if (D.getDoctorId().equals(doctorId)) {

                System.out.println("Enter updated Doctor first name :");
                p.setFirstName(scanner.nextLine());

                System.out.println("Enter updated Doctor last name :");
                p.setLastName(scanner.nextLine());

                System.out.println("Enter updated Doctor DOB (YYYY-MM-DD): ");
                String dateOfBirth = scanner.nextLine();
                LocalDate DOB = LocalDate.parse(dateOfBirth);
                p.setDateOfBirth(DOB.toString()); // Adapted to match your entity type if needed

                System.out.println("Enter updated Doctor gender :");
                p.setGender(scanner.nextLine());

                System.out.println("Enter updated Doctor phone number :");
                p.setPhoneNumber(scanner.nextLine());

                System.out.println("Enter updated Doctor email :");
                p.setEmail(scanner.nextLine());

                System.out.println("Enter updated Doctor address :");
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







    public void removeDoctor(String doctorId) {
        Doctor found = getDoctorById(doctorId);

        if (found != null) {
            doctors.remove(found);
            System.out.println(Constant.DOCTOR_REMOVE_SUCCESSFULLY);
        } else {
            System.out.println("Doctor with ID " + doctorId + "not found.");
        }
    }


    public void displayAllDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("⚠ No doctors registered in the system.");
            return;
        }

        System.out.println("All Doctors" + doctors.size() + " total");
        for (Doctor d : doctors) {
            d.displayInfo();
            System.out.println();
        }
    }


    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        List<Doctor> results = new ArrayList<>();

        for (Doctor d : doctors) {
            if (d.getSpecialization().equalsIgnoreCase(specialization)) {
                results.add(d);
            }
        }

        // Show results
        if (results.isEmpty()) {
            System.out.println("No doctors found with specialization: " + specialization);
        } else {
            System.out.println("Doctors specialized in" + specialization);
            for (Doctor d : results) {
                d.displayInfo();
                System.out.println();
            }
        }

        return results;
    }


    public List<Doctor> getAvailableDoctors() {
        List<Doctor> results = new ArrayList<>();

        for (Doctor d : doctors) {
            if (d.isAvailable()) {
                results.add(d);
            }
        }

        // Show results
        if (results.isEmpty()) {
            System.out.println(":warning: No doctors are currently available.");
        } else {
            System.out.println(" Available Doctors" + results.size() + " total");
            for (Doctor d : results) {
                d.displayInfo();
                System.out.println();
            }
        }

        return results;
    }
//
//    public Boolean handleDoctorMenu(Integer DoctorOption) {
//        switch (DoctorOption) {
//            case 1 -> {
//                addDoctor();
//            }
//            case 2 -> {
//                System.out.print("Enter Patient ID to edit: ");
//                String id = scanner.nextLine().trim();
//                editDoctor(id);
//            }
//            case 3 -> {
//                System.out.print("Enter Patient ID to remove: ");
//                String id = scanner.nextLine().trim();
//                removePatient(id);
//            }
//            case 4 -> {
//                System.out.print("Enter name to search: ");
//                String name = scanner.nextLine().trim();
//                searchPatientsByName(name);
//            }
//            case 5 -> {
//                displayAllPatients();
//            }
//            case 6 -> {
//                return false;
//            }
//            default -> System.out.println("Invalid option.");
//        }
//        return true;
//    }
}