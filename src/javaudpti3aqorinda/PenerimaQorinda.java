/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaudpti3aqorinda;

import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author TOSHIBA
 */
public class PenerimaQorinda implements Runnable{

    @Override
    public void run() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try {
            byte[] buffer = new byte[65];
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            DatagramSocket ds = new DatagramSocket(1111);
            while(true){
                ds.receive(dp);
            byte[] data = dp.getData();
            String pesan = new String(data,0,data.length);
            System.out.println("Pesan dari teman anda adalah = " + pesan);
//          -------100|200|
//          String[] posisi=pesan.split("|");
                String[] posisi=pesan.split("\\|");
                int x=Integer.parseInt(posisi[0]);
                int y=Integer.parseInt(posisi[1]);
                Robot rb=new Robot();
                rb.mouseMove(x, y);
                rb.delay(5);
                rb.mousePress(MouseEvent.BUTTON1_MASK);
                rb.mouseRelease(MouseEvent.BUTTON1_MASK);
            }
        } catch (Exception e) {
        }
    }
    
}
