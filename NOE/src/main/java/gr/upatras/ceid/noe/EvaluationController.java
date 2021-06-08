package gr.upatras.ceid.noe;

import gr.upatras.ceid.noe.utilities.MessageHelper;

import java.util.ArrayList;

/**
 * @author NickSxiz
 */
public class EvaluationController {

    public float calculateEvaluations(String doctor, String patient) { //TODO: Class
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

    public void display(String doctor) {//TODO: Class
        if (MessageHelper.showEvaluationProposalMessage("Αξιολόγηση ιατρού;")) {
            displayForm(doctor);
        }

    }

    public void displayForm(String doctor) { //TODO: Class
        //Form form = new Form(doctor); //TODO: Add after UI changes
        //form.setVisible(true);
    }

}