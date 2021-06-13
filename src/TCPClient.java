

import java.io.IOException;
import java.io.*;  
import java.net.Socket;
   

public class TCPClient {
 
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("172.21.48.133", 20001); 
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
 
            outToServer.println("1");
            outToServer.println("12"); 
 
 
            String line;
            while ((line = inFromServer.readLine()) != null) {
                System.out.println(line);
            }
 
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
}

