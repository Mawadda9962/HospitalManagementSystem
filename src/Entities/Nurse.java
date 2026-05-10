package Entities;

import java.util.List;

public class Nurse extends Person {

    private String nurseId;
    private String departmentId;
    private String shift;
    private String qualification;
    private List<String> assignedPatients;


    public Nurse(String id, String firstName, String lastName, String dateOfBirth, String gender, String phoneNumber, String email, String address, String nurseId, String departmentId, String shift, String qualification, List assignedPatients) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.nurseId = nurseId;
        this.departmentId = departmentId;
        this.shift = shift;
        this.qualification = qualification;
        this.assignedPatients = assignedPatients;
    }

    @Override
    public void displayInfo(){
        super.displayInfo(); // Calls Person's displayInfo
        System.out.println("--- Nurse Specific Details ---");
        System.out.println("Nurse ID: " + nurseId);
        System.out.println("Department ID: " + departmentId);
        System.out.println("Shift: " + shift);
        System.out.println("Qualification: " + qualification);
        System.out.println("Assigned Patients: " + assignedPatients);
        System.out.println("------------------------------");

    }

    @Override
    public String toString() {
        return "Nurse{" +
                "nurseId='" + nurseId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", shift='" + shift + '\'' +
                ", qualification='" + qualification + '\'' +
                ", assignedPatients=" + assignedPatients +
                '}';
    }
}
