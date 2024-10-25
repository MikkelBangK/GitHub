package Opgave4;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Talk23VNavneServer {
    public static void main(String[] args) throws IOException {
        String modifiedSentence;
        String clientSentence;
        String capitalizedSentence;
        String ip = "localhost";

        ServerSocket welcomeSocket = new ServerSocket(7001);
        Socket connectionSocket = welcomeSocket.accept();

        System.out.println("Serveren venter på klient");

        try {


            Map<String, String> liste = new HashMap();

            liste.put("Haukur", "10.10.131.154");
            liste.put("Benjamin", "10.10.131.23");
            liste.put("Mikkel", "10.10.138.46");

            BufferedReader read = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); //infromclient
            DataOutputStream writer = new DataOutputStream(connectionSocket.getOutputStream()); //outtoclient

            System.out.println("Client connected to the server");

            String sentence = read.readLine();

            String ipAdresse = "";
            for (String e : liste.keySet()) {
                if (e.equals(sentence)) {
                    ipAdresse = liste.get(sentence);
                }
            }

            System.out.println(ipAdresse);
            writer.writeBytes(ipAdresse + "\n");


//        while (connectionSocket.isConnected()) {
//            try {
//                modifiedSentence = read.readLine();
//                System.out.println("FROM CLIENT: " + modifiedSentence);
//                if (modifiedSentence.equals("STOP")) {
//                    break;
//                }
//                else if (modifiedSentence.equals("ip")) {
//                    writer.writeBytes("localhost" + '\n');
//                }
//                String sentence = read.readLine();
//
//                String ipAdresse = "";
//                for (String e : liste.keySet()) {
//                    if (e.equals(sentence)) {
//                        ipAdresse = liste.get(sentence);
//                    }
//                }
//
//                System.out.println(ipAdresse);
//                writer.writeBytes(ipAdresse + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//            if () {
//                System.out.println("FROM NAVNESERVER: " + modifiedSentence);
//            } else {
//                outToServer.writeBytes("ERROR! PRØV IGEN!");
//            }

