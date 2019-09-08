package com.io;

import java.io.*;

public class InputSreamReaderDemo {
    public static void main(String[] args) {
        Reader fr = null;
        FileInputStream fis =null;
        try {
            fis = new FileInputStream("c:/movie/text.txt");
            fr = new InputStreamReader(fis,"GBK");
            StringBuffer s = new StringBuffer();
            int len =-1;
            char[] ch = new char[1024];
            while((len=fr.read(ch))!=-1){
                s.append(ch);
            }
            System.out.println(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fr.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
