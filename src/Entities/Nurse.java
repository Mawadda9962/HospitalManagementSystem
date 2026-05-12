package Entities;

import Interfaces.Displayable;

import java.util.List;

public class Nurse extends Person implements Displayable {

    private String nurseId;
    private String departmentId;
    private String shift;
    private String qualification;
    private List<String> assignedPatients;


    public Nurse(String id, String firstName, String lastName, String dateOfBirth, String gender, String phoneNumber, String email, String address, String specialization, String qualification, int experienceYears, String departmentId, double consultationFee, List<String> availableSlots, List<String> assignedPatients, String nurseId, String departmentId1, String shift, String qualification1, List<String> assignedPatients1) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients);
        this.nurseId = nurseId;
        this.departmentId = departmentId1;
        this.shift = shift;
        this.qualification = qualification1;
        this.assignedPatients = assignedPatients1;
    }

    public String getNurseId() {
        return nurseId;
    }

    public void setNurseId(String nurseId) {
        this.nurseId = nurseId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public List<String> getAssignedPatients() {
        return assignedPatients;
    }

    public void setAssignedPatients(List<String> assignedPatients) {
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
    public void displaySummary() {

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
