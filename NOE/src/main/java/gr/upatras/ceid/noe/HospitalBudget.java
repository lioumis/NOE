
package gr.upatras.ceid.noe;

/**
 * @author Emmanouil Boursalis
 */
public class HospitalBudget {
    private float payroll;
    private float supplyCosts;
    private float functionalCosts;
    private float equipmentCosts;
    private float totalBudget;

    public float getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(float totalBudget) {
        this.totalBudget = totalBudget;
    }

    public float getPayroll() {
        return payroll;
    }

    public void setPayroll(float payroll) {
        this.payroll = payroll;
    }

    public float getSupplyCosts() {
        return supplyCosts;
    }

    public void setSupplyCosts(float supplyCosts) {
        this.supplyCosts = supplyCosts;
    }

    public float getFunctionalCosts() {
        return functionalCosts;
    }

    public void setFunctionalCosts(float functionalCosts) {
        this.functionalCosts = functionalCosts;
    }

    public float getEquipmentCosts() {
        return equipmentCosts;
    }

    public void setEquipmentCosts(float equipmentCosts) {
        this.equipmentCosts = equipmentCosts;
    }


    public void initializeBudget() {
        calculate();
    }

    public void calculate() { //TODO: Class
        this.totalBudget = this.equipmentCosts + this.functionalCosts + this.payroll + this.supplyCosts;
    }
}
