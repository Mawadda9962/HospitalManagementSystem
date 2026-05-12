package Entities;

import Interfaces.Displayable;

import java.util.List;

public class Consultant extends Doctor implements Displayable {
    private List<String> consultationTypes;
    private boolean onlineConsultationAvailable;
    private int consultationDuration;


    public Consultant(String id, String firstName, String lastName, String dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, double consultationFee, List<String> availableSlots, List<String> assignedPatients, List<String> consultationTypes, boolean onlineConsultationAvailable, int consultationDuration) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients);
        this.consultationTypes = consultationTypes;
        this.onlineConsultationAvailable = onlineConsultationAvailable;
        this.consultationDuration = consultationDuration;
    }

    public List<String> getConsultationTypes() {
        return consultationTypes;
    }

    public void setConsultationTypes(List<String> consultationTypes) {
        this.consultationTypes = consultationTypes;
    }

    public boolean isOnlineConsultationAvailable() {
        return onlineConsultationAvailable;
    }

    public void setOnlineConsultationAvailable(boolean onlineConsultationAvailable) {
        this.onlineConsultationAvailable = onlineConsultationAvailable;
    }

    public int getConsultationDuration() {
        return consultationDuration;
    }

    public void setConsultationDuration(int consultationDuration) {
        this.consultationDuration = consultationDuration;
    }

    @Override
    public void displayInfo() {
        System.out.println("ID : " + getId() );
        System.out.println("First Name: " + getFirstName() );
        System.out.println("Last Name: " + getLastName() );
        System.out.println("Date of birth: " + getDateOfBirth() );
        System.out.println("Gender: " + getGender() );
        System.out.println("Phone Number: " + getPhoneNumber() );
        System.out.println("Email: " + getEmail() );
        System.out.println("Address: " + getAddress());
        System.out.println("doctor Id : " + getDoctorId() );
        System.out.println("specialization : " + getSpecialization() );
        System.out.println("qualification : " + getQualification() );
        System.out.println("experience Years: " + getExperienceYears() );
        System.out.println("department Id : " + getDepartmentId());
        System.out.println("consultation Fee: " + getConsultationFee());
        System.out.println("available Slots : " + getAvailableSlots());
        System.out.println("assigned Patients : " + getAssignedPatients());
        System.out.println("consultation Types : " + getConsultationTypes());
        System.out.println("consultation Duration : " + getConsultationDuration());
    }

    @Override
    public void displaySummary() {


    }


    public void scheduleConsultation(){
        System.out.println("Scheduling a new consultation with Dr. " + getLastName());
        System.out.println("Standard Duration: " + consultationDuration + " minutes.");
        System.out.println("Available Types: " + consultationTypes);

    }
    public void provideSecondOpinion(String caseDetails){
        System.out.println("Consultant Dr. " + getLastName() + " is providing a second opinion.");
        System.out.println("Case Details Reviewed: " + caseDetails);
        System.out.println("Status: Finalizing Medical Report...");


    }


}
