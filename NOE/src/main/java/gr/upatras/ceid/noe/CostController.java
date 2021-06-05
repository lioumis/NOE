package gr.upatras.ceid.noe;

import java.io.File;
import java.util.ArrayList;

/**
 * @author Evangelos Lioumis
 */
public class CostController {
    public TreatmentCost generateCost() {
        return new TreatmentCost();
    }

    public boolean createEmail(ArrayList<String> recepients, String subject, String body) {
        return true;
    }

    private boolean validateNotEmpty() {
        return true;
    }

    private boolean validateCorrect() {
        return true;
    }

    private void calculateCost() {

    }

    private File generateReceipt() {
        return new File("");
    }
}
