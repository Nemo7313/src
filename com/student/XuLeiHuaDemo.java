package com.student;

import java.io.*;

public class XuLeiHuaDemo {
    public static void main(String[] args) {
        Student stu = new Student("小雯",26,"女","1234567");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("c:/movie/newpic/student.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(stu);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
