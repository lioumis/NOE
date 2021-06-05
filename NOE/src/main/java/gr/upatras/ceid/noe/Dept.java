
package gr.upatras.ceid.noe;

import java.time.LocalDateTime;

/**
 *
 * @author Emmanouil Boursalis
 */
public class Dept {
    private TreatmentCost cost;
    private boolean paid;
    private LocalDateTime paymentDate;

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public TreatmentCost getCost() {
        return cost;
    }

    public void setCost(TreatmentCost cost) {
        this.cost = cost;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    
}
