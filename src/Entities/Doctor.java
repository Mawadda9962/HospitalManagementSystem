package Entities;

import Interfaces.Displayable;

import java.time.LocalDate;
import java.util.List;

public class Doctor extends Person implements Displayable {
    private String doctorId;
    private String specialization;
    private String qualification;
    private int experienceYears;
    private String departmentId;
    private double consultationFee;
    private List<String> availableSlots;
    private List<String> assignedPatients;
    private boolean available;

    public Doctor(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String specialization, String qualification, int experienceYears, String departmentId, double consultationFee, List<String> availableSlots, List<String> assignedPatients, String doctorId, String specialization1, String qualification1, int experienceYears1, String departmentId1, double consultationFee1, List<String> availableSlots1, List<String> assignedPatients1, boolean available) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients);
        this.doctorId = doctorId;
        this.specialization = specialization1;
        this.qualification = qualification1;
        this.experienceYears = experienceYears1;
        this.departmentId = departmentId1;
        this.consultationFee = consultationFee1;
        this.availableSlots = availableSlots1;
        this.assignedPatients = assignedPatients1;
        this.available = available;
    }

    public Doctor() {
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public List<String> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<String> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public List<String> getAssignedPatients() {
        return assignedPatients;
    }

    public void setAssignedPatients(List<String> assignedPatients) {
        this.assignedPatients = assignedPatients;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("********** Doctor Specific Details *********");
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Specialization: " + specialization);
        System.out.println("Qualification: " + qualification);
        System.out.println("Experience: " + experienceYears + " years");
        System.out.println("Department: " + departmentId);
        System.out.println("Consultation Fee: " + consultationFee);
        System.out.println("Assigned Patients: " + assignedPatients);
        System.out.println("********************************");

    }

    @Override
    public void displaySummary() {
        System.out.println("********** DOCTOR SUMMERY DETAILS *********");
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Specialization: " + specialization);
        System.out.println("Department: " + departmentId);
        System.out.println("********************************");
    }

    public void assignPatient(String patientId) {
        if (assignedPatients != null) {
            assignedPatients.add(patientId);
            System.out.println("Patient " + patientId + "assigned to Dr. " + getLastName());
        }

    }

    public void removePatient(String patientId) {
        if (assignedPatients != null) {
            assignedPatients.remove(patientId);
            System.out.println("Patient" + patientId + "Removed");
        } else {
            System.out.println("Patient not found in assigned list");
        }

    }

    public void updateAvailability(String newSlot) {
        if (availableSlots != null) {
            availableSlots.add(newSlot);
            System.out.println("New availability slot added: ");
        }

    }

    public boolean isAvailable() {

        return available;
    }

    public void setAvailable(boolean available) {

        this.available = available;
    }

    public void updateFee(double fee){
        this.consultationFee = fee;
        System.out.println("Consultation fee updated to: "+ fee);
    }

    public void updateFee(double fee, String reason){
        this.consultationFee = fee;
        System.out.println("Consultation fee updated to: " + fee + ". Reason: " + reason);
    }

    public void addAvailability(String slot) {
        if (this.availableSlots != null) {
            this.availableSlots.add(slot);
            System.out.println("Added availability slot: " + slot);
        }
    }

    public void addAvailability(List<String> slots) {
        if (this.availableSlots != null && slots != null) {
            this.availableSlots.addAll(slots);
            System.out.println("Added " + slots.size() + " new availability slots.");
        }
    }
}
