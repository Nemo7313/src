package com.io;

import java.io.*;

public class BufferedWriterDemo {
    public static void main(String[] args) {
        FileWriter fw = null;
        BufferedWriter bw =null;
        Reader reader = null;
        BufferedReader br = null;
        try {
            fw = new FileWriter("c:/movie/我的青春谁做主.txt",true);
            bw = new BufferedWriter(fw);
            bw.write("一代人终将老去");
            bw.newLine();
            bw.write("总有人正年轻");
            bw.newLine();
            bw.write("写入完毕！");
            bw.flush();

            reader = new FileReader("c:/movie/我的青春谁做主.txt");
            br = new BufferedReader(reader);
            String line = null;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
