package com.socket3_clients;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

//线程类，接受客户请求，给与客户一个响应
//线程构造方法中去绑定客户端的Socket
public class LoginThread extends Thread{
    private Socket socket;
    public LoginThread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try {
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            User user = (User)ois.readObject();
            System.out.println("客户端说："+user.getUserName()+" - "+user.getPwd());

            //获得客户端的IP
            InetAddress ia = socket.getInetAddress();
            String IP = ia.getHostAddress();
            System.out.println("响应客户端的IP为："+IP);

            String reply = "欢迎登陆！";
            OutputStream os = socket.getOutputStream();
            os.write(reply.getBytes());

            ois.close();
            is.close();
            os.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
