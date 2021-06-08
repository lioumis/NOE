package gr.upatras.ceid.noe;

import gr.upatras.ceid.noe.utilities.MessageHelper;

import java.util.ArrayList;

/**
 * @author Evangelos Lioumis
 */
public class BudgetController {
    public float generateBudget(String hospital) { //TODO: Class
        DatabaseConnection databaseConnection = new DatabaseConnection();
        HospitalBudget hospitalBudget = databaseConnection.retrieveBudgetInfo(hospital);
        hospitalBudget.initializeBudget();
        return hospitalBudget.getTotalBudget();
    }

    public void updateBudget(HospitalBudget budget) {
        if (validateNotEmpty(budget)) {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            databaseConnection.updateBudgetInfo(budget);
        }
    }

    public boolean createEmail(ArrayList<String> recipients, String subject, String body) { //TODO: Class
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String recipient = databaseConnection.retrieveMinistryEmail();
        ArrayList<String> specificRecipients = new ArrayList<>();
        specificRecipients.add(recipient);
        Email email = new Email();
        email.setRecipients(specificRecipients);
        email.setSubject(subject);
        email.setBody(body);
        return email.send();
    }

    private boolean validateNotEmpty(HospitalBudget budget) { //TODO: Class
        if (budget.getEquipmentCosts() == 0 || budget.getFunctionalCosts() == 0 || budget.getPayroll() == 0 || budget.getSupplyCosts() == 0) {
            MessageHelper.showErrorMessage("Τα πεδία είναι κενά");
            return false;
        } else {
            return true;
        }
    }

    private boolean validateCorrect(HospitalBudget budget) { //TODO: Class
        return true;
    }
}
