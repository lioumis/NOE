package gr.upatras.ceid.noe.controllers;

import gr.upatras.ceid.noe.Appointment;
import gr.upatras.ceid.noe.Doctor;
import gr.upatras.ceid.noe.Evaluation;
import gr.upatras.ceid.noe.Patient;
import gr.upatras.ceid.noe.ui.Form;
import gr.upatras.ceid.noe.utilities.DatabaseConnection;
import gr.upatras.ceid.noe.utilities.MessageHelper;

import java.util.ArrayList;

/**
 * @author NickSxiz
 */
public class EvaluationController {

    public float calculateEvaluations(String doctor, String patient) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        ArrayList<Evaluation> evaluations = databaseConnection.retrieveEvaluations(doctor);
        ArrayList<Appointment> appointments = databaseConnection.retrieveAppointments(doctor, patient);

        if (appointments.isEmpty()) {
            MessageHelper.showErrorMessage("Δεν έχει προηγηθεί ραντεβού με το συγκεκριμένο ιατρό.");
            return 0;
        }

        float eval = 0;
        for (Evaluation evaluation : evaluations) {
            eval = eval + evaluation.getRating();
        }
        eval = eval / evaluations.size();
        return eval;
    }

    public void display(Doctor doctor, Patient patient) {
        if (MessageHelper.showEvaluationProposalMessage("Αξιολόγηση ιατρού;")) {
            displayForm(doctor, patient);
        }

    }

    public void displayForm(Doctor doctor, Patient patient) {
        Form form = new Form(doctor, patient);
        form.setVisible(true);
    }

}