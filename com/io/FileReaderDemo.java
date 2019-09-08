package com.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            System.out.println(System.getProperty("file.encoding"));
            fr = new FileReader("c:/movie/text1.txt");
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
