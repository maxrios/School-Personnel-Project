package main.utility;

import main.personnel.Faculty;
import main.personnel.Staff;

import java.util.Collection;
import java.util.HashMap;

public class PersonnelMap {

    private HashMap<String, Faculty> facultyHashMap;
    private HashMap<String, Staff> staffHashMap;

    public PersonnelMap() {
        facultyHashMap = new HashMap<>();
        staffHashMap = new HashMap<>();
    }

    public Faculty addFaculty(Faculty faculty) {
        if(faculty == null || faculty.getFirstName().isEmpty() || faculty.getLastName().isEmpty() ||
                faculty.getID().isEmpty() || faculty.getPhone().isEmpty())
                    throw new IllegalArgumentException("Faculty is missing a parameter");

        for(Faculty f : facultyHashMap.values()) {
            if(f.hashCode() == faculty.hashCode())
                throw new IllegalArgumentException("Multiple instances of faculty");
        }

        return facultyHashMap.put(faculty.getID(), faculty);
    }

    public Faculty removeFaculty(String ID) {
        if(ID == null || ID.trim().isEmpty()) throw new IllegalArgumentException("No ID found");

        return facultyHashMap.remove(ID);
    }

    public Collection<Faculty> getFacultyMap() {
        return facultyHashMap.values();
    }
}
