package gr.upatras.ceid.noe.controllers;

import gr.upatras.ceid.noe.Evaluation;
import gr.upatras.ceid.noe.utilities.DatabaseConnection;

/**
 * @author NickSxiz
 */
public class FormController {

    public boolean checkForErrors(Evaluation evaluation) {
        return true;

    }

    public boolean checkForEmpties(Evaluation evaluation) {
        return true;

    }

    public void save(Evaluation evaluation) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.saveEvaluation(evaluation);
    }
}