package Opgave4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Talk23VServer {
    public static void main(String[] args) throws Exception {
        try {
            ServerSocket serverSocket = new ServerSocket(6790);

            while (true) {
                Socket connectionSocket = serverSocket.accept();

                Thread readerThread = new ThreadReader(connectionSocket);
                Thread writerThread = new ThreadWriter(connectionSocket);

                readerThread.start();
                writerThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

