package com.io;

import java.io.*;
import java.io.BufferedReader;

public class BufferedReaderDemo {
    public static void main(String[] args) {
        Reader fr = null;
        BufferedReader br =null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("c:/movie/text.txt");
            fr = new InputStreamReader(fis,"GBK");
            br = new BufferedReader(fr);
            String line = null;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
                fr.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
