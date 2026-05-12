package Entities;

import Interfaces.Displayable;

import java.util.List;

public class Surgeon extends Doctor implements Displayable {
    private int surgeriesPerformed;
    private List<String> surgeryTypes;
    private boolean operationTheatreAccess;

    public Surgeon(String id, String firstName, String lastName, String dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, double consultationFee, List<String> availableSlots, List<String> assignedPatients, int surgeriesPerformed, List<String> surgeryTypes, boolean operationTheatreAccess) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients);
        this.surgeriesPerformed = surgeriesPerformed;
        this.surgeryTypes = surgeryTypes;
        this.operationTheatreAccess = operationTheatreAccess;
    }

    public int getSurgeriesPerformed() {
        return surgeriesPerformed;
    }

    public void setSurgeriesPerformed(int surgeriesPerformed) {
        this.surgeriesPerformed = surgeriesPerformed;
    }

    public List<String> getSurgeryTypes() {
        return surgeryTypes;
    }

    public void setSurgeryTypes(List<String> surgeryTypes) {
        this.surgeryTypes = surgeryTypes;
    }

    public boolean isOperationTheatreAccess() {
        return operationTheatreAccess;
    }

    public void setOperationTheatreAccess(boolean operationTheatreAccess) {
        this.operationTheatreAccess = operationTheatreAccess;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("--- Surgical Department Details ---");
        System.out.println("Surgeries Performed : " + surgeriesPerformed);
        System.out.println("Specialized in      : " + surgeryTypes);
        System.out.println("OT Access Granted   : " + (operationTheatreAccess ? "Yes" : "No"));
        System.out.println("===================================");

    }

    @Override
    public void displaySummary(){
        System.out.println("Surgeon: Dr. " + getLastName());
        System.out.println("Specialty: " + getSpecialization());
        System.out.println("Total Surgeries: " + surgeriesPerformed);     ;

    }

    public void performSurgery(String surgeryType, String patientName) {
        if (operationTheatreAccess) {
            System.out.println("Dr. " + getLastName() + " is performing " + surgeryType + " on patient: " + patientName);
            updateSurgeryCount();
        } else {
            System.out.println("Access Denied: Dr. " + getLastName() + " does not have Operation Theatre access.");
        }

    }

    public void updateSurgeryCount(){
        this.surgeriesPerformed++;
        System.out.println("Surgery count updated. Total for Dr. " + getLastName() + ": " + surgeriesPerformed);
    }

}
