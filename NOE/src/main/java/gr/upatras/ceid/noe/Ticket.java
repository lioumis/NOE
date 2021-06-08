
package gr.upatras.ceid.noe;

import java.util.Date;

/**
 * @author Emmanouil Boursalis
 */
public class Ticket {
    private String hospitalizationReason;
    private Date hospitalizationDate;
    private Doctor responsibleDoctor;

    public String getHospitalizationReason() {
        return hospitalizationReason;
    }

    public void setHospitalizationReason(String hospitalizationReason) {
        this.hospitalizationReason = hospitalizationReason;
    }

    public Date getHospitalizationDate() {
        return hospitalizationDate;
    }

    public void setHospitalizationDate(Date hospitalizationDate) {
        this.hospitalizationDate = hospitalizationDate;
    }

    public Doctor getResponsibleDoctor() {
        return responsibleDoctor;
    }

    public void setResponsibleDoctor(Doctor responsibleDoctor) {
        this.responsibleDoctor = responsibleDoctor;
    }
}
