package gr.upatras.ceid.noe;

public class Patient {

    private Ticket ticket;
    private DischargeNote dischargeNote;
    private String medicalHistory;


    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public DischargeNote getDischargeNote() {
        return dischargeNote;
    }

    public void setDischargeNote(DischargeNote dischargeNote) {
        this.dischargeNote = dischargeNote;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}
