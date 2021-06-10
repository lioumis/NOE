package gr.upatras.ceid.noe.controllers;

import gr.upatras.ceid.noe.Patient;
import gr.upatras.ceid.noe.ui.ProofOfDischargeScreen;
import gr.upatras.ceid.noe.ui.SecretaryForm;
import gr.upatras.ceid.noe.utilities.DatabaseConnection;
import gr.upatras.ceid.noe.utilities.MessageHelper;

import java.util.ArrayList;

/**
 * @author Evangelos Lioumis
 */
public class SecretaryFormController {
    SecretaryForm secretaryForm;
    ProofOfDischargeScreen proofOfDischargeScreen;

    public void initialize(String name, String surname) { //TODO: Class
        secretaryForm = new SecretaryForm(name, surname);
        secretaryForm.display();

        DatabaseConnection databaseConnection = new DatabaseConnection();
        ArrayList<Patient> patients = databaseConnection.retrievePatients();
        ArrayList<String> emails = databaseConnection.retrieveEmails();

        if (check()) {
            MessageHelper.showSuccessMessage("Ο ασθενής βρέθηκε!");
            proofOfDischargeScreen = new ProofOfDischargeScreen(name, surname, this);
            proofOfDischargeScreen.display();
        } else {
            MessageHelper.showErrorMessage("Ο ασθενής δεν βρέθηκε!");
            return;
        }


    }

    public boolean showMessage() { //TODO: Class
        return MessageHelper.showConfirmationMessage("Αποστολή εξιτηρίου;");
    }

    private boolean check() {
        return true;
    }
}
