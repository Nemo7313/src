package com.io;

import java.io.*;

public class CopyPic {
    public static void main(String[] args) {
        DataInputStream dis = null;
        FileInputStream fis = null;

        DataOutputStream dos = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("c:/movie/timg.bmp");
            dis = new DataInputStream(fis);

            fos = new FileOutputStream("c:/movie/newpic/newTimg.bmp");
            dos = new DataOutputStream(fos);

            int temp;
            while((temp=dis.read())!=-1){
                dos.write(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                dos.close();
                fos.close();
                dis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
