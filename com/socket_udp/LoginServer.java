package com.socket_udp;

import java.io.IOException;
import java.net.*;

public class LoginServer {
    public static void main(String[] args) {
        byte[] infos = new byte[1024];
        DatagramPacket dp = new DatagramPacket(infos, infos.length);

        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(5000);
            ds.receive(dp);

            String info = new String(dp.getData(),0,dp.getData().length);
            System.out.println("客户端说："+info);

            String reply = "一件羽绒服";
            byte[] replies = reply.getBytes();
            SocketAddress sa = dp.getSocketAddress();
            DatagramPacket dp1 = new DatagramPacket(replies,replies.length,sa);
            ds.send(dp1);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            ds.close();
        }
    }
}
