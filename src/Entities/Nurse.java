package Entities;

import java.util.List;

public class Nurse {
    private String doctorId;
    private String specialization;
    private String qualification;
    private int experienceYears;
    private String departmentId;
    private double consultationFee;
    private List availableSlots;
    private List assignedPatients;

    public Nurse(String doctorId, String specialization, String qualification, int experienceYears, String departmentId, double consultationFee, List availableSlots, List assignedPatients) {
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.qualification = qualification;
        this.experienceYears = experienceYears;
        this.departmentId = departmentId;
        this.consultationFee = consultationFee;
        this.availableSlots = availableSlots;
        this.assignedPatients = assignedPatients;
    }
}
