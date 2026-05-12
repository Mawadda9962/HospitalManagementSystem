package Interfaces;

import Entities.Appointment;

import java.time.LocalDate;

public interface Appointable {
    public void scheduleAppointment(Appointment appointment);
    public void cancelAppointment(String appointmentId);
    public void rescheduleAppointment(String appointmentId, LocalDate newDate);
}
