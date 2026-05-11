package Services;

import Entities.Doctor;
import Utiles.Constant;

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
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getDoctorId().equals(doctorId)) {
                doctors.set(i, updatedDoctor); // Replace old record with updated one
                System.out.println(Constant.DOCTOR_UPDATED_SUCCESSFULLY);
                return;
            }
        }
        System.out.println("Doctor with ID " + doctorId + "not found.");
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
            System.out.println("Doctors specialized in \"" + specialization + "\" =====");
            for (Doctor d : results) {
                d.displayInfo();
                System.out.println();
            }
        }

        return results;
    }


    // ─────────────────────────────────────────────
    //  GET AVAILABLE DOCTORS
    // ─────────────────────────────────────────────

    /**
     * Returns all doctors that are currently available.
     *
     * @return A list of available doctors.
     */
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
            System.out.println("\n===== Available Doctors (" + results.size() + " total) =====");
            for (Doctor d : results) {
                d.displayInfo();
                System.out.println();
            }
        }

        return results;
    }
}