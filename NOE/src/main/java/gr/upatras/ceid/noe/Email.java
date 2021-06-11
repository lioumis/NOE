package gr.upatras.ceid.noe;

import java.util.ArrayList;

public class Email {


    private ArrayList<String> recipients; //TODO: Was recepients which is wrong. Update class.
    private String subject;
    private String body;

    public ArrayList<String> getRecipients() {
        return recipients;
    } //TODO: Was recepients which is wrong. Update class.

    public void setRecipients(ArrayList<String> recipients) {
        this.recipients = recipients;
    } //TODO: Was recepients which is wrong. Update class.

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean send() {
        return true;
    }
}
