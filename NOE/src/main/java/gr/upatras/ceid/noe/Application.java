
package gr.upatras.ceid.noe;

/**
 *
 * @author Emmanouil Boursalis
 */
public class Application {
    private String name;
    private String surname;
    private boolean evaluated;
    private File recruitmentApplication;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isEvaluated() {
        return evaluated;
    }

    public void setEvaluated(boolean evaluated) {
        this.evaluated = evaluated;
    }

    public File getRecruitmentApplication() {
        return recruitmentApplication;
    }

    public void setRecruitmentApplication(File recruitmentApplication) {
        this.recruitmentApplication = recruitmentApplication;
    }
    
}
