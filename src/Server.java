import java.io.*;
import java.net.*;

public class Server {



    public static void main(String args[]) throws Exception {
        int port =45;
        new Thread(() -> Server.start(port)).start();
        final Socket socket = new Socket("21", 20); 
        final PrintWriter writer = new PrintWriter(socket.getOutputStream(),false);
        {
            writer.println(1);                                        
            writer.flush();
            writer.println("21");                         
            writer.flush();
        }
        socket.close();
    }


    private static class ServerHandler extends Thread {

        public DatagramSocket serverSocket;

        public ServerHandler(DatagramSocket server) {
          
            serverSocket = server;

        }

        public void run() {

            try {

                byte[] receiveData = new byte[1024];
                byte[] receiveData2 = new byte[1024];
                byte[] receiveData3 = new byte[1024];
                byte[] sendData = new byte[1024];
                byte[] sendData2 = new byte[1024];

                DatagramPacket receivePacket =
                        new DatagramPacket(receiveData, receiveData.length);    

                serverSocket.receive(receivePacket);                        

                String sentence = new String(receivePacket.getData());
                InetAddress IPAddress = receivePacket.getAddress();        

                int port = receivePacket.getPort();                         

                System.out.println(sentence + " " + IPAddress);
            
            

               
                String a = "2";                              
                sendData = a.getBytes();


              

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port); 
                serverSocket.send(sendPacket);

                DatagramPacket receivePacket2 =
                        new DatagramPacket(receiveData2, receiveData2.length);    

                serverSocket.receive(receivePacket2);                

                String N = new String(receivePacket2.getData());

                DatagramPacket receivePacket3 =
                        new DatagramPacket(receiveData3, receiveData3.length);   

                serverSocket.receive(receivePacket3);                        

                String X = new String(receivePacket3.getData());
                System.out.println(Thread.currentThread().getName() +" n: " + N );
                System.out.println(Thread.currentThread().getName() + " x: " + X );

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("exception");
            }

        }
    }


    public static void start(int port){
        System.out.println("start");
        try(DatagramSocket serverSocket = new DatagramSocket(45987)){
            while(true){
                ServerHandler sh = new ServerHandler(serverSocket);
                sh.run();
         
            }
        }catch(Exception e){

        }
    }

}