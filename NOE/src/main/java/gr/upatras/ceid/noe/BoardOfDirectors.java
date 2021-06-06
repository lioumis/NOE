
package gr.upatras.ceid.noe;

import java.util.ArrayList;

/**
 * @author Emmanouil Boursalis
 */
public class BoardOfDirectors {
    private ArrayList<String> names;
    private ArrayList<String> surnames;
    private ArrayList<String> emails;

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public ArrayList<String> getSurnames() {
        return surnames;
    }

    public void setSurnames(ArrayList<String> surnames) {
        this.surnames = surnames;
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<String> emails) {
        this.emails = emails;
    }
}
