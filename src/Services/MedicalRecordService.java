package Services;

import Entities.MedicalRecord;
import Interfaces.Manageable;
import Interfaces.Searchable;
import Utiles.Constant;
import Utiles.HelperUtils;
import Utiles.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordService extends Base implements Manageable, Searchable {

    private static Scanner scanner = new Scanner(System.in);

    private static List<MedicalRecord> medicalRecords = new ArrayList<>();

    public void addMedicalRecord() {
        System.out.println("********** Add New Medical Record **********");

        System.out.print("Enter Record ID: ");
        String recordId = scanner.nextLine().trim();

        if (HelperUtils.isNotNull(getRecordById(recordId))) {
            System.out.println("A record with this ID already exists.");
            return;
        }

        String patientId = InputHandler.getStringInput("Enter Patient ID");
        String doctorId = InputHandler.getStringInput("Enter Doctor ID");
        String diagnosis = InputHandler.getStringInput("Enter Diagnosis");
        String prescription = InputHandler.getStringInput("Enter Prescription");
        String testResults = InputHandler.getStringInput("Enter Test Results");
        String notes = InputHandler.getStringInput("Enter Additional Notes");


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
            if (HelperUtils.isNotNull(mr) && mr.getRecordId().equals(recordId)) {
                return mr;
            }
        }
        return null;
    }

    public void editMedicalRecord(String recordId) {
        MedicalRecord mr = getRecordById(recordId);
        if (HelperUtils.isNull(mr)) {
            System.out.println("Medical Record with ID " + recordId + " not found.");
            return;
        }

        mr.setDiagnosis(InputHandler.getStringInput("Enter updated Diagnosis"));
        mr.setPrescription(InputHandler.getStringInput("Enter updated Prescription"));
        mr.setTestResults(InputHandler.getStringInput("Enter updated Test Results"));
        mr.setNotes(InputHandler.getStringInput("Enter updated Notes"));

        System.out.println(Constant.RECORD_UPDATED_SUCCESSFULLY);
    }

    public void removeMedicalRecord(String recordId) {
        MedicalRecord mr = getRecordById(recordId);
        if (HelperUtils.isNotNull(mr)) {
            medicalRecords.remove(mr);
            System.out.println(Constant.RECORD_REMOVE_SUCCESSFULLY);
        } else {
            System.out.println("Medical Record not found.");
        }
    }

    public void displayPatientHistory(String patientId) {
        String searchId = HelperUtils.isNotNull(patientId) ? patientId.trim() : "";        System.out.println("MEDICAL HISTORY FOR PATIENT: " + patientId);
        boolean found = false;
        for (MedicalRecord mr : medicalRecords) {
            if (mr.getPatientId().trim().equalsIgnoreCase(searchId)) {
                mr.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No medical records found for this patient.");
        }
    }

    public void getRecordsByDoctorId(String doctorId) {
        System.out.println("Records created by Doctor: " + doctorId);
        boolean found = false;
        for (MedicalRecord mr : medicalRecords) {
            if (HelperUtils.isNotNull(mr) && mr.getDoctorId().equalsIgnoreCase(doctorId)) {                mr.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No records found for this Doctor.");
    }

    public void generateHistoryReport(String patientId) {
        System.out.println("Date: " + LocalDate.now());
        System.out.println("Patient ID: " + patientId);
        boolean found = false;
        for (MedicalRecord mr : medicalRecords) {
            if (HelperUtils.isNotNull(mr) && mr.getPatientId().equalsIgnoreCase(patientId)) {
                mr.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No history records found for this patient.");
        }
    }


    @Override
    public void add(Object entity) {
        if (entity instanceof MedicalRecord) {
            MedicalRecord mr = (MedicalRecord) entity;
            if (HelperUtils.isNotNull(mr)) {
                medicalRecords.add(mr);
                System.out.println("Medical Record added for Patient: " + mr.getPatientId());
            }
        } else {
            System.out.println("Invalid entity type. Expected a MedicalRecord object.");
        }
    }

    @Override
    public void remove(String id) {
        removeMedicalRecord(id);
    }

    @Override
    public void getAll() {
        if (medicalRecords.isEmpty()) {
            System.out.println("No medical records found.");
            return;
        }
        for (MedicalRecord mr : medicalRecords) {
            if (HelperUtils.isNotNull(mr)) {
                mr.displayInfo();
            }
        }
    }

    @Override
    public void search(String keyword) {
        boolean found = false;
        for (MedicalRecord mr : medicalRecords) {
            if (HelperUtils.isNotNull(mr)) {
                if (mr.getPatientId().equalsIgnoreCase(keyword)
                        || mr.getRecordId().equalsIgnoreCase(keyword)
                        || mr.getDiagnosis().contains(keyword)) {
                    mr.displayInfo();
                    found = true;
                }
            }
        }
        if (!found) System.out.println("No matching records found for keyword: " + keyword);
    }

    @Override
    public void searchById(String id) {
        MedicalRecord mr = getRecordById(id);
        if (HelperUtils.isNotNull(mr)) {
            mr.displayInfo();
        } else {
            System.out.println("No record found with ID: " + id);
        }
    }

    public Boolean handleMedicalRecordMenu(Integer option) {
        switch (option) {
            case 1 -> addMedicalRecord();
            case 2 -> getAll();
            case 3 -> {
                String pId = InputHandler.getStringInput("Enter Patient ID");
                displayPatientHistory(pId);
            }
            case 4 ->{
                String dId = InputHandler.getStringInput("Enter Doctor ID");
                getRecordsByDoctorId(dId);
            }
            case 5 -> {
                String rId = InputHandler.getStringInput("Enter Record ID to update");
                editMedicalRecord(rId);
            }
            case 6 -> {
                String rId = InputHandler.getStringInput("Enter Record ID to delete");
                removeMedicalRecord(rId);
            }
            case 7 -> { // 5.7 Generate Patient History Report
                String pId = InputHandler.getStringInput("Enter Patient ID for Report");
                generateHistoryReport(pId);
            }
            case 8 -> {
                return false;
            }
            default -> System.out.println("Invalid option.");
        }
        return true;
    }
}