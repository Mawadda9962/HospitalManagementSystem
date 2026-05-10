package Entities;

import java.time.LocalDate;

public class MedicalRecord {
    private String recordId;
    private String patientId;
    private String doctorId;
    private LocalDate visitDate;
    private String diagnosis;
    private String prescription;
    private String testResults;
    private String notes;

    public MedicalRecord(String patientId, String recordId, String doctorId, LocalDate visitDate, String diagnosis, String prescription, String notes, String testResults) {
        this.patientId = patientId;
        this.recordId = recordId;
        this.doctorId = doctorId;
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.notes = notes;
        this.testResults = testResults;
    }
}
