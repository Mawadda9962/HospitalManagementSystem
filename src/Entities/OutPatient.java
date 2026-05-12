package Entities;

import java.time.LocalDate;
import java.util.List;

public class OutPatient extends patient {
    private int visitCount;
    private LocalDate lastVisitDate;
    private String preferredDoctorId;


    public OutPatient(String id, String firstName, String lastName, String dateOfBirth, String gender, String phoneNumber, String email, String address, String specialization, String qualification, int experienceYears, String departmentId, double consultationFee, List<String> availableSlots, List<String> assignedPatients, String patientId, String bloodGroup, List<String> emergencyContact, LocalDate registrationDate, String insuranceId, List<String> medicalRecords, List<String> appointments, int visitCount, LocalDate lastVisitDate, String preferredDoctorId) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients, patientId, bloodGroup, emergencyContact, registrationDate, insuranceId, medicalRecords, appointments);
        this.visitCount = visitCount;
        this.lastVisitDate = lastVisitDate;
        this.preferredDoctorId = preferredDoctorId;
    }


    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public LocalDate getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(LocalDate lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public String getPreferredDoctorId() {
        return preferredDoctorId;
    }

    public void setPreferredDoctorId(String preferredDoctorId) {
        this.preferredDoctorId = preferredDoctorId;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Visit Count: " + visitCount);
        System.out.println("Last Visit: " + lastVisitDate);
        System.out.println("Preferred Doctor ID: " + preferredDoctorId);
    }

    //scheduling a future visit
    public void scheduleFollowUp(){
        System.out.println("Follow-up scheduled for Patient ID: " + getPatientId());
    }

    //updates the internal data of the object to reflect a new visit
    public void updateVisitCount(){
        this.visitCount++;
        this.lastVisitDate = LocalDate.now();
    }


}
