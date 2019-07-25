package main.server;

import main.personnel.Faculty;
import main.personnel.Researcher;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread implements Runnable {

    private Socket clientSocket;
    private ObjectOutputStream out;
    private ObjectInputStream in; //TODO: Add a job for input stream

    ServerThread(Socket clientSocket) {
        if(clientSocket == null) throw new IllegalArgumentException("Client socket is empty");

        this.clientSocket = clientSocket;
        try {
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(clientSocket.getInputStream());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


    //TODO: Address file reading issue for all faculty, staff, and student classes
    public void run() {
        try {
            while (true) {
                Faculty faculty = (Researcher) in.readObject(); //Temp
                Server.addFaculty(faculty);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
