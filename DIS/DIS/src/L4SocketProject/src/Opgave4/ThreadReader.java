package Opgave4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadReader extends Thread {
    BufferedReader reader;
    public ThreadReader(Socket socket) throws IOException {
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void run(){
        try {
            String modifiedSentence;
             (modifiedSentence = reader.readLine()).isEmpty();
                System.out.println("FROM SENDER: " + modifiedSentence);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


