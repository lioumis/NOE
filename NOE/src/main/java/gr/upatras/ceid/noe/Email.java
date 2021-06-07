package gr.upatras.ceid.noe;

import java.util.ArrayList;

public class Email {


    private ArrayList<String> recepients;
    private String subject;
    private String body;

    public ArrayList<String> getRecepients() {
        return recepients;
    }

    public void setRecepients(ArrayList<String> recepients) {
        this.recepients = recepients;
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

    public void send() {
    }
}



