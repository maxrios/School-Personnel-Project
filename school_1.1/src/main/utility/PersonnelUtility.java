package main.utility;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class PersonnelUtility {

    private static final int ID_MIN_VALUE = 10000000;
    private static final int ID_MAX_VALUE = 99999999;
    private static Set<String> facultyIDsInUse = new HashSet<>();
    private static Set<String> staffIDsInUse = new HashSet<>();
    private static Set<String> studentIDsInUse = new HashSet<>();
    private static Set<String> emailHeaders = new HashSet<>();

    public static String generateFacultyID( ) {
        String ID;
        do {
            ID = "F" + ThreadLocalRandom.current().nextInt(ID_MIN_VALUE, ID_MAX_VALUE + 1);
        } while(!facultyIDsInUse.add(ID)); //Generates a new faculty ID until an original is made

        return ID;
    }

    public static String generateStaffID() {
        String ID;
        do {
            ID = "S" + ThreadLocalRandom.current().nextInt(ID_MIN_VALUE, ID_MAX_VALUE + 1);
        } while(!staffIDsInUse.add(ID));

        return ID;
    }

    public static String generateStudentID() {
        String ID;
        do {
            ID = "M" + ThreadLocalRandom.current().nextInt(ID_MIN_VALUE, ID_MAX_VALUE + 1);
        } while(!studentIDsInUse.add(ID));

        return ID;
    }

    public static String generateEmail(String firstName, String lastName) {
        String emailHeader = lastName.toLowerCase() + firstName.substring(0, 1).toLowerCase()
                , email = emailHeader;
        if(!emailHeaders.add(email)) { //Checks for multiple uses of email header
            int i = 1;
            while(!emailHeaders.add(email)) { //Adds number place after header if in use
                email = emailHeader + i;
            }
        }

        return email + "@merced.edu";
    }
}
