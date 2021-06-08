package gr.upatras.ceid.noe;

import gr.upatras.ceid.noe.utilities.MessageHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Evangelos Lioumis
 */
public class CostController {
    public File generateCost(String patientName) { //TODO Add to class diagram
        if(validateNotEmpty(patientName) && validateCorrect(patientName)){
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Patient patient = databaseConnection.searchPatient(patientName);
            boolean confirmation = MessageHelper.showConfirmationMessage("Ο ασθενής βρέθηκε. Συνέχεια;");
            if(confirmation){
                TreatmentCost treatmentCost = databaseConnection.searchHospitalizationCost(patient.getAfm());
                float total = calculateCost(treatmentCost);
                File receipt = generateReceipt(total, treatmentCost);
                treatmentCost.setTotalCost(total);
                treatmentCost.updateCost();
                return receipt;
            }
        }
        return null;
    }

    public boolean createEmail(ArrayList<String> recipients, String subject, String body) {
        return true;
    }

    private boolean validateNotEmpty(String patient) {
        if(patient == null || patient.equals("")){
            MessageHelper.showErrorMessage("Συμπληρώστε τα δεδομένα!");
            return false;
        } else {
            return true;
        }
    }

    private boolean validateCorrect(String patient) {
        return true;
    }

    private float calculateCost(TreatmentCost treatmentCost) { //TODO Add to class diagram
        HashMap<String, Float> costs = treatmentCost.getCosts();
        float totalCost = 0;
        for(float cost: costs.values()){
            totalCost = totalCost + cost;
        }
        return totalCost;
    }

    private File generateReceipt(float total, TreatmentCost treatmentCost) { //TODO Add to class diagram
        //Receipt is generated and returned
        return new File("");
    }
}
