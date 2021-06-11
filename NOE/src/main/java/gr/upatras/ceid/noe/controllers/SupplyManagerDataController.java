
package gr.upatras.ceid.noe.controllers;

import gr.upatras.ceid.noe.Order;
import gr.upatras.ceid.noe.Supply;
import gr.upatras.ceid.noe.utilities.DatabaseConnection;

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

    private void calculate(ArrayList<Supply> supplies) {
        //Calculate
    }

    public void create(HashMap<Supply, Integer> supplies) {
        //Create
        Order order = new Order();
        order.setDate(LocalDateTime.now());
        order.setSupplies(supplies);
    }
}
