package com.socket2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//服务器
public class LoginServer {
    public static void main(String[] args) {
        try {
            //接收客户端请求
            ServerSocket serverSocket = new ServerSocket(5000);
            //accept()侦听并接收到此server Socket的连接
            Socket socket = serverSocket.accept();
            //获得输入流，获得用户请求
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            User user = (User)ois.readObject();
            System.out.println("客户端说："+user.getUserName()+user.getPwd());

            //给客户端一个响应
            String reply = "欢迎登陆！";
            OutputStream os = socket.getOutputStream();
            os.write(reply.getBytes());

            //释放响应资源
            ois.close();
            is.close();
            os.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
