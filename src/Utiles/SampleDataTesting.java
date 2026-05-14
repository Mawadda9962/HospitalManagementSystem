package Utiles;

import Entities.*;
import Services.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SampleDataTesting {
    public static void Testing() {

        DoctorService doctorService = new DoctorService();
        DepartmentService departmentService = new DepartmentService();
        PatientService patientService = new PatientService();
        MedicalRecordService medicalRecordService = new MedicalRecordService();
        AppointmentService appointmentService = new AppointmentService();


        // DEPARTMENTS
        departmentService.add(new Department("Cardiology", "DEP-01", "DOC-101", new ArrayList<>(), new ArrayList<>(), 30, 30));
        departmentService.add(new Department("Neurology", "DEP-02", "DOC-102", new ArrayList<>(), new ArrayList<>(), 20, 20));
        departmentService.add(new Department("Emergency", "DEP-04", "DOC-104", new ArrayList<>(), new ArrayList<>(), 50, 50));

        // DOCTORS
        // Surgeons
        doctorService.add(new Surgeon("D101", "Mazen", "Al-Riyami", "1980-01-01", "Male", "98881122", "mazen@hosp.om", "Seeb", "DOC-101", "Cardiology", "PhD Surgery", 15, "DEP-01", 50.0, new ArrayList<>(), new ArrayList<>(), 45, new ArrayList<>(Arrays.asList("Bypass")), true));
        doctorService.add(new Surgeon("D103", "Said", "Al-Habsi", "1978-03-15", "Male", "92223344", "said@hosp.om", "Muscat", "DOC-103", "General Surgery", "MD Surgery", 20, "DEP-04", 60.0, new ArrayList<>(), new ArrayList<>(), 120, new ArrayList<>(Arrays.asList("Appendectomy")), true));

        // Consultants
        doctorService.add(new Consultant("D102", "Muna", "Al-Zadjali", "1985-05-12", "Female", "94443322", "muna@hosp.om", "Qurum", "DOC-102", "Neurology", "MD Neurology", 12, "DEP-02", 40.0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(Arrays.asList("Consultation")), true, 45));
        doctorService.add(new Consultant("D105", "Laila", "Al-Balushi", "1982-11-20", "Female", "95551122", "laila@hosp.om", "Barka", "DOC-105", "Cardiology", "MD Cardiology", 18, "DEP-01", 45.0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(Arrays.asList("Diagnostic")), false, 30));
        doctorService.add(new Consultant("D106", "Omar", "Al-Kindi", "1975-02-10", "Male", "96667788", "omar@hosp.om", "Nizwa", "DOC-106", "Internal Medicine", "MD Medicine", 25, "DEP-02", 55.0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(Arrays.asList("Follow-up")), true, 60));

        // GPs (Assuming base Doctor class represents GP)
        doctorService.add(new Doctor("D104", "Khalid", "Al-Farsi", "1990-06-20", "Male", "91112233", "khalid@hosp.om", "Sohar", "DOC-104", "General", "MBBS", 5, "DEP-04", 20.0, new ArrayList<>(), new ArrayList<>()));
        doctorService.add(new Doctor("D107", "Sara", "Al-Alawi", "1993-08-05", "Female", "93335566", "sara@hosp.om", "Sur", "DOC-107", "General", "MBBS", 3, "DEP-04", 20.0, new ArrayList<>(), new ArrayList<>()));
        doctorService.add(new Doctor("D108", "Fahad", "Al-Hasni", "1988-12-12", "Male", "94440099", "fahad@hosp.om", "Ibri", "DOC-108", "General", "MBBS", 8, "DEP-04", 25.0, new ArrayList<>(), new ArrayList<>()));


        // PATIENTS
        // In-Patients
        patientService.add(new InPatient("P300", "Salim", "Al-Rawahi", "1975-08-20", "Male", "92228877", "salim.r@example.om", "Ibra", "N/A", "N/A", 0, "DEP-01", 0.0, null, null, "P300", "B+", null, LocalDate.now(), "INS-001", null, null, LocalDate.of(2026, 5, 1), LocalDate.of(2026, 5, 10), "Room-105", "Bed-A2", "DOC-101", 25.5));
        patientService.add(new InPatient("P301", "Nasra", "Al-Maskari", "1960-04-10", "Female", "91114455", "nasra@example.om", "Manah", "N/A", "N/A", 0, "DEP-02", 0.0, null, null, "P301", "O+", null, LocalDate.now(), "INS-002", null, null, LocalDate.of(2026, 5, 5), null, "Room-202", "Bed-B1", "DOC-102", 30.0));
        patientService.add(new InPatient("P302", "Hamad", "Al-Shuaili", "1982-09-30", "Male", "99991122", "hamad@example.om", "Bahla", "N/A", "N/A", 0, "DEP-01", 0.0, null, null, "P302", "A-", null, LocalDate.now(), "INS-003", null, null, LocalDate.of(2026, 5, 12), null, "Room-106", "Bed-A1", "DOC-101", 25.5));

        // Out-Patients
        patientService.add(new OutPatient("P200", "Fatma", "Al-Zadjali", "1992-11-05", "Female", "95556677", "fatma@example.om", "Muscat", "General", "MBBS", 0, "DEP-01", 0.0, null, null, "P200", "O-", null, LocalDate.now(), "INS-102", null, null, 5, LocalDate.of(2026, 4, 10), "DOC-101"));
        patientService.add(new OutPatient("P201", "Ali", "Al-Harthi", "1988-01-20", "Male", "96660011", "ali@example.om", "Rustaq", "N/A", "N/A", 0, "DEP-02", 0.0, null, null, "P201", "AB+", null, LocalDate.now(), "INS-103", null, null, 2, LocalDate.of(2026, 3, 15), "DOC-102"));
        patientService.add(new OutPatient("P202", "Zuweina", "Al-Rawahi", "1995-07-14", "Female", "97772233", "zuw@example.om", "Samail", "N/A", "N/A", 0, "DEP-01", 0.0, null, null, "P202", "B-", null, LocalDate.now(), "INS-104", null, null, 1, LocalDate.of(2026, 5, 01), "DOC-105"));
        patientService.add(new OutPatient("P203", "Yousuf", "Al-Busaidi", "1980-12-05", "Male", "98884455", "yousuf@example.om", "Sohar", "N/A", "N/A", 0, "DEP-04", 0.0, null, null, "P203", "O+", null, LocalDate.now(), "INS-105", null, null, 10, LocalDate.of(2026, 5, 10), "DOC-104"));

        // Emergency Patients
        patientService.add(new EmergencyPatient("P400", "Ahmed", "Al-Balushi", "1988-03-12", "Male", "93334455", "ahmed.b@hosp.om", "Sohar", "N/A", "N/A", 0, "DEP-04", 0.0, null, null, "P400", "A-", null, LocalDate.now(), "GOV-01", null, null, LocalDate.now(), null, "ER-01", "B-05", "DOC-104", 50.0, "Heart Attack", "Ambulance", 1, true));
        patientService.add(new EmergencyPatient("P401", "Mariam", "Al-Sadi", "1998-05-25", "Female", "92225588", "mariam@hosp.om", "Muscat", "N/A", "N/A", 0, "DEP-04", 0.0, null, null, "P401", "O+", null, LocalDate.now(), "GOV-02", null, null, LocalDate.now(), null, "ER-02", "B-01", "DOC-103", 50.0, "Fracture", "Private Car", 3, true));
        patientService.add(new EmergencyPatient("P402", "Qassim", "Al-Majali", "1970-10-10", "Male", "91119900", "qassim@hosp.om", "Barka", "N/A", "N/A", 0, "DEP-04", 0.0, null, null, "P402", "B+", null, LocalDate.now(), "GOV-03", null, null, LocalDate.now(), null, "ER-03", "B-02", "DOC-104", 50.0, "Asthma", "Ambulance", 2, true));

        // APPOINTMENTS
        appointmentService.add(new Appointment("APP-001", "P300", "DOC-101", LocalDate.of(2026, 5, 20), "10:30 AM", "Scheduled", "Follow-up", "None"));
        appointmentService.add(new Appointment("APP-002", "P200", "DOC-101", LocalDate.of(2026, 5, 21), "09:00 AM", "Scheduled", "Consultation", "None"));
        appointmentService.add(new Appointment("APP-003", "P201", "DOC-102", LocalDate.of(2026, 5, 21), "11:00 AM", "Scheduled", "Neurology Check", "None"));
        appointmentService.add(new Appointment("APP-004", "P202", "DOC-105", LocalDate.of(2026, 5, 22), "08:30 AM", "Scheduled", "Heart Scan", "None"));
        appointmentService.add(new Appointment("APP-005", "P203", "DOC-104", LocalDate.of(2026, 5, 22), "01:00 PM", "Scheduled", "General", "None"));
        appointmentService.add(new Appointment("APP-006", "P301", "DOC-102", LocalDate.of(2026, 5, 23), "10:00 AM", "Scheduled", "Routine", "None"));
        appointmentService.add(new Appointment("APP-007", "P401", "DOC-103", LocalDate.of(2026, 5, 23), "12:00 PM", "Scheduled", "ER Followup", "None"));
        appointmentService.add(new Appointment("APP-008", "P302", "DOC-101", LocalDate.of(2026, 5, 24), "09:30 AM", "Scheduled", "Surgery Plan", "None"));
        appointmentService.add(new Appointment("APP-009", "P200", "DOC-105", LocalDate.of(2026, 5, 24), "11:30 AM", "Scheduled", "Cardio", "None"));
        appointmentService.add(new Appointment("APP-010", "P402", "DOC-104", LocalDate.of(2026, 5, 25), "08:00 AM", "Scheduled", "Breathing", "None"));
        appointmentService.add(new Appointment("APP-011", "P300", "DOC-101", LocalDate.of(2026, 6, 01), "10:30 AM", "Scheduled", "Checkup", "None"));
        appointmentService.add(new Appointment("APP-012", "P201", "DOC-106", LocalDate.of(2026, 6, 02), "02:00 PM", "Scheduled", "Internal", "None"));
        appointmentService.add(new Appointment("APP-013", "P202", "DOC-105", LocalDate.of(2026, 6, 03), "03:00 PM", "Scheduled", "Heart Check", "None"));
        appointmentService.add(new Appointment("APP-014", "P203", "DOC-108", LocalDate.of(2026, 6, 04), "09:00 AM", "Scheduled", "Flu", "None"));
        appointmentService.add(new Appointment("APP-015", "P400", "DOC-104", LocalDate.of(2026, 6, 05), "11:00 AM", "Scheduled", "ER Review", "None"));

        // MEDICAL RECORDS
        medicalRecordService.add(new MedicalRecord("P300", "REC-777", "DOC-101", LocalDate.of(2026, 5, 1), "Hypertension", "Lisinopril", "Reduce salt", "Normal ECG"));
        medicalRecordService.add(new MedicalRecord("P200", "REC-778", "DOC-101", LocalDate.of(2026, 4, 10), "Stable Heart", "None", "Exercise", "Good"));
        medicalRecordService.add(new MedicalRecord("P201", "REC-779", "DOC-102", LocalDate.of(2026, 3, 15), "Migraine", "Panadol", "Rest", "Clear Scan"));
        medicalRecordService.add(new MedicalRecord("P400", "REC-780", "DOC-104", LocalDate.now(), "Acute MI", "Aspirin", "Bed rest", "Elevated Troponin"));
        medicalRecordService.add(new MedicalRecord("P301", "REC-781", "DOC-102", LocalDate.of(2026, 5, 5), "Vertigo", "Betahistine", "Avoid sudden moves", "Pending"));
        medicalRecordService.add(new MedicalRecord("P202", "REC-782", "DOC-105", LocalDate.of(2026, 5, 1), "Arrhythmia", "Digoxin", "Monitor pulse", "Irregular rhythm"));
        medicalRecordService.add(new MedicalRecord("P203", "REC-783", "DOC-104", LocalDate.of(2026, 5, 10), "Common Cold", "Vitamin C", "Fluids", "N/A"));
        medicalRecordService.add(new MedicalRecord("P401", "REC-784", "DOC-103", LocalDate.now(), "Radius Fracture", "Painkillers", "Cast for 6 weeks", "X-ray confirmed"));
        medicalRecordService.add(new MedicalRecord("P302", "REC-785", "DOC-101", LocalDate.of(2026, 5, 12), "Chest Pain", "Nitroglycerin", "Emergency ready", "ECG abnormal"));
        medicalRecordService.add(new MedicalRecord("P402", "REC-786", "DOC-104", LocalDate.now(), "Asthma Attack", "Ventolin", "Inhaler use", "Low O2"));
        medicalRecordService.add(new MedicalRecord("P200", "REC-787", "DOC-105", LocalDate.of(2026, 1, 20), "Checkup", "None", "Healthy", "Clear"));
        medicalRecordService.add(new MedicalRecord("P201", "REC-788", "DOC-106", LocalDate.of(2026, 2, 10), "Diabetes", "Metformin", "Diet control", "HbA1c 7.5"));

    }
}