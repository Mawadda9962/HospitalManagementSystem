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
        NurseService nurseService = new NurseService();


        // DEPARTMENTS
        departmentService.add(new Department("Cardiology", "DEP-01", "DOC-101", new ArrayList<>(), new ArrayList<>(), 30, 30));
        departmentService.add(new Department("Neurology", "DEP-02", "DOC-102", new ArrayList<>(), new ArrayList<>(), 20, 20));
        departmentService.add(new Department("Emergency", "DEP-04", "DOC-104", new ArrayList<>(), new ArrayList<>(), 50, 50));

        // DOCTORS
        // Surgeons
        doctorService.add(new Doctor(null, "Mazen", "Al-Riyami", LocalDate.of(1980, 1, 1), "Male", "98881122", "mazen@hosp.om", "Seeb", null, null, 0, null, 0.0, null, null, "DOC-101", "Cardiology", "PhD Surgery", 15, "DEP-01", 50.0, new ArrayList<>(Arrays.asList("08:00 AM", "10:00 AM")), new ArrayList<>(), true));
        doctorService.add(new Doctor(null, "Said", "Al-Habsi", LocalDate.of(1978, 3, 15), "Male", "92223344", "said@hosp.om", "Muscat", null, null, 0, null, 0.0, null, null, "DOC-103", "General Surgery", "MD Surgery", 20, "DEP-04", 60.0, new ArrayList<>(), new ArrayList<>(), true));
        // Consultants
        doctorService.add(new Doctor(null, "Muna", "Al-Zadjali", LocalDate.of(1985, 5, 12), "Female", "94443322", "muna@hosp.om", "Qurum", null, null, 0, null, 0.0, null, null, "DOC-102", "Neurology", "MD Neurology", 12, "DEP-02", 40.0, new ArrayList<>(Arrays.asList("01:00 PM", "03:00 PM")), new ArrayList<>(), true));
        doctorService.add(new Doctor(null, "Laila", "Al-Balushi", LocalDate.of(1982, 11, 20), "Female", "95551122", "laila@hosp.om", "Barka", null, null, 0, null, 0.0, null, null, "DOC-105", "Cardiology", "MD Cardiology", 18, "DEP-01", 45.0, new ArrayList<>(), new ArrayList<>(), true));
        doctorService.add(new Doctor(null, "Omar", "Al-Kindi", LocalDate.of(1975, 2, 10), "Male", "96667788", "omar@hosp.om", "Nizwa", null, null, 0, null, 0.0, null, null, "DOC-106", "Internal Medicine", "MD Medicine", 25, "DEP-02", 55.0, new ArrayList<>(), new ArrayList<>(), true));
        // GPs (Assuming base Doctor class represents GP)
        doctorService.add(new Doctor(null, "Khalid", "Al-Farsi", LocalDate.of(1990, 6, 20), "Male", "91112233", "khalid@hosp.om", "Sohar", null, null, 0, null, 0.0, null, null, "DOC-104", "General", "MBBS", 5, "DEP-04", 20.0, new ArrayList<>(), new ArrayList<>(), true));
        doctorService.add(new Doctor(null, "Sara", "Al-Alawi", LocalDate.of(1993, 8, 5), "Female", "93335566", "sara@hosp.om", "Sur", null, null, 0, null, 0.0, null, null, "DOC-107", "General", "MBBS", 3, "DEP-04", 20.0, new ArrayList<>(), new ArrayList<>(), true));
        doctorService.add(new Doctor(null, "Fahad", "Al-Hasni", LocalDate.of(1988, 12, 12), "Male", "94440099", "fahad@hosp.om", "Ibri", null, null, 0, null, 0.0, null, null, "DOC-108", "General", "MBBS", 8, "DEP-04", 25.0, new ArrayList<>(), new ArrayList<>(), true));

        // PATIENTS
        // In-Patients
        patientService.add(new InPatient("P300", "Salim", "Al-Rawahi", LocalDate.of(2026, 5, 20), "Male", "92228877", "salim.r@example.om", "Ibra", "N/A", "N/A", 0, "DEP-01", 0.0, null, null, "P300", "B+", null, LocalDate.now(), "INS-001", null, null, LocalDate.of(2026, 5, 1), LocalDate.of(2026, 5, 10), "Room-105", "Bed-A2", "DOC-101", 25.5));
        patientService.add(new InPatient("P301", "Nasra", "Al-Maskari", LocalDate.of(2026, 5, 21), "Female", "91114455", "nasra@example.om", "Manah", "N/A", "N/A", 0, "DEP-02", 0.0, null, null, "P301", "O+", null, LocalDate.now(), "INS-002", null, null, LocalDate.of(2026, 5, 5), null, "Room-202", "Bed-B1", "DOC-102", 30.0));
        patientService.add(new InPatient("P302", "Hamad", "Al-Shuaili", LocalDate.of(2026, 5, 22), "Male", "99991122", "hamad@example.om", "Bahla", "N/A", "N/A", 0, "DEP-01", 0.0, null, null, "P302", "A-", null, LocalDate.now(), "INS-003", null, null, LocalDate.of(2026, 5, 12), null, "Room-106", "Bed-A1", "DOC-101", 25.5));

        // Out-Patients
        patientService.add(new OutPatient("P200", "Fatma", "Al-Zadjali", LocalDate.of(1992, 11, 5), "Female", "95556677", "fatma@example.om", "Muscat", null, null, 0, "DEP-01", 0.0, null, null, "P200", "O-", new ArrayList<>(Arrays.asList("90001111")), LocalDate.now(), "INS-102", new ArrayList<>(), new ArrayList<>(), 5, LocalDate.of(2026, 4, 10), "DOC-101"));
        patientService.add(new OutPatient("P201", "Ali", "Al-Harthi", LocalDate.of(1988, 1, 20), "Male", "96660011", "ali@example.om", "Rustaq", null, null, 0, "DEP-02", 0.0, null, null, "P201", "AB+", new ArrayList<>(Arrays.asList("91110000")), LocalDate.now(), "INS-103", new ArrayList<>(), new ArrayList<>(), 2, LocalDate.of(2026, 3, 15), "DOC-102"));
        patientService.add(new OutPatient("P202", "Hamed", "Al-Siyabi", LocalDate.of(1985, 7, 30), "Male", "94448822", "hamed@example.om", "Nizwa", null, null, 0, "DEP-04", 0.0, null, null, "P202", "A+", new ArrayList<>(Arrays.asList("92223333")), LocalDate.now(), "INS-104", new ArrayList<>(), new ArrayList<>(), 10, LocalDate.of(2026, 5, 1), "DOC-104"));
        patientService.add(new OutPatient("P203", "Noora", "Al-Habsi", LocalDate.of(1995, 2, 14), "Female", "93331122", "noora@example.om", "Barka", null, null, 0, "DEP-01", 0.0, null, null, "P203", "B-", new ArrayList<>(Arrays.asList("98887766")), LocalDate.now(), "INS-105", new ArrayList<>(), new ArrayList<>(), 1, LocalDate.of(2026, 5, 12), "DOC-101"));
        // Emergency Patients
        patientService.add(new EmergencyPatient("P400", "Ahmed", "Al-Balushi", LocalDate.of(1988, 3, 12), "Male", "93334455", "ahmed.b@hosp.om", "Sohar", null, null, 0, "DEP-04", 0.0, null, null, "P400", "A-", new ArrayList<>(Arrays.asList("99990000")), LocalDate.now(), "GOV-01", new ArrayList<>(), new ArrayList<>(), null, LocalDate.now(), "ER-01", "B-05", "DOC-104", 50.0, "Heart Attack", "Ambulance", 1, true));
        patientService.add(new EmergencyPatient("P401", "Mariam", "Al-Sadi", LocalDate.of(1998, 5, 25), "Female", "92225588", "mariam@hosp.om", "Muscat", null, null, 0, "DEP-04", 0.0, null, null, "P401", "O+", new ArrayList<>(Arrays.asList("91112222")), LocalDate.now(), "GOV-02", new ArrayList<>(), new ArrayList<>(), null, LocalDate.now(), "ER-02", "B-01", "DOC-103", 50.0, "Fracture", "Private Car", 3, true));
        patientService.add(new EmergencyPatient("P402", "Qassim", "Al-Majali", LocalDate.of(1970, 10, 10), "Male", "91119900", "qassim@hosp.om", "Barka", null, null, 0, "DEP-04", 0.0, null, null, "P402", "B+", new ArrayList<>(Arrays.asList("95554444")), LocalDate.now(), "GOV-03", new ArrayList<>(), new ArrayList<>(), null, LocalDate.now(), "ER-03", "B-02", "DOC-104", 50.0, "Asthma Attack", "Ambulance", 2, true));
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

        System.out.println(medicalRecordService);
        System.out.println(patientService);
        System.out.println(departmentService);
        System.out.println(doctorService);
        System.out.println(nurseService);
    }
}