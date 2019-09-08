package com.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStramDemo {
    public static void main(String[] args) {
        FileInputStream fis =null;
        try {
            fis = new FileInputStream("c:/movie/text.txt");
            System.out.println(fis.available());

//            int data;
//            while((data = fis.read())!=-1){
//                System.out.print((char)data+"\t");
//            }

            byte[] b = new byte[256];
            int data;
            while((data = fis.read(b))!=-1){
               for(int i=0; i<data; i++){
                   System.out.println((char)b[i]);
               }
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
