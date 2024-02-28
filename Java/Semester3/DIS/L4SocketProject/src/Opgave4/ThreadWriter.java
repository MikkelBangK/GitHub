package Opgave4;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ThreadWriter extends Thread{

    DataOutputStream writer;

    public ThreadWriter(Socket socket) throws IOException {
        this.writer = new DataOutputStream(socket.getOutputStream());
    }

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            String sentence;
            while (!(sentence = scanner.nextLine()).equals("STOP")) {
                writer.writeBytes(sentence + '\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }


