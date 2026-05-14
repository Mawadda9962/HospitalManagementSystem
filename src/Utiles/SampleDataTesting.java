package Utiles;

import Entities.Department;
import Entities.EmergencyPatient;
import Entities.InPatient;
import Entities.OutPatient;
import Services.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

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
        patientService.add(ip1);



        OutPatient op2 = new OutPatient(
                "P200", "Fatma", "Al-Zadjali", "1992-11-05", "Female",
                "95556677", "fatma@example.om", "Muscat", "General", "MBBS", 0,
                "DEP-01", 0.0, null, null, "P200", "O-", null,
                LocalDate.now(), "OmanIns-102", null, null,
                5, LocalDate.of(2026, 4, 10), "DOC-101"
        );
        patientService.add(op2);

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
        patientService.add(ep1);


    }

}
