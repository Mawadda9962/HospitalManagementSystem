package Services;

import Entities.Doctor;
import Entities.patient;
import Interfaces.Manageable;
import Interfaces.Searchable;
import Utiles.Constant;
import Utiles.HelperUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorService extends Base implements Manageable, Searchable {

    private static Scanner scanner = new Scanner(System.in);

    // Adding static list to store all doctors
    private static List<Doctor> doctors = new ArrayList<>();

    public void addDoctor() {
        System.out.println("********** Add New Doctor **********");

        System.out.print("Enter Doctor ID: ");
        String doctorId = scanner.nextLine().trim();

        if (getDoctorById(doctorId) != null) {
            System.out.println("A doctor with this ID already exists.");
            return;
        }

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

        List<String> availableSlots = new ArrayList<>();
        List<String> assignedPatients = new ArrayList<>();


        Doctor newDoctor = new Doctor(
                doctorId,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phoneNumber,
                email,
                address,
                doctorId,
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
          if(HelperUtils.isNotNull(d.getDoctorId()) && d.getDoctorId().equals(doctorId)) {
                return d;
            }
        }
        return null;
    }

    // Integrated the refined edit logic here to match the Patient style
    public void editDoctor(String doctorId) {
        for (Doctor D : doctors) {
            if (HelperUtils.isNotNull(D.getDoctorId()) && D.getDoctorId().equals(doctorId)) {

                // Personal details
                System.out.println("Enter updated Doctor first name :");
                D.setFirstName(scanner.nextLine());

                System.out.println("Enter updated Doctor last name :");
                D.setLastName(scanner.nextLine());

                System.out.println("Enter updated Doctor DOB (YYYY-MM-DD):");
                String dob = scanner.nextLine();
                // If your Person class uses String for DOB, this works perfectly.
                D.setDateOfBirth(dob);

                System.out.println("Enter updated Doctor gender :");
                D.setGender(scanner.nextLine());

                System.out.println("Enter updated Doctor phone number :");
                D.setPhoneNumber(scanner.nextLine());

                System.out.println("Enter updated Doctor email :");
                D.setEmail(scanner.nextLine());

                System.out.println("Enter updated Doctor address :");
                D.setAddress(scanner.nextLine());

                // Doctor specific details
                System.out.println("Enter updated Specialization :");
                D.setSpecialization(scanner.nextLine());

                System.out.println("Enter updated Qualification :");
                D.setQualification(scanner.nextLine());

                System.out.println("Enter updated Years of Experience :");
                // Using Integer.parseInt to stay consistent with your handling of numbers
                D.setExperienceYears(Integer.parseInt(scanner.nextLine().trim()));

                System.out.println("Enter updated Department ID :");
                D.setDepartmentId(scanner.nextLine().trim());

                System.out.println("Enter updated Consultation Fee :");
                D.setConsultationFee(Double.parseDouble(scanner.nextLine().trim()));

                // Handle List of Available Slots (similar to how you handled Allergies in Patient)
                System.out.println("Enter updated Available Slots :");
                Boolean continueFlag = true;
                List<String> slots = new ArrayList<>();
                while (continueFlag) {
                    System.out.print("Slot");
                    slots.add(scanner.nextLine());
                    System.out.println("Enter 'a' to add more slots, and 'q' to exit");
                    if (scanner.nextLine().equalsIgnoreCase("q")) {
                        continueFlag = false;
                    }
                }
                D.setAvailableSlots(slots);

                System.out.println(Constant.DOCTOR_UPDATED_SUCCESSFULLY);
                return;
            }
        }
        System.out.println("Doctor with ID " + doctorId + " not found.");
    }

    public void removeDoctor(String doctorId) {
        Doctor found = getDoctorById(doctorId);
        if (HelperUtils.isNotNull(found)) {
            doctors.remove(found);
            System.out.println(Constant.DOCTOR_REMOVE_SUCCESSFULLY);
        } else {
            System.out.println("Doctor with ID " + doctorId + " not found.");
        }
    }

    public void displayAllDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors registered in the system.");
            return;
        }

        System.out.println("All Doctors" + doctors.size() + "total");
        for (Doctor d : doctors) {
            if (HelperUtils.isNotNull(d)){
                d.displayInfo();
            }
        }
    }

    public void getDoctorsBySpecialization(String specialization) {
        List<Doctor> results = new ArrayList<>();
        for (Doctor d : doctors) {
            if (HelperUtils.isNotNull(d.getSpecialization()) && d.getSpecialization().equalsIgnoreCase(specialization)) {                results.add(d);
                results.add(d);
            }
        }

        if (results.isEmpty()) {
            System.out.println("No doctors found with specialization: " + specialization);
        } else {
            System.out.println("Doctors specialized in " + specialization + ":");
            for (Doctor d : results) {
                d.displayInfo();
            }
        }
    }

    public void addDoctor(String name, String specialization, String phone) {
        Doctor doctor = new Doctor();
        doctor.setFirstName(name);
        doctor.setSpecialization(specialization);
        doctor.setPhoneNumber(phone);

        doctors.add(doctor);
        System.out.println(Constant.DOCTOR_ADDED_SUCCESSFULLY);
    }

    public void addDoctor(String name, String specialization, String phone, double consultationFee) {
        Doctor doctor = new Doctor();
        doctor.setFirstName(name);
        doctor.setSpecialization(specialization);
        doctor.setPhoneNumber(phone);
        doctor.setConsultationFee(consultationFee);

        doctors.add(doctor);
        System.out.println(Constant.DOCTOR_ADDED_SUCCESSFULLY);

    }

    public void addDoctor(Doctor doctor) {
        if (HelperUtils.isNotNull(doctor)) {
            doctors.add(doctor);
            System.out.println(Constant.DOCTOR_ADDED_SUCCESSFULLY);
        }
    }

    public void assignPatient(String doctorId, String patientId) {
        System.out.println("ASSIGNING PATIENT");
        Doctor d = getDoctorById(doctorId);
        if (HelperUtils.isNotNull(d)) {
            d.getAssignedPatients().add(patientId);
            System.out.println(patientId + " Assigned to: " + doctorId);
        }

    }

    public void assignPatient(Doctor doctor, patient patient) {
        if (HelperUtils.isNotNull(doctor) && HelperUtils.isNotNull(patient)) {
            doctor.getAssignedPatients().add(patient.getPatientId());
            System.out.println(patient.getPatientId() + " Assigned to: " + doctor.getDoctorId());
        }
    }

    public void assignPatient(String doctorId, List<String> patientIds) {
        Doctor d = getDoctorById(doctorId);
        if (HelperUtils.isNotNull(d)) {
            d.getAssignedPatients().addAll(patientIds);
            System.out.println("Patients assigned to: " + doctorId);
        }
    }

    public void displayDoctors() {
        displayAllDoctors();
    }


    public void displayDoctors(String specialization) {
        getDoctorsBySpecialization(specialization);
    }

    public void displayDoctors(String departmentId, boolean showAvailableOnly) {
        for (Doctor d : doctors) {
            if (d.getDepartmentId() != null && d.getDepartmentId().equalsIgnoreCase(departmentId)) {
                d.displayInfo();
            }
        }
    }


    public Boolean handleDoctorMenu(Integer doctorOption) {
        switch (doctorOption) {
            case 1 -> addDoctor();
            case 2 -> {
                System.out.print("Enter Doctor ID to edit: ");
                String id = scanner.nextLine().trim();
                editDoctor(id);
            }
            case 3 -> {
                System.out.print("Enter Doctor ID to remove: ");
                String id = scanner.nextLine().trim();
                removeDoctor(id);
            }
            case 4 -> {
                System.out.print("Enter Doctor ID to search: ");
                String id = scanner.nextLine().trim();
                Doctor d = getDoctorById(id);
                if (d != null) d.displayInfo();
                else System.out.println("Doctor not found.");
            }
            case 5 -> {
                System.out.print("Enter specialization to search: ");
                String spec = scanner.nextLine().trim();
                getDoctorsBySpecialization(spec);
            }
            case 6 -> displayAllDoctors();
            case 7 -> {
                return false; // Exit back to Main Menu
            }
            default -> System.out.println("Invalid option. Please choose 1-7.");
        }
        return true;
    }

    @Override
    public void add(Object entity) {
        if (entity instanceof Doctor) {
            Doctor d = (Doctor) entity;
            doctors.add(d);
            System.out.println("Doctor added: " + d.getFirstName());
        } else {
            System.out.println("Invalid entity type. Expected a Doctor object.");
        }
    }

    @Override
    public void remove(String id) {
        removeDoctor(id);
    }

    @Override
    public void getAll() {
        displayAllDoctors();
    }

    @Override
    public void search(String keyword) {
        boolean found = false;
        for (Doctor d : doctors) {
            if (d.getFirstName().equalsIgnoreCase(keyword)
                    || d.getLastName().equalsIgnoreCase(keyword)
                    || d.getDoctorId().equalsIgnoreCase(keyword)
                    || d.getSpecialization().equalsIgnoreCase(keyword)
                    || d.getDepartmentId().equalsIgnoreCase(keyword)) {
                d.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No doctors found matching: " + keyword);
        }
    }

    @Override
    public void searchById(String id) {
        Doctor d = getDoctorById(id);
        if (d != null) {
            d.displayInfo();
        } else {
            System.out.println("No doctor found with ID: " + id);
        }
    }
}