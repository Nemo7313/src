package com.socket_udp;

import java.io.IOException;
import java.net.*;

public class LoginClient {
    public static void main(String[] args) {
        String info = "心形巧克力";
        byte[] infos = info.getBytes();
        InetAddress ia = null;
        DatagramSocket socket = null;
        try {
            ia = InetAddress.getByName("localhost");
            DatagramPacket dp = new DatagramPacket(infos,infos.length,ia,5000);
            socket = new DatagramSocket();
            socket.send(dp);

            byte[] replies = new byte[1024];
            DatagramPacket dp1 = new DatagramPacket(replies, replies.length);
            socket.receive(dp1);
            String reply = new String(dp1.getData(),0,dp1.getData().length);
            System.out.println("服务器的响应："+reply);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            socket.close();
        }



    }
}
