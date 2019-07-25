package main.personnel;

import main.utility.PersonnelUtility;

import java.io.Serializable;

public class Staff implements Serializable {

    //Required
    private String firstName, lastName, ID, dateOfBirth;
    private boolean isFullTime, isPartTime;
    //Stats
    private static int numberOfStaff = 0;

    public Staff() {
        throw new IllegalArgumentException("Enter staff variables");
    }

    public Staff(String firstName, String lastName, String dateOfBirth, boolean isFullTime, boolean isPartTime) {
        if(firstName == null || firstName.trim().isEmpty()) throw new IllegalArgumentException("Missing first name");
        if(lastName == null || lastName.trim().isEmpty()) throw new IllegalArgumentException("Missing last name");
        if(dateOfBirth == null || dateOfBirth.trim().isEmpty()) throw new IllegalArgumentException("Missing date of birth");
        if((isFullTime == true && isPartTime == true) || (isFullTime == false && isPartTime == false))
            throw new IllegalArgumentException("Time availability status equal");

        this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
        this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
        this.ID = PersonnelUtility.generateStaffID();
        this.dateOfBirth = dateOfBirth;
        this.isFullTime = isFullTime;
        this.isPartTime = isPartTime;

        numberOfStaff++;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.trim().isEmpty()) throw new IllegalArgumentException("Missing first name");

        this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.trim().isEmpty()) throw new IllegalArgumentException("Missing last name");

        this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
    }

    public void setFullTime(boolean isFullTime) {
        if(this.isFullTime == isFullTime)
            return;

        this.isFullTime = isFullTime;
        isPartTime = !isPartTime;
    }

    public void setPartTime(boolean isPartTime) {
        if(this.isPartTime == isPartTime)
            return;

        this.isPartTime = isPartTime;
        isFullTime = !isFullTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getID() {
        return ID;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public boolean isPartTime() {
        return isPartTime;
    }

    public static int getNumberOfStaff() {
        return numberOfStaff;
    }

    public int hashCode() {
        return (firstName + lastName + dateOfBirth).hashCode();
    }

    public String toString() {
        return "S[" + getFirstName() + ", " + getLastName() + ", " + getID() + ", " +
                (isFullTime ? "Full-time" : "Part-time") + "]";
    }
}
