package Entities;

import java.util.List;

public class Patient extends Person{

    private String patientId;
    private String bloodGroup;
    private List emergencyContact;
    private String registrationDate;
    private String insuranceId;
    private List medicalRecords;
    private List appointments;


    public Patient(String id, String firstName, String lastName, String dateOfBirth, String gender, String phoneNumber, String email, String address, String patientId, String bloodGroup, List emergencyContact, String registrationDate, String insuranceId, List medicalRecords, List appointments) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.patientId = patientId;
        this.bloodGroup = bloodGroup;
        this.emergencyContact = emergencyContact;
        this.registrationDate = registrationDate;
        this.insuranceId = insuranceId;
        this.medicalRecords = medicalRecords;
        this.appointments = appointments;
    }


}




}
}
