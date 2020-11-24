/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendfileudp;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author TOSHIBA
 */
public class ClientQorinda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        // TODO code application logic here
        DatagramSocket ds = new DatagramSocket();
        File file = new File("C:\\Users\\TOSHIBA\\kelompok5.txt");
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bao = new ByteArrayOutputStream((int) file.length());
        byte[] b = new byte[1024];
        int len;
        while ((len = fis.read(b)) != -1) {
            bao.write(b, 0, len);
        }
        byte[] bs = bao.toByteArray();
        DatagramPacket dp = new DatagramPacket(bs, bs.length, InetAddress.getByName("10.10.10.8"), 9090);
        ds.send(dp);
        fis.close();
        ds.close();
    }
    
}
