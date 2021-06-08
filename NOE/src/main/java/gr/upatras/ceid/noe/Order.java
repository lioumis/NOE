
package gr.upatras.ceid.noe;

import gr.upatras.ceid.noe.utilities.DatabaseConnection;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * @author Emmanouil Boursalis
 */
public class Order {
    private HashMap<Supply, Integer> supplies;
    private LocalDateTime date;

    public HashMap<Supply, Integer> getSupplies() {
        return supplies;
    }

    public void setSupplies(HashMap<Supply, Integer> supplies) {
        this.supplies = supplies;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void save() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.saveOrder(this);
    }
}
