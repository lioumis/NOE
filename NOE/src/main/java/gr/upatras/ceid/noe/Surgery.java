package gr.upatras.ceid.noe;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author NickSxiz
 */
public class Surgery {
    private LocalDateTime dateTime;
    private int duration;
    private ArrayList<Doctor> doctors;
    private Patient patient;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Surgery getSurgery() {
        return this;
    }

}