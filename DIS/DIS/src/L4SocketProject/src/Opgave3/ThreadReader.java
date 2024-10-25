package Opgave3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ThreadReader extends Thread{

    BufferedReader reader;
    public ThreadReader(Socket socket) throws IOException {
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void run(){
        try {
            BufferedReader inFromServer = new BufferedReader(reader);
            String modifiedSentence;
            while ((modifiedSentence = inFromServer.readLine()) != null) {
                System.out.println("FROM SENDER: " + modifiedSentence);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

