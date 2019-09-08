package com.io;

import java.io.File;
import java.io.IOException;


public class FileDemo {
    public void create(File file)  {
        if(!file.exists()){
            try {
                file.createNewFile();
                System.out.println("文件已创建！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void showFile(File file){
        if(file.exists()){
            if(file.isFile()){
                System.out.println("该文件名是"+file.getName());
                System.out.println("绝对路径"+file.getAbsolutePath());
                System.out.println("相对路径"+file.getPath());
                System.out.println("文件大小"+file.length()+"字节");
            }
            if(file.isDirectory()){
                System.out.println("此文件是目录");
            }
        }else{
            System.out.println("文件不存在！");
        }
    }

    public void deletefile(File file){
        if(file.exists()){
            file.delete();
            System.out.println("文件已经删除");
        }
    }


    public static void main(String[] args) {
        FileDemo filedemo = new FileDemo();
        File file = new File("c:/movie/text.txt");
        filedemo.create(file);
        //filedemo.showFile(file);
        //filedemo.deletefile(file);
    }
}
