package gr.upatras.ceid.noe;

import java.util.ArrayList;

public class Email {


    private ArrayList<String> recipients; //TODO: Class
    private String subject;
    private String body;

    public ArrayList<String> getRecipients() {
        return recipients;
    } //TODO: Class

    public void setRecipients(ArrayList<String> recipients) {
        this.recipients = recipients;
    } //TODO: Class

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

    public boolean send() { //TODO: Class
        return true;
    }
}



