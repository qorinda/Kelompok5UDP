/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaudpti3aqorinda;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author TOSHIBA
 */
public class JavaUDPPengirim implements Runnable{

    @Override
    public void run() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    try {
            InetAddress ia = InetAddress.getByName("10.10.10.8");
//            InetAddress ia = InetAddress.getByName("localhost");
            int port=1111;
//            Scanner s = new Scanner(System.in);
//            System.out.println("Masukkan Pesan = ");
//            String pesan = s.nextLine();
//------------Posisi Kursor
            PointerInfo a;
            Point b;
            int x;
            int y;
            
        while(true){
            a=MouseInfo.getPointerInfo();
            b=a.getLocation();
            x=(int)b.getX();
            y=(int)b.getY();
                String pesanX =String.valueOf(x);
                String pesanY =String.valueOf(y);
                String pesan =pesanX+"|"+pesanY+"|";
                byte[] data=pesan.getBytes();
                DatagramPacket dp=new DatagramPacket(data,data.length,ia,port);
                DatagramSocket ds=new DatagramSocket();
                Thread.sleep(100);
                ds.send(dp);
                System.out.println(pesan);
        } 
        } catch (Exception e) {
        }
    }
    
}
