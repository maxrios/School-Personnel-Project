package main.personnel;

import main.utility.PersonnelUtility;
import main.utility.Subject;

public class Professor extends Faculty {

    private String office, email;
    private Subject subject;

    public Professor(String firstName, String lastName, String phone, String dateOfBirth, boolean isFullTime, boolean isPartTime,
                        String office, Subject subject) {
        super(firstName, lastName, phone, dateOfBirth, isFullTime, isPartTime);

        if(office == null || office.isEmpty()) throw new IllegalArgumentException("Missing office");
        if(subject == null) throw new IllegalArgumentException("Missing subject");

        this.office = office;
        this.subject = subject;
        this.email = PersonnelUtility.generateEmail(firstName, lastName);
    }

    public void setOffice(String office) {
        if(office == null || office.isEmpty()) throw new IllegalArgumentException("Missing office");

        this.office = office;
    }

    public void setSubject(Subject subject) {
        if(subject == null) throw new IllegalArgumentException("Missing subject");

        this.subject = subject;
    }

    public String getOffice() {
        return office;
    }

    public String getSubject() {
        return subject.getAbbreviation();
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return "P[" + getFirstName() + ", " + getLastName() + ", " + getID() + ", " +
                    (isFullTime() ? "Full-time" : "Part-time") + ", " + getOffice() + ", " + getEmail() + ", " +
                        getSubject() + "]";
    }
}
