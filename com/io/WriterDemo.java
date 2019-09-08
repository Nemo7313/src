package com.io;

import java.io.FileWriter;
import java.io.IOException;

public class WriterDemo {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("c:/movie/我的青春谁做主.txt",true);
            String info = "输入和输出最后一部分内容";
            fw.write(info);
            fw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
