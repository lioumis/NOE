package gr.upatras.ceid.noe;

import gr.upatras.ceid.noe.exceptions.NOEAuthenticationException;
import gr.upatras.ceid.noe.utilities.DatabaseConnection;
import gr.upatras.ceid.noe.utilities.MessageHelper;

import java.util.ArrayList;

public class Authenticator {

    private String username;
    private String password;
    private String oneTimePassword;
    private ArrayList<String> roles;
    private int failedAttempts;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOneTimePassword() {
        return oneTimePassword;
    }

    public void setOneTimePassword(String oneTimePassword) {
        this.oneTimePassword = oneTimePassword;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public boolean authenticate() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String userPassword = "";
        ArrayList<String> userRoles = new ArrayList<>();

        try {
            userPassword = databaseConnection.retrieveUserPassword(username);
            passwordsMatch(this.password, userPassword);
        } catch (NOEAuthenticationException e) {
            MessageHelper.showErrorMessage("Τα στοιχεία είναι εσφαλμένα");
            return false;
        }

        try {
            userRoles = databaseConnection.retrieveUserRoles(username);
            if (containsImportantRole(userRoles)) {
                //2 Factor Authentication
            }
        } catch (Exception e) {
            MessageHelper.showErrorMessage("Εσφαλμένος κωδικός");
            return false;
        }
        return true;
    }

    private void passwordsMatch(String password, String userPassword) throws NOEAuthenticationException {
        if (!password.equals(userPassword)) {
            throw new NOEAuthenticationException();
        }
    }

    private boolean containsImportantRole(ArrayList<String> roles) {
        return roles.contains("2") || roles.contains("3") || roles.contains("4") || roles.contains("5");
    }
}
