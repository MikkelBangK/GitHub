package Opgave2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Talk23VClient {
    public static void main(String[] args) throws Exception, IOException {

        String sentence;
        String modifiedSentence;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("localhost", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        System.out.println("Indtast et ord");
        while (!clientSocket.isClosed()) {
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            sentence = inFromUser.readLine();
            outToServer.writeBytes(sentence + '\n');
            modifiedSentence = inFromServer.readLine();
            if (modifiedSentence.equals("STOP")) {
                clientSocket.close();
            }
            System.out.println("FROM SERVER: " + modifiedSentence);
        }
    }
}
