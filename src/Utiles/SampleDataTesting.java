package Utiles;

import Entities.*;
import Services.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SampleDataTesting {
    public static void Testing(){

        DoctorService doctorService = new DoctorService();
        DepartmentService departmentService = new DepartmentService();
        PatientService patientService = new PatientService();
        MedicalRecordService medicalRecordService = new MedicalRecordService();
        AppointmentService appointmentService = new AppointmentService();


        departmentService.add(new Department("Cardiology", "DEP-01", "DOC-101", new ArrayList<>(), new ArrayList<>(), 30, 30));
        departmentService.add(new Department("Neurology", "DEP-02", "DOC-102", new ArrayList<>(), new ArrayList<>(), 20, 20));
        departmentService.add(new Department("Emergency", "DEP-04", "DOC-104", new ArrayList<>(), new ArrayList<>(), 50, 50));

        InPatient ip1 = new InPatient(
                "P300", "Salim", "Al-Rawahi", "1975-08-20", "Male",
                "92228877", "salim.r@example.om", "Ibra", "N/A", "N/A", 0,
                "DEP-01", 0.0, null, null, "P300", "B+", null,
                LocalDate.now(), "OMAN-INS-99", null, null,
                LocalDate.of(2026, 5, 1), LocalDate.of(2026, 5, 10),
                "Room-105", "Bed-A2", "DOC-101", 25.5
        );

        OutPatient op2 = new OutPatient(
                "P200", "Fatma", "Al-Zadjali", "1992-11-05", "Female",
                "95556677", "fatma@example.om", "Muscat", "General", "MBBS", 0,
                "DEP-01", 0.0, null, null, "P200", "O-", null,
                LocalDate.now(), "OmanIns-102", null, null,
                5, LocalDate.of(2026, 4, 10), "DOC-101"
        );

        // This uses your 32-parameter constructor matching the EmergencyPatient class
        EmergencyPatient ep1 = new EmergencyPatient(
                "P400",                 // id
                "Ahmed",                // firstName
                "Al-Balushi",           // lastName
                "1988-03-12",           // dateOfBirth
                "Male",                 // gender
                "93334455",                 // phoneNumber
                "ahmed.b@hospital.om",  // email
                "Sohar",                // address
                "N/A",                  // specialization
                "N/A",                  // qualification
                0,                      // experienceYears
                "DEP-04",               // departmentId (Emergency)
                0.0,                    // consultationFee
                null,                   // availableSlots
                null,                   // assignedPatients
                "P400",                 // patientId
                "A-",                   // bloodGroup
                null,                   // emergencyContact
                LocalDate.now(),        // registrationDate
                "OMAN-GOV-01",          // insuranceId
                null,                   // medicalRecords
                null,                   // appointments
                LocalDate.now(),        // admissionDate
                null,                   // dischargeDate (Still in ER)
                "ER-Room-01",           // roomNumber
                "ER-Bed-05",            // bedNumber
                "DOC-104",              // admittingDoctorId
                50.0,                   // dailyCharges
                "Heart Attack",         // emergencyType
                "Ambulance",            // arrivalMode
                1,                      // triageLevel (Level 1 = Critical)
                true                    // admittedViaER
        );
        patientService.add(ip1);
        patientService.add(op2);
        patientService.add(ep1);

        List<String> surgerieTypes = new ArrayList<>(Arrays.asList("Bypass", "Angioplasty"));
        Surgeon s1 = new Surgeon(
                "D101", "Mazen", "Al-Riyami", "1980-01-01", "Male", "98881122", "mazen@hosp.om", "Seeb",
                "DOC-101", "Cardiology", "PhD Surgery", 15, "DEP-01", 50.0,
                new ArrayList<>(Arrays.asList("08:00 AM", "10:00 AM")), // availableSlots
                new ArrayList<>(), // assignedPatients
                45, // surgeriesPerformed
                surgerieTypes, // surgeryTypes
                true // operationTheatreAccess
        );

        List<String> consultTypes = new ArrayList<>(Arrays.asList("General Checkup", "Chronic Pain"));
        Consultant c1 = new Consultant(
                "D102", "Muna", "Al-Zadjali", "1985-05-12", "Female", "94443322", "muna@hosp.om", "Qurum",
                "DOC-102", "Neurology", "MD Neurology", 12, "DEP-02", 40.0,
                new ArrayList<>(Arrays.asList("01:00 PM", "03:00 PM")), // availableSlots
                new ArrayList<>(), // assignedPatients
                consultTypes, // consultationTypes
                true, // onlineConsultationAvailable
                45 // consultationDuration
        );
        doctorService.add(s1);
        doctorService.add(c1);


        Appointment app1 = new Appointment(
                "APP-001",
                "P300",          // Linked to Salim
                "DOC-101",       // Linked to Dr. Mazen
                LocalDate.of(2026, 5, 20),
                "10:30 AM",
                "Scheduled",
                "Post-Surgery Follow-up",
                "Check heart rate stability"
        );

        // Testing your Method Overloading for notes
        app1.addNotes("Patient arrived 5 minutes early", "Receptionist", LocalDateTime.now());

        appointmentService.add(app1);


        MedicalRecord rec1 = new MedicalRecord(
                "P300",
                "REC-777",
                "DOC-101",
                LocalDate.of(2026, 5, 1),
                "Mild Hypertension",
                "Lisinopril 10mg",
                "Patient advised to reduce salt intake",
                "ECG showed normal rhythm"
        );

        medicalRecordService.add(rec1);

    }

}
