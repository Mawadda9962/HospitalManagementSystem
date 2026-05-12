package Entities;

import java.time.LocalDate;

public class Appointment {
    private String appointmentId;
    private String patientId;
    private String doctorId;
    private LocalDate appointmentDate;
    private String appointmentTime;
    private String status;
    private String reason;
    private String notes;

    public Appointment(String appointmentId, String patientId, String doctorId, LocalDate appointmentDate, String appointmentTime, String status, String reason, String notes) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
        this.reason = reason;
        this.notes = notes;
    }

    public Appointment() {
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void displayInfo(){
        System.out.println("======= APPOINTMENT DETAILS =======");
        System.out.println("ID        : " + appointmentId);
        System.out.println("Status    : " + status);
        System.out.println("Date/Time : " + appointmentDate + " at " + appointmentTime);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Doctor ID : " + doctorId);
        System.out.println("Reason    : " + reason);
        if (notes != null && !notes.isEmpty()) {
            System.out.println("Notes     : " + notes);
        }
        System.out.println("===================================");

    }

    public void reschedule(LocalDate newData, String newTime){
        this.appointmentDate = newData;
        this.appointmentTime = newTime;
        this.status = "Rescheduled";
        System.out.println("Appointment has been rescheduled");


    }

    public void cancel(){
        this.status = "Cancelled";
        System.out.println("Appointment " + appointmentId + "has been cancelled");

    }
    public void complete(){
        this.status = "Complete";
        System.out.println("Appointment " + appointmentId + "has been completed");

    }

    public void addNotes(String notes){
        if (this.notes == null || this.notes.isEmpty()){
            this.notes =notes;
        }else {
            this.notes += notes;
        }
        System.out.println("Simple note added to appointment");
    }





}
