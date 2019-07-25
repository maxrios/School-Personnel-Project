package main;

import main.personnel.*;
import main.utility.PersonnelMap;

import java.io.*;


public class Driver {

    public static void main(String[] args) {
        PersonnelMap personnelMap = new PersonnelMap();
        Researcher max = new Researcher("Maximiliano", "Rios", "3059246126",
                "03191999", true, false, 16);
        Researcher carmen = new Researcher("Carmen", "Rios", "3059246126",
                "03191999", true, false, 16);
        Researcher jose = new Researcher("Jose", "Rios", "3059246126",
                "03191999", true, false, 16);


        System.out.println(personnelMap.addFaculty(max));
        System.out.println(personnelMap.addFaculty(carmen));
        System.out.println(personnelMap.addFaculty(jose));

//        try {
//            PrintStream ps = new PrintStream(new FileOutputStream("Faculty.txt", false));
//            for (Faculty f : personnelMap.getFacultyMap())
//                ps.println(f);
//
//            ps.close();
//        } catch(IOException e) {
//            e.printStackTrace();
//        }

    }
}
