package Opgave3;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadWriter extends Thread{

    DataOutputStream writer;

    public ThreadWriter(Socket socket) throws IOException {
        this.writer = new DataOutputStream(socket.getOutputStream());
    }

    public void run() {
        PrintWriter outToServer = new PrintWriter(writer, true);
        Scanner scanner = new Scanner(System.in);
        String sentence;
        while (scanner.hasNextLine()) {
            sentence = scanner.nextLine();
            outToServer.println(sentence + '\n');
        }
    }
    }


