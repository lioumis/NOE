/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.upatras.ceid.noe;
import java.util.*;
import java.time.LocalDateTime;
/**
 *
 * @author NickSxiz
 */
public class Schedule {
    private HashMap<LocalDateTime, Appointment> appointments;

    public HashMap<LocalDateTime, Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(HashMap<LocalDateTime, Appointment> appointments) {
        this.appointments = appointments;
    }
    
    private HashMap<LocalDateTime, Surgery> surgeries;
    
    private HashMap<LocalDateTime, LocalDateTime> unavailable;
    
    
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
    
    public Schedule getSchedule(){
        return new Schedule();
    }
}