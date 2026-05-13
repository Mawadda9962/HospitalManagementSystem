package Services;

import Entities.Appointment;
import Entities.Doctor;
import Entities.patient;
import Interfaces.Appointable;
import Interfaces.Manageable;
import Interfaces.Searchable;
import Utiles.Constant;
import Utiles.HelperUtils;
import Utiles.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentService extends Base implements Manageable, Searchable, Appointable {

    private static Scanner scanner = new Scanner(System.in);

    private static List<Appointment> appointments = new ArrayList<>();

    public void addAppointment() {
        System.out.println("********** Schedule New Appointment **********");

        System.out.print("Enter Appointment ID: ");
        String appointmentId = scanner.nextLine().trim();

        if (HelperUtils.isNotNull(getAppointmentById(appointmentId))) {
            System.out.println("An appointment with this ID already exists.");
            return;
        }

        String patientId = InputHandler.getStringInput("Enter Patient ID");
        String doctorId = InputHandler.getStringInput("Enter Doctor ID");

        LocalDate date = InputHandler.getDateInput("Enter Appointment Date");
        String time = InputHandler.getStringInput("Enter Appointment Time (e.g., 10:30 AM)");
        String reason = InputHandler.getStringInput("Enter Reason for Visit");
        String notes = InputHandler.getStringInput("Enter Notes (Optional)");

        Appointment newAppointment = new Appointment(
                appointmentId, patientId, doctorId, date, time, "Scheduled", reason, notes
        );

        appointments.add(newAppointment);
        System.out.println(Constant.APPOINTMENT_ADDED_SUCCESSFULLY);
    }

    public Appointment getAppointmentById(String id) {
        for (Appointment a : appointments) {
            if (HelperUtils.isNotNull(a) && a.getAppointmentId().equals(id)) {
                return a;
            }
        }
        return null;
    }

    public void rescheduleAppointment(String id, LocalDate newDate, String newTime) {
        Appointment a = getAppointmentById(id);
        if (HelperUtils.isNotNull(a)) {
            a.reschedule(newDate, newTime);
        } else {
            System.out.println("Appointment not found.");
        }
    }


    public void cancelAppointment(String id) {
        Appointment a = getAppointmentById(id);
        if (HelperUtils.isNotNull(a)) {
            a.setStatus("Cancelled");
            System.out.println("Appointment " + id + " has been cancelled.");
        } else {
            System.out.println("Appointment not found.");
        }
    }

    public void removeAppointment(String id) {
        Appointment a = getAppointmentById(id);
        if (HelperUtils.isNotNull(a)) {
            appointments.remove(a);
            System.out.println(Constant.APPOINTMENT_REMOVE_SUCCESSFULLY);
        } else {
            System.out.println("Appointment not found.");
        }
    }

    public void getAppointmentsByPatientId(String patientId) {
        System.out.println(" Appointments for Patient: " + patientId);
        boolean found = false;
        for (Appointment a : appointments) {
            if (HelperUtils.isNotNull(a) && a.getPatientId().equalsIgnoreCase(patientId)) {
                a.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No appointments found for this patient.");
    }

    public void getAppointmentsByDoctor(String doctorId) {
        System.out.println("Appointments for Doctor: " + doctorId);
        boolean found = false;
        for (Appointment a : appointments) {
            if (HelperUtils.isNotNull(a) && a.getDoctorId().equalsIgnoreCase(doctorId)) {
                a.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No appointments found for this doctor.");
    }

    public void getAppointmentsByDate(LocalDate date) {
        System.out.println("--- Appointments on Date: " + date + " ---");
        boolean found = false;
        for (Appointment a : appointments) {
            if (HelperUtils.isNotNull(a) && a.getAppointmentDate().equals(date)) {
                a.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No appointments found on this date.");
    }

    public void displayAllAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
            return;
        }
        for (Appointment a : appointments) {
            if (HelperUtils.isNotNull(a)){
                a.displayInfo();
            }
        }
    }

    public void createAppointment(String patientId, String doctorId, LocalDate date) {
        if (HelperUtils.isNotNull(patientId) && HelperUtils.isNotNull(doctorId)) {
            Appointment appointment = new Appointment();
            appointment.setAppointmentId(HelperUtils.generateId("APP", 5));
            appointment.setPatientId(patientId);
            appointment.setDoctorId(doctorId);
            appointment.setAppointmentDate(date);
            appointment.setStatus("Scheduled");

            appointments.add(appointment);
            System.out.println(Constant.APPOINTMENT_ADDED_SUCCESSFULLY);
        } else {
            System.out.println("Error: Missing Patient or Doctor information.");
        }
    }

    public void createAppointment(String patientId, String doctorId, LocalDate date, String time) {
        if (HelperUtils.isNotNull(patientId) && HelperUtils.isNotNull(doctorId)) {
            Appointment appointment = new Appointment();
            appointment.setAppointmentId(HelperUtils.generateId("APP", 5));
            appointment.setPatientId(patientId);
            appointment.setDoctorId(doctorId);
            appointment.setAppointmentDate(date);
            appointment.setAppointmentTime(time);
            appointment.setStatus("Scheduled");

            appointments.add(appointment);
            System.out.println(Constant.APPOINTMENT_ADDED_SUCCESSFULLY);
        }
    }

    public void createAppointment(Appointment appointment) {
        if (HelperUtils.isNotNull(appointment)) {
            appointments.add(appointment);
            System.out.println(Constant.APPOINTMENT_ADDED_SUCCESSFULLY);
        } else {
            System.out.println("Error: Appointment object is null.");
        }
    }

    public void rescheduleAppointment(String appointmentId, LocalDate newDate) {
        Appointment appointment = new Appointment();

        System.out.println("Please enter appointment Id ");
        appointmentId = scanner.nextLine();
        appointment.setAppointmentId(appointmentId);

        System.out.println("Please enter appointment Date ");
        newDate = LocalDate.parse(scanner.nextLine());
        appointment.setAppointmentDate(newDate);
    }

    public void rescheduleAppointments(String appointmentId, LocalDate newDate, String newTime) {
        Appointment appointment = new Appointment();

        System.out.println("Please enter appointment Id ");
        appointmentId = scanner.nextLine();
        appointment.setAppointmentId(appointmentId);

        System.out.println("Please enter appointment Date ");
        newDate = LocalDate.parse(scanner.nextLine());
        appointment.setAppointmentDate(newDate);

        System.out.println("Please enter appointment time ");
        newTime = scanner.nextLine();
        appointment.setAppointmentTime(newTime);
    }

    public void rescheduleAppointment(Appointment appointment, LocalDate newDate, String newTime, String reason) {
        System.out.println("Please enter appointment Date ");
        newDate = LocalDate.parse(scanner.nextLine());
        appointment.setAppointmentDate(newDate);

        System.out.println("Please enter appointment time ");
        newTime = scanner.nextLine();
        appointment.setAppointmentTime(newTime);

        System.out.println("Please enter reason ");
        reason = scanner.nextLine();
        appointment.setReason(reason);
    }

    public void displayAppointments(LocalDate date) {
        getAppointmentsByDate(date);
    }

    public void displayAppointments(String doctorId, LocalDate startDate, LocalDate endDate) {
        Appointment appointment = new Appointment();
        System.out.println("Doctor Id: " + appointment.getDoctorId());
        System.out.println("Start Date: " + appointment.getAppointmentDate());
    }

    public Boolean handleAppointmentMenu(Integer option) {
        switch (option) {
            case 1 -> addAppointment();
            case 2 -> {
                System.out.print("Enter ID to reschedule: ");
                String id = scanner.nextLine().trim();
                System.out.print("Enter New Date (YYYY-MM-DD): ");
                String dateStr = scanner.nextLine().trim();
                LocalDate d = (dateStr.length() == 10 && dateStr.charAt(4) == '-' && dateStr.charAt(7) == '-')
                        ? LocalDate.parse(dateStr) : LocalDate.now();
                System.out.print("Enter New Time: ");
                String t = scanner.nextLine().trim();
                rescheduleAppointment(id, d, t);
            }
            case 3 -> {
                System.out.print("Enter ID to cancel: ");
                cancelAppointment(scanner.nextLine().trim());
            }
            case 4 -> {
                System.out.print("Enter Patient ID: ");
                getAppointmentsByPatientId(scanner.nextLine().trim());
            }
            case 5 -> {
                System.out.print("Enter Doctor ID: ");
                getAppointmentsByDoctor(scanner.nextLine().trim());
            }
            case 6 -> {
                System.out.print("Enter Date (YYYY-MM-DD): ");
                String dateStr = scanner.nextLine().trim();
                if (dateStr.length() == 10 && dateStr.charAt(4) == '-' && dateStr.charAt(7) == '-') {
                    getAppointmentsByDate(LocalDate.parse(dateStr));
                } else {
                    System.out.println("Invalid date format.");
                }
            }
            case 7 -> displayAllAppointments();
            case 8 -> {
                return false;
            }
            default -> System.out.println("Invalid option.");
        }
        return true;
    }

    @Override
    public void add(Object entity) {
        if (entity instanceof Appointment) {
            Appointment a = (Appointment) entity;
            appointments.add(a);
            System.out.println("Appointment added: " + a.getAppointmentId());
        } else {
            System.out.println("Invalid entity type. Expected an Appointment object.");
        }
    }

    @Override
    public void remove(String id) {
        removeAppointment(id);

    }

    @Override
    public void getAll() {
        displayAllAppointments();

    }

    @Override
    public void search(String keyword) {
        boolean found = false;
        for (Appointment a : appointments) {
            if (a.getPatientId().equalsIgnoreCase(keyword)
                    || a.getDoctorId().equalsIgnoreCase(keyword)
                    || a.getStatus().equalsIgnoreCase(keyword)
                    || a.getReason().equalsIgnoreCase(keyword)) {
                a.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No appointments found matching: " + keyword);
        }
    }

    @Override
    public void searchById(String id) {
        Appointment a = getAppointmentById(id);
        if (a != null) {
            a.displayInfo();
        } else {
            System.out.println("No appointment found with ID: " + id);
        }
    }

    @Override
    public void scheduleAppointment(Appointment appointment) {
        if (appointment != null) {
            appointments.add(appointment);
            System.out.println("Appointment scheduled: " + appointment.getAppointmentId());
        } else {
            System.out.println("Cannot schedule a null appointment.");
        }
    }

    //Two methods left to add
}
