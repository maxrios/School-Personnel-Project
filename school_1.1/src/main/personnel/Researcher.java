package main.personnel;

import main.utility.PersonnelUtility;
import main.utility.Subject;

import java.io.Serializable;

public class Researcher extends Faculty {

    //Required
    private String email;
    private int lengthOfTermInWeeks;

    public Researcher(String firstName, String lastName, String phone, String dateOfBirth, boolean isFullTime, boolean isPartTime, int lengthOfTermInWeeks) {
        super(firstName, lastName, phone, dateOfBirth, isFullTime, isPartTime);

        if(lengthOfTermInWeeks <= 0) throw new IllegalArgumentException("Invalid term length");

        this.email = PersonnelUtility.generateEmail(firstName, lastName);
        this.lengthOfTermInWeeks = lengthOfTermInWeeks;
    }

    public void setLengthOfTermInWeeks(int lengthOfTermInWeeks) {
        if(lengthOfTermInWeeks <= 0) throw new IllegalArgumentException("Invalid term length");

        this.lengthOfTermInWeeks = lengthOfTermInWeeks;
    }

    public String getEmail() {
        return email;
    }

    public int getLengthOfTermInWeeks() {
        return lengthOfTermInWeeks;
    }

    public String toString() {
        return "R[" + getFirstName() + ", " + getLastName() + ", " + getID() + ", " +
                (isFullTime() ? "Full-time" : "Part-time") + ", " + getEmail() + "]";
    }
}
