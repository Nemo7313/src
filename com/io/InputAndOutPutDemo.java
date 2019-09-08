package com.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputAndOutPutDemo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("c:/movie/我的青春谁做主.txt");
            fos = new FileOutputStream("c:/study/hello.txt",true);
            byte[] words = new byte[256];
            int len = -1;
            while((len=fis.read(words))!=-1){
                fos.write(words, 0, len);
            }
            System.out.println("文件已复制");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
