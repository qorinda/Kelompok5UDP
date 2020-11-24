/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendfileudp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author TOSHIBA
 */
public class ServerQorinda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        DatagramSocket ds = new DatagramSocket(9090); // definisikan var ds dari datagramsocket ber port 9090
        byte[] b = new byte[1024]; //definisikan var b dari byte array 1024
        DatagramPacket dp = new DatagramPacket(b, b.length); //definisikan var dp dari datagrampacket
        ds.receive(dp);  //panggil method receive yang berparameter dp pada var ds
        byte[] bs = dp.getData(); //buat var bs dari byte array yang isinya dp.getData
        int length = dp.getLength(); //buat var length dari int yang isinya dp.getLength
        FileOutputStream fos = new FileOutputStream("C:\\Users\\TOSHIBA\\fileServer.txt"); //tempat menyimpan file
        fos.write(bs, 0, length); //panggil method write dengan parameter bs, 0, length
        fos.close();
        ds.close();
    }
    
}
