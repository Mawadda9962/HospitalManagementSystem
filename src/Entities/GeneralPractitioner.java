package Entities;

import Interfaces.Displayable;

import javax.tools.Diagnostic;
import java.time.LocalDate;
import java.util.List;

public class GeneralPractitioner extends Doctor  {
    private boolean walkinAvailable;
    private boolean homeVisitAvailable;
    private boolean vaccinationCertified;

    public GeneralPractitioner(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String specialization, String qualification, int experienceYears, String departmentId, double consultationFee, List<String> availableSlots, List<String> assignedPatients, String doctorId, String specialization1, String qualification1, int experienceYears1, String departmentId1, double consultationFee1, List<String> availableSlots1, List<String> assignedPatients1, boolean available, boolean walkinAvailable, boolean homeVisitAvailable, boolean vaccinationCertified) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients, doctorId, specialization1, qualification1, experienceYears1, departmentId1, consultationFee1, availableSlots1, assignedPatients1, available);
        this.walkinAvailable = walkinAvailable;
        this.homeVisitAvailable = homeVisitAvailable;
        this.vaccinationCertified = vaccinationCertified;
    }

    public void setWalkinAvailable(boolean walkinAvailable) {
        this.walkinAvailable = walkinAvailable;
    }

    public void setHomeVisitAvailable(boolean homeVisitAvailable) {
        this.homeVisitAvailable = homeVisitAvailable;
    }

    public void setVaccinationCertified(boolean vaccinationCertified) {
        this.vaccinationCertified = vaccinationCertified;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();

        System.out.println("******** GP Specific Services **********");
        System.out.println("Walk-in Appointments : " + (walkinAvailable ? "Yes" : "No"));
        System.out.println("Home Visits          : " + (homeVisitAvailable ? "Available" : "Not Available"));
        System.out.println("Vaccination Certified: " + (vaccinationCertified ? "Certified" : "Not Certified"));
        System.out.println("******************************");

    }

    @Override
    public void displaySummary(){
        System.out.println("******** GP SUMMERY **********");
        System.out.println("Walk-in Appointments : " + (walkinAvailable ? "Yes" : "No"));
        System.out.println("Home Visits          : " + (homeVisitAvailable ? "Available" : "Not Available"));
    }

    public void scheduleHomeVisit(String address){
        if (homeVisitAvailable) {
            System.out.println("Home visit scheduled with Dr. " + getLastName() + " to address: " + address);
        } else {
            System.out.println("Sorry, Dr. " + getLastName() + " does not provide home visits.");
        }
    }

    public void administerVaccine(String vaccineName){
        if (vaccinationCertified) {
            System.out.println("Administering " + vaccineName + " vaccine by Dr. " + getLastName());
        } else {
            System.out.println("Error: This doctor is not certified to administer vaccines.");
        }
    }
}
