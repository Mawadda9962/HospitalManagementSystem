package Entities;

import java.util.List;

public class Patient extends Person{

    private String patientId;
    private String bloodGroup;
    private List emergencyContact;


    public Patient(String id, String firstName, String lastName, String dateOfBirth, String gender, String phoneNumber, String email, String address) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
    }




}
}
