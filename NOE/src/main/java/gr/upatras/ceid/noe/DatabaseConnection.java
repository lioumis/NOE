package gr.upatras.ceid.noe;

import gr.upatras.ceid.noe.exceptions.NOEAuthenticationException;

import java.sql.*;
import java.time.LocalDateTime;
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

    public String retrieveUserPassword(String username) throws NOEAuthenticationException {
        String query = "SELECT password FROM user WHERE user.id_number LIKE '" + username + "' OR user.afm LIKE '" + username + "';";
        Connection connection = connect();

        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                rs.close();
                pst.close();
                connection.close();
                return rs.getString(1);
            } else {
                rs.close();
                pst.close();
                connection.close();
                throw new NOEAuthenticationException();
            }
        } catch (SQLException e) {
            MessageHelper.showErrorMessage("Σφάλμα της βάσης δεδομένων");
        }

        return "";
    }

    public ArrayList<String> retrieveUserRoles(String username) {
        String query = "SELECT roles.roleId FROM user INNER JOIN roles ON user.amka = roles.u_amka WHERE user.id_number LIKE '" + username + "' OR user.afm LIKE '" + username + "';";
        ArrayList<String> roles = new ArrayList<>();
        Connection connection = connect();

        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                roles.add(rs.getString(1));
            }
            rs.close();
            pst.close();
            connection.close();
        } catch (SQLException e) {
            MessageHelper.showErrorMessage("Σφάλμα της βάσης δεδομένων");
        }

        return roles;
    }

    public ArrayList<String> retrieveAvailableHospitals() {
        //Return all available for an appointment hospitals
        return new ArrayList<>();
    }

    public ArrayList<String> retrieveAvailableSpecializations(String hospital) {
        //Return all available specializations os the hospital for an appointment
        return new ArrayList<>();
    }

    public ArrayList<Date> retrieveAvailableDates(String hospital, String specialization) {
        //Return all available dates for the specific hospital and specialization
        return new ArrayList<>();
    }

    public ArrayList<LocalDateTime> retrieveAvailableAppointments(String hospital, String specialization, java.util.Date date) {
        //Return available appointments
        ArrayList<LocalDateTime> appointments = new ArrayList<>();
        appointments.add(LocalDateTime.now());
        return appointments;
    }

    public String retrievePatientEmail(String patient) {
        //Return patient email
        return "";
    }

    public String retrieveDoctorEmail(String doctor) {
        //Return doctor email
        return "";
    }
}
