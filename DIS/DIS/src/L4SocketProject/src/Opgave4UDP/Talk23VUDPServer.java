package Opgave4UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashMap;

public class Talk23VUDPServer {
    private static HashMap<String, String> klienter = new HashMap<>();

    public static void main(String[] args) throws Exception {
        klienter.put("Kristina", "210.120.11.255");
        klienter.put("Frederikke", "211.110.10.255");

        int serverPort = 9876;
        DatagramSocket serverSocket = new DatagramSocket(serverPort);
        byte[] receiveData = new byte[1024];
        byte[] sendData;

        System.out.println("UDP Server lytter på port " + serverPort);

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData(), 0, receivePacket.getLength()).trim();
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();

            String response = handleCommand(sentence);
            sendData = response.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }

    private static String handleCommand(String command) {
        if (command.startsWith("GET_IP_FOR ")) {
            String name = command.substring("GET_IP_FOR ".length());
            String ip = klienter.get(name);
            if (ip != null) {
                return "IP for " + name + " is: " + ip;
            } else {
                return "No IP found for " + name;
            }
        } else if (command.equals("GET_ALL_CLIENTS")) {
            StringBuilder sb = new StringBuilder();
            klienter.forEach((name, ip) -> sb.append(name).append(": ").append(ip).append("\n"));
            return sb.toString().isEmpty() ? "No clients found" : sb.toString();
        }
        return "Invalid command";
    }
}
