package main.personnel;

import main.utility.PersonnelUtility;

import java.io.Serializable;

public class Faculty implements Serializable {
    //Required
    private String firstName, lastName, ID, phone, dateOfBirth;
    private boolean isFullTime, isPartTime;
    //Stats
    private static int numberOfFaculty = 0;

    public Faculty() {
        throw new IllegalArgumentException("Enter faculty variables");
    }

    public Faculty(String firstName, String lastName, String phone, String dateOfBirth, boolean isFullTime, boolean isPartTime) {
        if(firstName == null || firstName.trim().isEmpty()) throw new IllegalArgumentException("Missing first name");
        if(lastName == null || lastName.trim().isEmpty()) throw new IllegalArgumentException("Missing last name");
        if(phone == null || phone.trim().isEmpty()) throw new IllegalArgumentException("Missing phone");
        if(dateOfBirth == null || dateOfBirth.trim().isEmpty()) throw new IllegalArgumentException("Missing date of birth");
        if((isFullTime == true && isPartTime == true) || (isFullTime == false && isPartTime == false))
            throw new IllegalArgumentException("Time availability status equal");

        this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
        this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
        this.ID = PersonnelUtility.generateFacultyID();
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.isFullTime = isFullTime;
        this.isPartTime = isPartTime;

        numberOfFaculty++;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.trim().isEmpty()) throw new IllegalArgumentException("Missing first name");

        this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.trim().isEmpty()) throw new IllegalArgumentException("Missing last name");

        this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
    }

    public void setPhone(String phone) {
        if(phone == null || phone.trim().isEmpty()) throw new IllegalArgumentException("Missing phone");

        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public boolean isPartTime() {
        return isPartTime;
    }

    public static int getNumberOfFaculty() {
        return numberOfFaculty;
    }

    public int hashCode() {
        return (firstName + lastName + dateOfBirth).hashCode();
    }

    public String toString() {
        return "F[" + getFirstName() + ", " + getLastName() + ", " + getID() + ", " + getPhone() + ", " +
                (isFullTime ? "Full-time" : "Part-time") + "]";
    }
}
