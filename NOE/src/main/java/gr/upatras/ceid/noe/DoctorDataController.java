package gr.upatras.ceid.noe;

import gr.upatras.ceid.noe.utilities.MessageHelper;

import java.time.LocalTime;
import java.util.Date;

/**
 * @author Dimitra Lyrou
 */
public class DoctorDataController {

    public Schedule getData(String doctor) { //TODO: Domain
        Schedule schedule = new Schedule();
        schedule.getSchedule(doctor);
        return schedule;
    }

    public boolean completionCheck(Appointment appointment) { //TODO: Domain
        Date date = appointment.getDate();
        LocalTime time = appointment.getTime();
        int result = date.compareTo(new Date());
        if (result == 0) {
            int timeResult = time.compareTo(LocalTime.now());
            if (timeResult <= 0) {
                MessageHelper.showErrorMessage("Το ραντεβού έχει ήδη πραγματοποιηθεί");
                return false;
            } else {
                return true;
            }
        } else if (result < 0) {
            MessageHelper.showErrorMessage("Το ραντεβού έχει ήδη πραγματοποιηθεί");
            return false;
        } else {
            return true;
        }
    }

    public void cancelAppointment(Appointment appointment) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.removeAppointment(appointment);
    }

    public boolean isCorrect(Appointment appointment) {
        boolean correctDateTime = completionCheck(appointment);
        return true;
    }

    public boolean okData(Appointment appointment) {
        if (appointment.getDate() == null || appointment.getTime() == null || appointment.getDoctor() == null || appointment.getPatient() == null || appointment.getDuration() == 0) {
            MessageHelper.showErrorMessage("Τα στοιχεία δεν είναι συμπληρωμένα");
            return false;
        } else {
            return true;
        }
    }

    public void save(Appointment appointment) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.updateAppointments(appointment);
    }


}
