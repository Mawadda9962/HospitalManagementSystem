package Entities;

import java.time.LocalDate;

public class InPatient {
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private String roomNumber;
    private String bedNumber;
    private String admittingDoctorId;
    private double dailyCharges;

    public InPatient(LocalDate dischargeDate, LocalDate admissionDate, String roomNumber, String bedNumber, String admittingDoctorId, double dailyCharges) {
        this.dischargeDate = dischargeDate;
        this.admissionDate = admissionDate;
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.admittingDoctorId = admittingDoctorId;
        this.dailyCharges = dailyCharges;
    }


}
