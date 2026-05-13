package Services;

import Entities.Appointment;
import Entities.Doctor;
import Entities.patient;
import Interfaces.Appointable;
import Interfaces.Manageable;
import Interfaces.Searchable;
import Utiles.Constant;

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

        if (getAppointmentById(appointmentId) != null) {
            System.out.println("An appointment with this ID already exists.");
            return;
        }

        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine().trim();

        System.out.print("Enter Doctor ID: ");
        String doctorId = scanner.nextLine().trim();

        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String dateInput = scanner.nextLine().trim();
        LocalDate date;

        if (dateInput.length() == 10 && dateInput.charAt(4) == '-' && dateInput.charAt(7) == '-') {
            date = LocalDate.parse(dateInput);
        } else {
            System.out.println("Invalid format. Defaulting to today's date.");
            date = LocalDate.now();
        }

        System.out.print("Enter Appointment Time (e.g., 10:30 AM): ");
        String time = scanner.nextLine().trim();

        System.out.print("Enter Reason for Visit: ");
        String reason = scanner.nextLine().trim();

        System.out.print("Enter Notes (Optional): ");
        String notes = scanner.nextLine().trim();

        Appointment newAppointment = new Appointment(
                appointmentId, patientId, doctorId, date, time, "Scheduled", reason, notes
        );

        appointments.add(newAppointment);
        System.out.println(Constant.APPOINTMENT_ADDED_SUCCESSFULLY);
    }

    public Appointment getAppointmentById(String id) {
        for (Appointment a : appointments) {
            if (a.getAppointmentId().equals(id)) {
                return a;
            }
        }
        return null;
    }

    public void rescheduleAppointment(String id, LocalDate newDate, String newTime) {
        Appointment a = getAppointmentById(id);
        if (a != null) {
            a.reschedule(newDate, newTime);
        } else {
            System.out.println("Appointment not found.");
        }
    }


    public void cancelAppointment(String id) {
        Appointment a = getAppointmentById(id);
        if (a != null) {
            a.cancel();
        } else {
            System.out.println("Appointment not found.");
        }
    }

    public void removeAppointment(String id) {
        Appointment a = getAppointmentById(id);
        if (a != null) {
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
            if (a.getPatientId().equalsIgnoreCase(patientId)) {
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
            if (a.getDoctorId().equalsIgnoreCase(doctorId)) {
                a.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No appointments found for this doctor.");
    }

    public void getAppointmentsByDate(LocalDate date) {
        System.out.println("\n--- Appointments on Date: " + date + " ---");
        boolean found = false;
        for (Appointment a : appointments) {
            if (a.getAppointmentDate().equals(date)) {
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
            a.displayInfo();
        }
    }

    public void createAppointment(String patientId, String doctorId, LocalDate date) {
        patient p = new patient();
        Doctor doctor = new Doctor();
        Appointment appointment = new Appointment();


        System.out.println("CREATING APPOINTMENT");
        System.out.println("--------------------------------");

        System.out.println("Please enter patient ID: ");
        patientId = scanner.nextLine();
        p.setPatientId(patientId);

        System.out.println("Please enter Doctor ID: ");
        doctorId = scanner.nextLine();
        doctor.setDoctorId(doctorId);

        System.out.println("Please enter appointment Date ");
        date = LocalDate.parse(scanner.nextLine());
        appointment.setAppointmentDate(date);
    }

    public void createAppointment(String patientId, String doctorId, LocalDate date, String time) {
        patient p = new patient();
        Doctor doctor = new Doctor();
        Appointment appointment = new Appointment();

        System.out.println("CREATING APPOINTMENT");
        System.out.println("--------------------------------");

        System.out.println("Please enter patient ID: ");
        patientId = scanner.nextLine();
        p.setPatientId(patientId);

        System.out.println("Please enter Doctor ID: ");
        doctorId = scanner.nextLine();
        doctor.setDoctorId(doctorId);

        System.out.println("Please enter appointment Date ");
        date = LocalDate.parse(scanner.nextLine());
        appointment.setAppointmentDate(date);

        System.out.println("Please enter appointment time ");
        time = scanner.nextLine();
        appointment.setAppointmentTime(time);
    }

    public void createAppointment(Appointment appointment) {
        patient p = new patient();
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
