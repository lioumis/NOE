package gr.upatras.ceid.noe;

import java.util.HashMap;

public class OrderSettings {

    private HashMap<Supply, Integer> threshholds;


    public HashMap<Supply, Integer> getThreshholds() {
        return threshholds;
    }

    public void setThreshholds(HashMap<Supply, Integer> threshholds) {
        this.threshholds = threshholds;
    }


}