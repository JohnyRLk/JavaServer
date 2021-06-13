
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;



public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("hello world");
        DatagramSocket serverSocket = new DatagramSocket(3456);

        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        while(true) {
            DatagramPacket receivePacket =
                    new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            System.out.print("result");
            System.out.println(sentence);


            InetAddress IpAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();

            String s = "20240";
            sendData = s.getBytes();
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IpAddress,
                            port);
            serverSocket.send(sendPacket);

            String line = "242328";
            sendData = line.getBytes();
            DatagramPacket sendPacket2 =
                    new DatagramPacket(sendData, sendData.length, IpAddress,
                            port);
            serverSocket.send(sendPacket2);

            DatagramPacket receivePacket2 =
                    new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket2);
            String sentence2 = new String(receivePacket2.getData());
            System.out.print("N");
            System.out.println(sentence2);

            DatagramPacket receivePacket3 =
                    new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket3);
            String sentence3 = new String(receivePacket3.getData());
            System.out.print("X");
            System.out.println(sentence3);


        }

    }
}