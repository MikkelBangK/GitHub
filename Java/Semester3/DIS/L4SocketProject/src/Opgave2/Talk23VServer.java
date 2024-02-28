package Opgave2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Talk23VServer {
    public static void main(String[] args) throws Exception {
        String sentence;
        String modifiedSentence;
        String clientSentence;
        String capitalizedSentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        ServerSocket welcomeSocket = new ServerSocket(6789);
        System.out.println("Serveren venter på klient");
        Socket connectionSocket = welcomeSocket.accept();
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        System.out.println("Klient forbundet til Server");
        while (connectionSocket.isConnected()) {
            modifiedSentence = inFromClient.readLine();
            System.out.println("FROM CLIENT: " + modifiedSentence);
            if (modifiedSentence.equals("STOP")){
                break;
            }
            sentence = inFromUser.readLine();
            outToClient.writeBytes(sentence + '\n');
        }
    }
}

