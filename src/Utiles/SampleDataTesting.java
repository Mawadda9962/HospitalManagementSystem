package Utiles;

import Entities.Department;
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
                "P300",                 // id
                "Salim",                // firstName
                "Al-Rawahi",            // lastName
                "1975-08-20",           // dateOfBirth (String)
                "Male",                 // gender
                "92228877",             // phoneNumber
                "salim.r@example.om",   // email
                "Ibra",                 // address
                "N/A",                  // specialization
                "N/A",                  // qualification
                0,                      // experienceYears
                "DEP-01",               // departmentId
                0.0,                    // consultationFee
                null,          // availableSlots
                null,     // assignedPatients
                "P300",                 // patientId
                "B+",                   // bloodGroup
                null,    // emergencyContact (List)
                LocalDate.now(),        // registrationDate
                "OMAN-INS-99",          // insuranceId
                null,       // medicalRecords
                null,         // appointments
                LocalDate.of(2026, 5, 1), // admissionDate
                LocalDate.of(2026, 5, 10),// dischargeDate
                "Room-105",             // roomNumber
                "Bed-A2",               // bedNumber
                "DOC-101",              // admittingDoctorId
                25.5                    // dailyCharges
        );

        //Add to the service
        patientService.add(ip1);


        OutPatient op2 = new OutPatient(
                "P200",               // id
                "Fatma",              // firstName
                "Al-Zadjali",         // lastName
                "1992-11-05",         // dateOfBirth (String)
                "Female",             // gender
                "95556677",           // phoneNumber
                "fatma@example.om",   // email
                "Muscat",             // address
                "General",            // specialization
                "MBBS",               // qualification
                0,                    // experienceYears
                "DEP-01",             // departmentId
                0.0,                  // consultationFee
                null,          // availableSlots
                null,     // assignedPatients
                "P200",               // patientId
                "O-",                 // bloodGroup
                null,    // emergencyContact
                LocalDate.now(),      // registrationDate
                "OmanIns-102",        // insuranceId
                null,           // medicalRecords
                null,                // appointments
                5,                    // visitCount
                LocalDate.of(2026, 4, 10), // lastVisitDate
                "DOC-101"             // preferredDoctorId
        );
        //Register the patient in your Service
        patientService.add(op1);




    }

}
