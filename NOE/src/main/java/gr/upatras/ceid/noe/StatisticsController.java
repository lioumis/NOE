package gr.upatras.ceid.noe;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * @author Evangelos Lioumis
 */
public class StatisticsController {
    private LocalDateTime from;
    private LocalDateTime to;
    private HashMap<String, Integer> diseases;
    private int deaths;
    private int availableBeds;
    private int hospitalizations;
    private ArrayList<TreatmentCost> treatmentCosts;

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }

    public HashMap<String, Integer> getDiseases() {
        return diseases;
    }

    public void setDiseases(HashMap<String, Integer> diseases) {
        this.diseases = diseases;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getAvailableBeds() {
        return availableBeds;
    }

    public void setAvailableBeds(int availableBeds) {
        this.availableBeds = availableBeds;
    }

    public int getHospitalizations() {
        return hospitalizations;
    }

    public void setHospitalizations(int hospitalizations) {
        this.hospitalizations = hospitalizations;
    }

    public ArrayList<TreatmentCost> getTreatmentCosts() {
        return treatmentCosts;
    }

    public void setTreatmentCosts(ArrayList<TreatmentCost> treatmentCosts) {
        this.treatmentCosts = treatmentCosts;
    }

    public void initializeStatistics() {

    }

    private void calculateStatistics() {

    }
}
