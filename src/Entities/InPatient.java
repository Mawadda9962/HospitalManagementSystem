package Entities;

import Interfaces.Billable;
import Interfaces.Displayable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class InPatient extends patient implements Displayable, Billable {
    private LocalDate admissionDate; //Entering day
    private LocalDate dischargeDate; //Exit day
    private String roomNumber;
    private String bedNumber;
    private String admittingDoctorId;
    private double dailyCharges; //Price


    public InPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String specialization, String qualification, int experienceYears, String departmentId, double consultationFee, List<String> availableSlots, List<String> assignedPatients, String patientId, String bloodGroup, List<String> emergencyContact, LocalDate registrationDate, String insuranceId, List<String> medicalRecords, List<String> appointments, LocalDate dischargeDate, LocalDate admissionDate, String roomNumber, String bedNumber, String admittingDoctorId, double dailyCharges) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients, patientId, bloodGroup, emergencyContact, registrationDate, insuranceId, medicalRecords, appointments);
        this.dischargeDate = dischargeDate;
        this.admissionDate = admissionDate;
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.admittingDoctorId = admittingDoctorId;
        this.dailyCharges = dailyCharges;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getAdmittingDoctorId() {
        return admittingDoctorId;
    }

    public void setAdmittingDoctorId(String admittingDoctorId) {
        this.admittingDoctorId = admittingDoctorId;
    }

    public double getDailyCharges() {
        return dailyCharges;
    }

    public void setDailyCharges(double dailyCharges) {
        this.dailyCharges = dailyCharges;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Admission Date: " + admissionDate);
        System.out.println("Room/Bed: " + roomNumber + " / " + bedNumber);
        System.out.println("Daily Rate: " + dailyCharges);

    }

    @Override
    public void displaySummary() {
        System.out.println("In-Patient: " + getFirstName() + " " + getLastName());
        System.out.println("Room: " + roomNumber + "dmitted: " + admissionDate);
    }

    public long calculateStayDuration() {
        LocalDate end = (dischargeDate != null) ? dischargeDate : LocalDate.now();
        return ChronoUnit.DAYS.between(admissionDate, end);
    }


    //getting the number of days * price per day for the room
    public double calculateTotalCharges() {

        return calculateStayDuration() * dailyCharges;
    }

    @Override
    public void calculateCharges() {
        double total = calculateTotalCharges();
        System.out.println("Stay Duration : " + calculateStayDuration() + " days");
        System.out.println("Daily Rate    : " + getDailyCharges());
        System.out.println("Total Charges : " + total);
    }

    @Override
    public void generateBill() {
        System.out.println("********** BILL SUMMARY ***********");
        System.out.println("Patient   : " + getFirstName() + " " + getLastName());
        System.out.println("Room      : " + getRoomNumber() + " / Bed: " + getBedNumber());
        System.out.println("Admitted  : " + getAdmissionDate());
        System.out.println("Discharge : " + (getDischargeDate() != null ? getDischargeDate() : "Still Admitted"));
        // Call calculateCharges() since we already implemented it above
        calculateCharges();
        System.out.println("***************************");

    }

    @Override
    public void processPayment(double amount) {
        double totalDue = calculateTotalCharges();
        if (amount >= totalDue) {
            System.out.println("Payment of " + amount + " received. Bill fully paid.");
            System.out.println("Change returned: " + (amount - totalDue));
        } else {
            System.out.println("Payment of " + amount + " received.");
            System.out.println("Remaining balance: " + (totalDue - amount));
        }
    }

    //Default Constructor
    public InPatient() {

    }
}




