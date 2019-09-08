package com.socket3_clients;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

//客户端
public class LoginClient {
    public static void main(String[] args) {
        try {
            //发送请求到服务器
            Socket socket = new Socket("localhost",5000);
            User user = new User("Nemo","123456");
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(user);

            //接收服务器的响应
            socket.shutdownOutput();
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String reply;
            while((reply=br.readLine())!=null){
                System.out.println(reply);
            }

            os.close();
            oos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
