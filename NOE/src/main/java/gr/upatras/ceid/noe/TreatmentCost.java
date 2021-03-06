
package gr.upatras.ceid.noe;

import gr.upatras.ceid.noe.utilities.DatabaseConnection;

import java.util.HashMap;

/**
 * @author Emmanouil Boursalis
 */
public class TreatmentCost {
    private HashMap<String, Float> costs;
    private float totalCost;

    public HashMap<String, Float> getCosts() {
        return costs;
    }

    public void setCosts(HashMap<String, Float> costs) {
        this.costs = costs;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public void updateCost() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.updateCost(this);
    }
}
