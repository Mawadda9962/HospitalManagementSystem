package Entities;

import java.time.LocalDate;
import java.util.List;

public class Patient extends Person{

    private String patientId;
    private String bloodGroup;
    private List emergencyContact;
    private LocalDate registrationDate;
    private String insuranceId;
    private List medicalRecords;
    private List appointments;

    public Patient(String id, String firstName, String lastName, String dateOfBirth, String gender, String phoneNumber, String email, String address, String patientId, String bloodGroup, List emergencyContact, LocalDate registrationDate, String insuranceId, List medicalRecords, List appointments) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.patientId = patientId;
        this.bloodGroup = bloodGroup;
        this.emergencyContact = emergencyContact;
        this.registrationDate = registrationDate;
        this.insuranceId = insuranceId;
        this.medicalRecords = medicalRecords;
        this.appointments = appointments;
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

    public List getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(List emergencyContact) {
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

    public List getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public List getAppointments() {
        return appointments;
    }

    public void setAppointments(List appointments) {
        this.appointments = appointments;
    }

    @Override
    public void displayInfo(){

    }

    public void addMedicalRecord(){

    }

    public void

}



