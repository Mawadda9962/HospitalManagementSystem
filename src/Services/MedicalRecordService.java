package Services;

import Entities.MedicalRecord;
import Utiles.Constant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordService {

    private static final Scanner scanner = new Scanner(System.in);

    private static final List<MedicalRecord> medicalRecords = new ArrayList<>();

    public void addMedicalRecord() {
        System.out.println("********** Add New Medical Record **********");

        System.out.print("Enter Record ID: ");
        String recordId = scanner.nextLine().trim();

        if (getRecordById(recordId) != null) {
            System.out.println("A record with this ID already exists.");
            return;
        }

        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine().trim();

        System.out.print("Enter Doctor ID: ");
        String doctorId = scanner.nextLine().trim();

        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine().trim();

        System.out.print("Enter Prescription: ");
        String prescription = scanner.nextLine().trim();

        System.out.print("Enter Test Results: ");
        String testResults = scanner.nextLine().trim();

        System.out.print("Enter Additional Notes: ");
        String notes = scanner.nextLine().trim();

        LocalDate visitDate = LocalDate.now();

        MedicalRecord newRecord = new MedicalRecord(
                patientId,
                recordId,
                doctorId,
                visitDate,
                diagnosis,
                prescription,
                notes,
                testResults
        );

        medicalRecords.add(newRecord);
        System.out.println(Constant.RECORD_ADDED_SUCCESSFULLY);
    }

    public MedicalRecord getRecordById(String recordId) {
        for (MedicalRecord mr : medicalRecords) {
            if (mr.getRecordId().equals(recordId)) {
                return mr;
            }
        }
        return null;
    }

    public void editMedicalRecord(String recordId) {
        MedicalRecord mr = getRecordById(recordId);
        if (mr == null) {
            System.out.println("Medical Record with ID " + recordId + " not found.");
            return;
        }

        System.out.println("--- Editing Record: " + recordId + " ---");

        System.out.print("Enter updated Diagnosis: ");
        mr.setDiagnosis(scanner.nextLine());

        System.out.print("Enter updated Prescription: ");
        mr.setPrescription(scanner.nextLine());

        System.out.print("Enter updated Test Results: ");
        mr.setTestResults(scanner.nextLine());

        System.out.print("Enter updated Notes: ");
        mr.setNotes(scanner.nextLine());

        System.out.println(Constant.RECORD_UPDATED_SUCCESSFULLY);
    }

    public void removeMedicalRecord(String recordId) {
        MedicalRecord mr = getRecordById(recordId);
        if (mr != null) {
            medicalRecords.remove(mr);
            System.out.println(Constant.RECORD_REMOVE_SUCCESSFULLY);
        } else {
            System.out.println("Medical Record not found.");
        }
    }

    public void displayPatientHistory(String patientId) {
        System.out.println("\n========== MEDICAL HISTORY FOR PATIENT: " + patientId + " ==========");
        boolean found = false;
        for (MedicalRecord mr : medicalRecords) {
            if (mr.getPatientId().equalsIgnoreCase(patientId)) {
                mr.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No medical records found for this patient.");
        }
    }

    public void getRecordsByDoctorId(String doctorId) {
        System.out.println("\n--- Records created by Doctor: " + doctorId + " ---");
        boolean found = false;
        for (MedicalRecord mr : medicalRecords) {
            if (mr.getDoctorId().equalsIgnoreCase(doctorId)) {
                mr.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No records found for this Doctor.");
    }

    public Boolean handleMedicalRecordMenu(Integer option) {
        switch (option) {
            case 1 -> addMedicalRecord();
            case 2 -> {
                System.out.print("Enter Record ID to edit: ");
                editMedicalRecord(scanner.nextLine().trim());
            }
            case 3 -> {
                System.out.print("Enter Record ID to remove: ");
                removeMedicalRecord(scanner.nextLine().trim());
            }
            case 4 -> {
                System.out.print("Enter Patient ID to view history: ");
                displayPatientHistory(scanner.nextLine().trim());
            }
            case 5 -> {
                System.out.print("Enter Doctor ID to view records: ");
                getRecordsByDoctorId(scanner.nextLine().trim());
            }
            case 6 -> { return false; }
            default -> System.out.println("Invalid option.");
        }
        return true;
    }
}