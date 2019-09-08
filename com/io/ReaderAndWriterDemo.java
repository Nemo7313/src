package com.io;

import java.io.*;

//将文件内容 读取、替换、写入另一个文件
public class ReaderAndWriterDemo {
    public static void main(String[] args) {
        BufferedReader reader = null;
        InputStreamReader ir = null;
        FileInputStream fis = null;
        FileWriter fw = null;
        BufferedWriter writer = null;

        try {
            fis = new FileInputStream("c:/movie/pet.template");
            ir = new InputStreamReader(fis,"utf-8");
            reader = new BufferedReader(ir);
            StringBuffer sbf = new StringBuffer();
            String line = null;
            while((line=reader.readLine())!=null){
                sbf.append(line);
            }

            System.out.println("替换前: "+sbf);
            String newStr = sbf.toString().replace("{name}","欧欧").replace("{type}","狗狗").replace("{master}","李伟");
            System.out.println("替换后: "+newStr);

            fw = new FileWriter("c:/movie/pet2.template");
            writer = new BufferedWriter(fw);
            writer.write(newStr);
            writer.flush();


        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
                ir.close();
                fis.close();
                writer.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
