/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatudp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author TOSHIBA
 */
public class ClientChatUDP {
    public static DatagramSocket d;
    public static byte buffer[] = new byte[1024];
    public static int clientport = 800, serverport = 900;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws SocketException, IOException {
        // TODO code application logic here
        BufferedReader bacaClient =new BufferedReader(new InputStreamReader(System.in));
      InetAddress IP = InetAddress.getByName("10.10.10.8");
      DatagramSocket socketClient = new DatagramSocket();
      
      while(true) {
      byte[] kirimBuffer = new byte[1024]; 
      byte[] terimaBuffer = new byte[1024]; 
      
      System.out.print("\nClient: "); 
      String clientData = bacaClient.readLine();
      kirimBuffer = clientData.getBytes(); 
      
      DatagramPacket sendPacket = new DatagramPacket(kirimBuffer, kirimBuffer.length, IP, 1510);
      
      socketClient.send(sendPacket);
      
     
      if(clientData.equalsIgnoreCase("bye")) {
          System.out.println("Connection ended by client");
          break;
      }
      
      DatagramPacket receivePacket = new DatagramPacket(terimaBuffer, terimaBuffer.length);
      socketClient.receive(receivePacket);
      String serverData = new String(receivePacket.getData()); 
      System.out.print("\nServer: " + serverData); 
          
      }
      socketClient.close();
    }
}
