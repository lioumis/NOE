package gr.upatras.ceid.noe;

import java.util.ArrayList;

public class Email {


    private ArrayList<String> recipients;
    private String subject;
    private String body;

    public ArrayList<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(ArrayList<String> recipients) {
        this.recipients = recipients;
    }

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
