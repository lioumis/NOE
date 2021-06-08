package gr.upatras.ceid.noe;

import gr.upatras.ceid.noe.exceptions.NOEAuthenticationException;
import gr.upatras.ceid.noe.utilities.DateHelper;
import gr.upatras.ceid.noe.utilities.MessageHelper;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseConnection {

    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/noe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    private static final String ERROR_MESSAGE = "Η σύνδεση με τη βάση δεδομένων απέτυχε!";
    private static final String DATABASE_ERROR_MESSAGE = "Σφάλμα της βάσης δεδομένων";


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

    public HashMap<String, Integer> retrieveDiseases() {
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

    public HospitalBudget retrieveBudgetInfo(String hospital) { //TODO: Class
        //Retrieve Budget
        return new HospitalBudget();
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

    public Schedule getSchedule(String amka) { //TODO: Domain
        String query = "SELECT start, end, description, type FROM schedule WHERE doctor LIKE '" + amka + "';";
        Schedule schedule = new Schedule();
        Connection connection = connect();

        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                switch (rs.getString(4)) {
                    case "appointment":
                        Appointment appointment = new Appointment();
                        appointment.setDate(DateHelper.dateFromSQLDateTime(rs.getString(1)));
                        appointment.setTime(DateHelper.localTimeFromSQLDateTime(rs.getString(1)));
                        schedule.getAppointments().put(DateHelper.localDateTimeFromSQLDateTime(rs.getString(1)), appointment);
                        break;
                    case "surgery":
                        Surgery surgery = new Surgery();
                        surgery.setDateTime(DateHelper.localDateTimeFromSQLDateTime(rs.getString(1)));
                        surgery.setDuration(DateHelper.calculateDuration(DateHelper.localTimeFromSQLDateTime(rs.getString(1)), DateHelper.localTimeFromSQLDateTime(rs.getString(2))));
                        schedule.getSurgeries().put(DateHelper.localDateTimeFromSQLDateTime(rs.getString(1)), surgery);
                        break;
                    case "unavailable":
                        schedule.getUnavailable().put(DateHelper.localDateTimeFromSQLDateTime(rs.getString(1)), DateHelper.localDateTimeFromSQLDateTime(rs.getString(2)));
                }
            }
            rs.close();
            pst.close();
            connection.close();
        } catch (SQLException e) {
            MessageHelper.showErrorMessage("Σφάλμα της βάσης δεδομένων");
        }

        return schedule;
    }

    public void updateAppointments(Appointment appointment) { //TODO: Class
        //Update
    }

    public void removeAppointment(Appointment appointment) { //TODO: Class
        //Remove
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
            MessageHelper.showErrorMessage(DATABASE_ERROR_MESSAGE);
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
            MessageHelper.showErrorMessage(DATABASE_ERROR_MESSAGE);
        }

        return roles;
    }

    public void deleteApplication(Application application) {  //TODO: New method
        String update = "DELETE FROM application WHERE email LIKE '" + application.getEmail() + "';";
        Connection connection = connect();
        try {
            PreparedStatement pst = connection.prepareStatement(update);
            pst.executeUpdate();
            pst.close();
            connection.close();
        } catch (SQLException e) {
            MessageHelper.showErrorMessage(DATABASE_ERROR_MESSAGE);
        }
    }

    public Application retrieveApplication(String name, String surname) { //TODO: New method
        String query = "SELECT name, surname, email, application, evaluated, review, accepted FROM application WHERE name LIKE '" + name + "' AND surname LIKE '" + surname + "';";
        Connection connection = connect();
        Application application = new Application();

        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                application.setName(rs.getString(1));
                application.setSurname(rs.getString(2));
                application.setEmail(rs.getString(3));
                application.setRecruitmentApplication(new File(rs.getString(4)));
                boolean evaluated;
                evaluated = !rs.getString(5).equals("0");
                application.setEvaluated(evaluated);
                application.setReview(rs.getString(6));
                boolean accepted;
                accepted = !rs.getString(7).equals("0");
                application.setAccepted(accepted);
            }
            rs.close();
            pst.close();
            connection.close();
        } catch (SQLException e) {
            MessageHelper.showErrorMessage(DATABASE_ERROR_MESSAGE);
        }

        return application;
    }

    public void saveApplication(Application application) { //TODO: New method
        boolean evaluated = application.isEvaluated();
        String review = application.getReview();
        boolean accepted = application.isAccepted();
        String email = application.getEmail();
        String update = "UPDATE application SET evaluated = " + evaluated + ", review = " + review + ", accepted = " + accepted + " WHERE email LIKE '" + email + "';";
        Connection connection = connect();

        try {
            PreparedStatement pst = connection.prepareStatement(update);
            pst.executeUpdate();
            pst.close();
            connection.close();
        } catch (SQLException e) {
            MessageHelper.showErrorMessage(DATABASE_ERROR_MESSAGE);
        }
    }
}
