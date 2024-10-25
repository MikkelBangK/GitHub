import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class UDPClientG {
    public static void main(String args[]) throws Exception {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
                System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("255.255.255.255");
        clientSocket.setBroadcast(true);
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData,
                sendData.length, IPAddress, 9876);
        clientSocket.setSoTimeout(3000);
        clientSocket.send(sendPacket);
        int i = 0;
        while (i < 4) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData,
                    receiveData.length);
            try {
                clientSocket.receive(receivePacket);
                String modifiedSentence = new String(receivePacket.getData());
                InetAddress IPAddress2 = receivePacket.getAddress();
                System.out.println(IPAddress2.toString());
                System.out.println("FROM SERVER:" + modifiedSentence);
            } catch (SocketTimeoutException e) {
                i++;
            }

        }
    }
}
