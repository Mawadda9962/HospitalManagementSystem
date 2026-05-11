package Services;

import Entities.Doctor;
import Utiles.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorService {
    static Scanner scanner = new Scanner(System.in);
    //List doctors (Static list to store all doctors)
    static List<Doctor> doctors = new ArrayList<>();


    public void addDoctor() {
        System.out.println("********** Add New Doctor ********");
        System.out.println("Enter Doctor ID:");
        String dId = scanner.nextLine();

        if (getDoctorById(dId) != null) {
            System.out.println("Doctor ID already exists!");
            return;
        }

        System.out.print("Enter First Name: ");
        String fname = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lname = scanner.nextLine();

        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        System.out.print("Is Doctor Available? (true/false): ");
        boolean available = scanner.nextBoolean();
        scanner.nextLine(); // Clear buffer

        // Creating the object
        Doctor doctor = new Doctor(dId, fname, lname, specialization, phone, available);

        // Calling the internal add method
        addDoctor(doctor);
    }

    // Overloaded method to meet the specific requirement: addDoctor(Doctor doctor)
    public void addDoctor(Doctor doctor) {
        if (doctor != null) {
            doctors.add(doctor);
            System.out.println("Doctor " + doctor.getFirstName() + " added successfully.");
        }
    }

    /**
     * Requirement: getDoctorById(String doctorId)
     */
    public Doctor getDoctorById(String doctorId) {
        for (Doctor d : doctors) {
            if (d.getDoctorId().equals(doctorId)) {
                return d;
            }
        }
        return null;
    }

    /**
     * Requirement: editDoctor(String doctorId, Doctor updatedDoctor)
     */
    public void editDoctor(String doctorId, Doctor updatedDoctor) {
        if (doctorId != null) {
            for (int i = 0; i < doctors.size(); i++) {
                if (doctors.get(i).getDoctorId().equals(doctorId)) {
                    doctors.set(i, updatedDoctor);
                    System.out.println("Doctor records updated successfully.");
                    return;
                }
            }
        }
        System.out.println("Doctor not found.");
    }

    /**
     * Requirement: removeDoctor(String doctorId)
     */
    public void removeDoctor(String doctorId) {
        Doctor d = getDoctorById(doctorId);
        if (d != null) {
            doctors.remove(d);
            System.out.println("Doctor removed successfully.");
        } else {
            System.out.println("Doctor not found.");
        }
    }

    /**
     * Requirement: displayAllDoctors()
     */
    public void displayAllDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors in the system.");
            return;
        }
        System.out.println("===== All Registered Doctors =====");
        for (Doctor d : doctors) {
            d.displayInfo();
        }
    }

    /**
     * Requirement: getDoctorsBySpecialization(String specialization)
     */
    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        List<Doctor> filteredDoctors = new ArrayList<>();
        System.out.println("Doctors for Specialization: " + specialization);
        for (Doctor d : doctors) {
            if (d.getSpecialization().equalsIgnoreCase(specialization)) {
                d.displayInfo();
                filteredDoctors.add(d);
            }
        }
        if (filteredDoctors.isEmpty()) {
            System.out.println("No doctors found for this specialization.");
        }
        return filteredDoctors;
    }

    /**
     * Requirement: getAvailableDoctors()
     */
    public List<Doctor> getAvailableDoctors() {
        List<Doctor> availableDoctors = new ArrayList<>();
        System.out.println("======= Available Doctors =======");
        for (Doctor d : doctors) {
            if (d.isAvailable()) { // Assuming your Doctor class has isAvailable()
                d.displayInfo();
                availableDoctors.add(d);
            }
        }
        if (availableDoctors.isEmpty()) {
            System.out.println("No doctors are currently available.");
        }
        return availableDoctors;
    }
}