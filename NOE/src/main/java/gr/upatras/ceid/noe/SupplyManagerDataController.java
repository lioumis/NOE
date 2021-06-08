
package gr.upatras.ceid.noe;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Emmanouil Boursalis
 */
public class SupplyManagerDataController {

    public void askData() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        ArrayList<Supply> supplies = databaseConnection.getSupplies();
        calculate(supplies);
    }

    private void calculate(ArrayList<Supply> supplies) { //TODO: Class
        //Calculate
    }

    public void create(HashMap<Supply, Integer> supplies) {//TODO: FIX PROBLEM HERE (ORDER HISTORY) //TODO: Class
        //Create
        Order order = new Order();
        order.setDate(LocalDateTime.now());
        order.setSupplies(supplies);
    }
}
