package gr.upatras.ceid.noe;

import java.util.HashMap;

public class OrderSettings {

    private HashMap<Supply, Integer> thresholds;

    public HashMap<Supply, Integer> getThresholds() {
        return thresholds;
    }

    public void setThresholds(HashMap<Supply, Integer> thresholds) {
        this.thresholds = thresholds;
    }
}
