package Entities;

import java.awt.*;
import java.util.List;

public class Surgeon extends Doctor{

    private int surgeriesPerformed;
    private List surgeryTypes;
    private boolean operationTheatreAccess;

    public Surgeon(String doctorId, String firstName, String lastName, String dateOfBirth, String gender, String phoneNumber, String email, String address, String specialization, String qualification, int experienceYears, String departmentId, double consultationFee, List<String> availableSlots, List<String> assignedPatients, int surgeriesPerformed, List surgeryTypes, boolean operationTheatreAccess) {
        super(doctorId, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients);
        this.surgeriesPerformed = surgeriesPerformed;
        this.surgeryTypes = surgeryTypes;
        this.operationTheatreAccess = operationTheatreAccess;
    }
}
