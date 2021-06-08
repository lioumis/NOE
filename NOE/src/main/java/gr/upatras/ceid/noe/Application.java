
package gr.upatras.ceid.noe;

import gr.upatras.ceid.noe.utilities.MessageHelper;

import java.io.File;

/**
 * @author Emmanouil Boursalis
 */
public class Application {
    private String name;
    private String surname;
    private String email;
    private boolean evaluated;
    private File recruitmentApplication;
    private String review; //TODO Class diagram
    private boolean accepted; //TODO Class diagram

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isEvaluated() {
        return evaluated;
    }

    public void setEvaluated(boolean evaluated) {
        this.evaluated = evaluated;
    }

    public File getRecruitmentApplication() {
        return recruitmentApplication;
    }

    public void setRecruitmentApplication(File recruitmentApplication) {
        this.recruitmentApplication = recruitmentApplication;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public void check() {

    }

    public void delete() {
        boolean response = MessageHelper.showConfirmationMessage("Είστε σίγουροι πως θέλετε να προχωρήσετε με τη διαγραφή της αίτησης;");
        if (response) {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            databaseConnection.deleteApplication(this);
        }
    }

    public void update() {
        save();
    }

    public void retrieve(String name, String surname) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Application application = databaseConnection.retrieveApplication(name, surname);
        this.name = application.name;
        this.surname = application.surname;
        this.email = application.email;
        this.evaluated = application.evaluated;
        this.recruitmentApplication = application.recruitmentApplication;
        this.review = application.review;
        this.accepted = application.accepted;
    }

    public void save() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.saveApplication(this);
    }
}
