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

        int totalCount = 0;

        if (AppointmentService.appointments.isEmpty()) {
            System.out.println("No appointments found in the system.");
            return;
        }
        for (Appointment a : AppointmentService.appointments) {
            if (a != null && a.getDoctorId() != null && a.getDoctorId().equalsIgnoreCase(id)) {
                totalCount++;
            }
        }
        if (totalCount == 0) {
            System.out.println("No appointments found for Doctor ID: " + id);
        } else {
            System.out.println("Performance Summary for Doctor [" + id + "]: " + totalCount + " Appointments.");
        }
    }


    public void DepartmentOccupancyReport() {
        for (Department d : DepartmentService.departments) {
            int used = d.getBedCapacity() - d.getAvailableBeds();
            System.out.println(d.getDepartmentName() + " Usage: " + used + "/" + d.getBedCapacity());
        }
    }

    public void PatientStatistics() {

    }

    public void EmergencyCasesReport() {
        for (Appointment a : AppointmentService.appointments) {
            if (a.getReason().equalsIgnoreCase("Emergency")) {
                System.out.println("EMERGENCY: Appt " + a.getAppointmentId() + " for Patient " + a.getPatientId());
            }
        }
    }

    public boolean handleReportMenu(Integer option){
        switch (option){
            case 1 -> DailyAppointmentsReport();
            case 2 -> DoctorPerformanceReport();
            case 3 -> DepartmentOccupancyReport();
            case 4 -> PatientStatistics();
            case 5 -> EmergencyCasesReport();
            case 6 -> {
                return false;
            }
            default -> System.out.println("Action not recognized");
        }
        return true;
    }

}