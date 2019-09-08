package com.socket;

import java.io.*;
import java.net.Socket;

//客户端
public class LoginClient {
    public static void main(String[] args) {
        try {
            //发送请求到服务器
            Socket socket = new Socket("localhost",5000);
            String info = "用户名：Nemo，密码：123456";
            OutputStream os = socket.getOutputStream();
            byte[] infos = info.getBytes();
            os.write(infos);

            //接收服务器的响应
            socket.shutdownOutput();
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String reply;
            while((reply=br.readLine())!=null){
                System.out.println(reply);
            }

            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
