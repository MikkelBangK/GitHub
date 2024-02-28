package Opgave4UDP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Talk23VUDPClient {
    public static void main(String args[]) throws Exception {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();

        InetAddress IPAddress = InetAddress.getByName("localhost"); // Serverens IP-adresse
        byte[] sendData;
        byte[] receiveData = new byte[1024];

        while (true) {
            System.out.println("Indtast navn for at få IP, 'GET_ALL_CLIENTS' for at få en liste af alle klienter, eller 'exit' for at afslutte:");
            String input = inFromUser.readLine();
            if (input.equals("exit")) {
                break;
            }

            String sentence;
            if (input.equals("GET_ALL_CLIENTS")) {
                sentence = "GET_ALL_CLIENTS";
            } else {
                sentence = "GET_IP_FOR " + input;
            }

            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
            clientSocket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String modifiedSentence = new String(receivePacket.getData(), 0, receivePacket.getLength());

            System.out.println("Fra Server: " + modifiedSentence);
        }
        clientSocket.close();
    }
}

