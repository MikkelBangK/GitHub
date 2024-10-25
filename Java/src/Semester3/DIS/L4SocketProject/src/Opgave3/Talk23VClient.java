package Opgave3;

import java.io.IOException;
import java.net.Socket;

public class Talk23VClient {
    public static void main(String[] args) throws Exception, IOException {
        Socket clientSocket = new Socket("localhost", 6789);

        Thread readerThread = new Thread(new ThreadReader(clientSocket));
        Thread writerThread = new Thread(new ThreadWriter(clientSocket));

        readerThread.start();
        writerThread.start();
        }
    }

