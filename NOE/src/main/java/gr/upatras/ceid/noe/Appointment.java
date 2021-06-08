/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.upatras.ceid.noe;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author NickSxiz
 */
public class Appointment {

    private Date date;
    private LocalTime time;
    private int duration;
    private Doctor doctor;
    private Patient patient;
    private ArrayList<Appointment> appointments;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void display() {

    }

    public void doChanges() {


    }

    public void CheckCompl() {

    }

    public void onCancel() {

    }

    public boolean isCorrect() {
        return true;
    }

    public boolean okData() {
        return true;
    }

    public Appointment getAppointment() {
        return this;
    }

    private void save() {

    }

    public void saveAppointments() {

    }

    public void updateAppointment() {

    }

    public void upload() {
    }

}
