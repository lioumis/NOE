package gr.upatras.ceid.noe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseConnection {

    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/noe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    private static final String ERROR_MESSAGE = "Η σύνδεση με τη βάση δεδομένων απέτυχε!";


    public static Connection connect() {
        try {
            Class.forName(DRIVER_CLASS);
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {

            MessageHelper.showErrorMessage(ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
    }

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
        return "";
    }

    public TreatmentCost searchHospitalizationCost() {
        return new TreatmentCost();
    }

    public TreatmentCost updateCost() {
        return null;
    }

    public ArrayList<Doctor> retrieveDoctors() {
        return new ArrayList<>();
    }

    public ArrayList<Evaluation> retrieveEvaluations() {
        return new ArrayList<>();
    }

    public ArrayList<Appointment> retrieveAppointments() {
        return new ArrayList<>();
    }

    public ArrayList<Patient> retrievePatients() {
        return new ArrayList<>();
    }

    public ArrayList<String> retrieveEmails() {
        return new ArrayList<>();
    }

    public String getSurgery() {
        return "";
    }

    public String getSchedule() {
        return "";
    }

    public ArrayList<Supply> getSupplies() {
        return new ArrayList<>();
    }

    public String retrieveCryptoKey() {
        return null;
    }


}
