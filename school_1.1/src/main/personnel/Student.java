package main.personnel;

import main.utility.PersonnelUtility;

import java.io.Serializable;

public class Student implements Serializable {

    //Required
    private String firstName, lastName, ID, email, dateOfBirth;
    private int totalCreditsTaken = 0, currentTermCredits;
    private boolean isFullTime, isPartTime;
    //Optional
    private String phone;
    //Stats
    private static int numberOfStudents = 0;

    private Student(String firstName, String lastName, String dateOfBirth, int currentTermCredits) {
        if(firstName == null || firstName.trim().isEmpty()) throw new IllegalArgumentException("Missing first name");
        if(lastName == null || lastName.trim().isEmpty()) throw new IllegalArgumentException("Missing last name");
        if(currentTermCredits <= 0 || currentTermCredits > 18) throw new IllegalArgumentException("Invalid credit amount");

        this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
        this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
        this.ID = PersonnelUtility.generateStudentID();
        this.email = PersonnelUtility.generateEmail(firstName, lastName);
        this.currentTermCredits = currentTermCredits;
        this.totalCreditsTaken += currentTermCredits;

        if(currentTermCredits >= 12) {
            this.isFullTime = true;
            this.isPartTime = false;
        }
        else {
            this.isFullTime = false;
            this.isPartTime = true;
        }

        numberOfStudents++;
    }

    public Student(String firstName, String lastName, String dateOfBirth, int currentTermCredits, String phone) {
        this(firstName, lastName, dateOfBirth, currentTermCredits);

        if(!(phone == null || phone.trim().isEmpty())) this.phone = phone;
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
}
