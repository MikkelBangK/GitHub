package Opgave4;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Talk23VClient {
    public static void main(String[] args) throws Exception, IOException {
        //Der bruges TCP, port "7001" benyttes.
        Socket navneSocket = new Socket("localhost", 7001);
        Socket clientSocket;

        DataOutputStream writer = new DataOutputStream(navneSocket.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(navneSocket.getInputStream()));

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Skriv navn:");

            String sentence = scanner.nextLine();
            if (sentence.equals("STOP")) {
                writer.close();
            }
            writer.writeBytes(sentence + '\n');

            String ipAdressen = reader.readLine();
            System.out.println(ipAdressen);
            clientSocket = new Socket(ipAdressen, 6790);

            Thread writerThread = new ThreadWriter(clientSocket);
            Thread readerThread = new ThreadReader(clientSocket);

            readerThread.start();
            writerThread.start();

            clientSocket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }

