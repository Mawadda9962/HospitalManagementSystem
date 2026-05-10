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

    @Override
    public void displayInfo(){


    }

    public void addMedicalRecord(String medicalRecorde){
        medicalRecords.add(medicalRecorde);

    }

    public void addAppointment(String appoinment){
        appointments.add(appoinment);

    }
    public void updateInsurance(String newInsuranceId){
        if (insuranceId != null){
            this.insuranceId =newInsuranceId;
        }


    }

}



