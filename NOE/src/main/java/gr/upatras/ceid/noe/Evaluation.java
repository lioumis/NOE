package gr.upatras.ceid.noe;

/**
 * @author NickSxiz
 */
public class Evaluation {
    private Doctor doctor;
    private Patient patient;
    private int rating;
    private String comment;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Evaluation getEvaluation() {
        return this;
    }
}
