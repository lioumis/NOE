
package gr.upatras.ceid.noe;

/**
 *
 * @author Emmanouil Boursalis
 */
public class HospitalBudget {
    private float payroll;
    private float supplyCosts;
    private float functionalCosts;
    private float equipmentCosts;
    private float Budget;

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
    
    
    public void initializeBudget(){
        
    }
    
    private void calculate(){
    
    }
    
    public float getBudget(){
        return Budget;
    }
    
   
    public void setBudget(float Budget){
        this.Budget = Budget;
    }
    
}
