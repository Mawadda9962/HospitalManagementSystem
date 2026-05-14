package Services;

import Entities.Appointment;
import Entities.Department;
import Utiles.InputHandler;

import java.time.LocalDate;

public class ReportsStatistics {

    public void DailyAppointmentsReport() {
        LocalDate date = InputHandler.getDateInput("Enter Date (YYYY-MM-DD)");
        int count = 0;

        for (Appointment a : AppointmentService.appointments) {
            if (a.getAppointmentDate().equals(date)) {
                System.out.println("ID: " + a.getAppointmentId() + " | Patient: " + a.getPatientId());
                count++;
            }
        }
        System.out.println("Total for this day: " + count);
    }

    public void DoctorPerformanceReport() {
        String id = InputHandler.getStringInput("Enter Dr ID");
        int total = 0;

        for (Appointment a : AppointmentService.appointments) {
            if (a.getDoctorId().equalsIgnoreCase(id)) {
                total++;
            }
        }
        System.out.println("Doctor " + id + " has " + total + " total appointments.");
    }


    public void DepartmentOccupancyReport() {
        for (Department d : DepartmentService.departments) {
            int used = d.getBedCapacity() - d.getAvailableBeds();
            System.out.println(d.getDepartmentName() + " Usage: " + used + "/" + d.getBedCapacity());
        }
    }

    public void PatientStatistics() {
        System.out.println("Total Patients in System: " + PatientService.patients.size());
    }

    public void EmergencyCasesReport() {
        for (Appointment a : AppointmentService.appointments) {
            if (a.getReason().equalsIgnoreCase("Emergency")) {
                System.out.println("EMERGENCY: Appt " + a.getAppointmentId() + " for Patient " + a.getPatientId());
            }
        }
    }

    public








}




