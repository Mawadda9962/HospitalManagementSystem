package Entities;

import Utiles.Constant;
import java.time.LocalDate;
import java.util.List;

public class patient extends Person {

    private String patientId;
    private String bloodGroup;
    private List<String> emergencyContact;
    private LocalDate registrationDate;
    private String insuranceId;
    private List<String> medicalRecords;
    private List<String> appointments;

    public patient(String id, String firstName, String lastName, String dateOfBirth, String gender, String phoneNumber, String email, String address, String specialization, String qualification, int experienceYears, String departmentId, double consultationFee, List<String> availableSlots, List<String> assignedPatients, String patientId, String bloodGroup, List<String> emergencyContact, LocalDate registrationDate, String insuranceId, List<String> medicalRecords, List<String> appointments) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients);
        this.patientId = patientId;
        this.bloodGroup = bloodGroup;
        this.emergencyContact = emergencyContact;
        this.registrationDate = registrationDate;
        this.insuranceId = insuranceId;
        this.medicalRecords = medicalRecords;
        this.appointments = appointments;
    }

    public patient() {
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public List<String> getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(List<String> emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public List<String> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<String> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public List<String> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<String> appointments) {
        this.appointments = appointments;
    }

    @Override
    public void displayInfo() {
        // Person info (Name, Phone, etc.)
        System.out.println(" Personal Details");
        System.out.println("Name: " + getFirstName() + " " + getLastName());

        System.out.println("Patient Specific Details");
        System.out.println("Patient ID: " + patientId);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Insurance ID: " + insuranceId);
        System.out.println("Registration Date: " + registrationDate);
        System.out.println("Medical Records Count: " + (medicalRecords != null ? medicalRecords.size() : 0));
        System.out.println("Upcoming Appointments: " + (appointments != null ? appointments.size() : 0));
        System.out.println("--------------------------------");
    }

    public void addMedicalRecord(String medicalRecorde) {
        if (this.medicalRecords != null) {
            this.medicalRecords.add(medicalRecorde);
        }
    }

    public void addAppointment(String appointment) {
        if (this.appointments != null) {
            this.appointments.add(appointment);
        }
    }

    public void updateInsurance(String newInsuranceId) {
        this.insuranceId = newInsuranceId;
        System.out.println(Constant.INSURANCE_UPDATED_SUCCESSFULLY);
    }
}