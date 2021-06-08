package gr.upatras.ceid.noe;

/**
 * @author NickSxiz
 */
public class FormController {

    public boolean checkForErrors(Evaluation evaluation) { //TODO: Class
        return true;

    }

    public boolean checkForEmpties(Evaluation evaluation) { //TODO: Class
        return true;

    }

    public void save(Evaluation evaluation) { //TODO: Class
        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.saveEvaluation(evaluation);
    }
}