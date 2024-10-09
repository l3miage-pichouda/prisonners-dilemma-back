package fr.uga.l3miage.pc.prisonersdilemma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Serveur en attente de connexions...");

            try (Socket player1 = serverSocket.accept();
                 Socket player2 = serverSocket.accept()) {

                System.out.println("Joueur 1 connecté.");
                System.out.println("Joueur 2 connecté.");

                BufferedReader input1 = new BufferedReader(new InputStreamReader(player1.getInputStream()));
                BufferedReader input2 = new BufferedReader(new InputStreamReader(player2.getInputStream()));

                PrintWriter output1 = new PrintWriter(player1.getOutputStream(), true);
                PrintWriter output2 = new PrintWriter(player2.getOutputStream(), true);

                output1.println("Veuillez entrer le nombre de tours (par exemple, 10) : ");
                int nbTours = Integer.parseInt(input1.readLine());
                System.out.println("Nombre de tours sélectionné : " + nbTours);


                output1.println("La partie va commencer avec " + nbTours + " tours.");
                output2.println("La partie va commencer avec " + nbTours + " tours.");

                int score1 = 0;
                int score2 = 0;
                for (int round = 1; round <= nbTours; round++) {
                    output1.println("Tour " + round + ": Coopérer (c) ou Trahir (t) ?");
                    output2.println("Tour " + round + ": Coopérer (c) ou Trahir (t) ?");

                    String choice1 = input1.readLine();
                    String choice2 = input2.readLine();

                    System.out.println("Joueur 1 : " + choice1 + ", Joueur 2 : " + choice2);

                    int[] scores = calculateScores(choice1, choice2);
                    score1 += scores[0];
                    score2 += scores[1];

                    output1.println("Joueur 2 a choisi: " + choice2 + ". Ton score: " + score1);
                    output2.println("Joueur 1 a choisi: " + choice1 + ". Ton score: " + score2);
                }

                output1.println("Partie terminée! Score final: " + score1);
                output2.println("Partie terminée! Score final: " + score2);
            }
        } catch (IOException e) {

        }
    }

    private static int[] calculateScores(String choice1, String choice2) {
        int score1 = 0;
        int score2 = 0;

        if (choice1.equals("c") && choice2.equals("c")) {
            score1 = 3;
            score2 = 3;
        } else if (choice1.equals("t") && choice2.equals("c")) {
            score1 = 5;
            score2 = 0;
        } else if (choice1.equals("c") && choice2.equals("t")) {
            score1 = 0;
            score2 = 5;
        } else if (choice1.equals("t") && choice2.equals("t")) {
            score1 = 1;
            score2 = 1;
        }

        return new int[]{score1, score2};
    }
}










