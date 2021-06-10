package gr.upatras.ceid.noe.controllers;

import gr.upatras.ceid.noe.Email;
import gr.upatras.ceid.noe.HospitalBudget;
import gr.upatras.ceid.noe.utilities.DatabaseConnection;
import gr.upatras.ceid.noe.utilities.MessageHelper;

import java.util.ArrayList;

/**
 * @author Evangelos Lioumis
 */
public class BudgetController {
    public HospitalBudget generateBudget(String hospital) { //TODO: Class
        DatabaseConnection databaseConnection = new DatabaseConnection();
        HospitalBudget hospitalBudget = databaseConnection.retrieveBudgetInfo(hospital);
        hospitalBudget.initializeBudget();
        return hospitalBudget;
    }

    public void updateBudget(HospitalBudget budget) { //TODO: Class
        if (validateNotEmpty(budget)) {
            budget.calculate();
            DatabaseConnection databaseConnection = new DatabaseConnection();
            databaseConnection.updateBudgetInfo(budget);
        }
    }

    public boolean createEmail() { //TODO: Class
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String recipient = databaseConnection.retrieveMinistryEmail();
        ArrayList<String> specificRecipients = new ArrayList<>();
        specificRecipients.add(recipient);
        Email email = new Email();
        email.setRecipients(specificRecipients);
        email.setSubject("Hospital Budget");
        email.setBody("");
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
