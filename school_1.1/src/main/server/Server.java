package main.server;

import main.personnel.*;
import main.utility.PersonnelMap;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Server {

    private static final int PORT = 9977;
    private static int clientNum = 1;
    private static PersonnelMap personnelMap;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        personnelMap = new PersonnelMap();

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("School server starting...");

            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + clientNum + " connected...");
                ServerThread serverThread = new ServerThread(socket);
                serverThread.run();
                clientNum++;
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static Faculty addFaculty(Faculty faculty) {
        return personnelMap.addFaculty(faculty);
    }

    public static void emitFacultyMap() {

    }
}
