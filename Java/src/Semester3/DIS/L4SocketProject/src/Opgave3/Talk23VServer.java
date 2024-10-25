package Opgave3;

import java.net.ServerSocket;
import java.net.Socket;

public class Talk23VServer {
    public static void main(String[] args) throws Exception {
        ServerSocket welcomeSocket = new ServerSocket(6789);
        Socket connectionSocket = welcomeSocket.accept();
        Thread readerThread = new Thread(new ThreadReader(connectionSocket));
        Thread writerThread = new Thread(new ThreadWriter(connectionSocket));

          readerThread.start();
          writerThread.start();
    }
}

