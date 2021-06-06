package gr.upatras.ceid.noe;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseConnection {

    String Patient;
    String Surgery;
    String Schedule;
    private java.util.ArrayList<Supply> Supplies;
    private Object String;


    public int retrieveAvailableBeds() {
        return 0;
    }

    public HashMap<String, Integer> RetrieveDiseases() {
        return new HashMap<String, Integer>();
    }

    public int retrieveDeaths() {
        return 0;
    }

    public int retrieveAdmissions() {
        return 0;
    }

    public int retrieveHospitalizations() {
        return 0;
    }

    public ArrayList<String> retrieveEmployeeEmails() {
        return new ArrayList<String>();
    }

    public String retrieveMinistryEmail() {
        return null;
    }

    public void retrieveBudgetInfo() {
    }

    public void updateBudgetInfo(HospitalBudget budget) {
    }

    public String searchPatient() {
        return Patient;
    }

    public TreatmentCost searchHospitalizationCost() {
        return new TreatmentCost();
    }

    public TreatmentCost updateCost() {
        return null;
    }

    public ArrayList<Doctor> retrieveDoctors() {
        return new ArrayList<Doctor>();
    }

    public ArrayList<Evaluation> retrieveEvaluations() {
        return new ArrayList<Evaluation>();
    }

    public ArrayList<Appointment> retrieveAppointments() {
        return new ArrayList<Appointment>();
    }

    public ArrayList<Patient> retrievePatients() {
        return new ArrayList<Patient>();
    }

    public ArrayList<String> retrieveEmails() {
        return new ArrayList<String>();
    }

    public String getSurgery() {
        return Surgery;
    }

    public String getSchedule() {
        return Schedule;
    }

    public ArrayList<Supply> getSupplies() {
        return Supplies;
    }

    public String retrieveCryptoKey() {
        return null;
    }


}
