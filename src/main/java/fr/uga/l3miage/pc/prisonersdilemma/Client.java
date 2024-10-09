package fr.uga.l3miage.pc.prisonersdilemma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            String fromServer;
            if ((fromServer = input.readLine()) != null && fromServer.contains("Veuillez entrer le nombre de tours")) {
                System.out.println(fromServer);
                String nbTours = console.readLine();
                output.println(nbTours);
            }

            while ((fromServer = input.readLine()) != null) {
                System.out.println(fromServer);
                if (fromServer.startsWith("Tour")) {
                    String choice = console.readLine();
                    output.println(choice);
                }
            }
        }
    }
}

