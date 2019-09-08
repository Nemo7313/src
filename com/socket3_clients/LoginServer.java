package com.socket3_clients;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务器
public class LoginServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            while(true) {
                Socket socket = serverSocket.accept();
                //创建一个和该客户端响应的线程
                LoginThread loginThread = new LoginThread(socket);
                loginThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
