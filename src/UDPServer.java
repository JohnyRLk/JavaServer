
import java.net.*;
public class UDPServer {
    public static void main(String args[]) throws Exception
    {
        DatagramSocket serverSocket = new DatagramSocket(45987);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        sendData = "21651\n762901\n".getBytes();

        while(true)
        {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());

            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();

            if(!sentence.isEmpty()){
                //System.out.println(IPAddress.toString());
                System.out.println(sentence);
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                serverSocket.send(sendPacket);

            }
        }
    }
}
