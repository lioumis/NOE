package gr.upatras.ceid.noe;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * @author NickSxiz
 */
public class Schedule {
    private HashMap<LocalDateTime, Appointment> appointments;
    private HashMap<LocalDateTime, Surgery> surgeries;
    private HashMap<LocalDateTime, LocalDateTime> unavailable;

    public HashMap<LocalDateTime, Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(HashMap<LocalDateTime, Appointment> appointments) {
        this.appointments = appointments;
    }

    public HashMap<LocalDateTime, LocalDateTime> getUnavailable() {
        return unavailable;
    }

    public void setUnavailable(HashMap<LocalDateTime, LocalDateTime> unavailable) {
        this.unavailable = unavailable;
    }

    public HashMap<LocalDateTime, Surgery> getSurgeries() {
        return surgeries;
    }

    public void setSurgeries(HashMap<LocalDateTime, Surgery> surgeries) {
        this.surgeries = surgeries;
    }

    public Schedule getSchedule() {
        return this;
    }
}