package com.student;

import java.io.*;

public class FanXuLieHuaDemo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("c:/movie/newpic/student.txt");
            ois = new ObjectInputStream(fis);
            Student stu2 =(Student)ois.readObject();
            System.out.println("反序列化会的信息: "+stu2.getName()+stu2.getAge()+stu2.getGender()+stu2.getPassword());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
