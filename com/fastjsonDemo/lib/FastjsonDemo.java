package com.fastjsonDemo.lib;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class FastjsonDemo {
    public static void main(String[] args) {
        Student student = new Student("Nemo",18, Arrays.asList("Hadoop","Java","Python"));
        //System.out.println(Object2JSON(student));
        String jsonStr = "{\"skills\":[\"Hadoop\",\"Java\",\"Python\"],\"name\":\"Nemo\",\"age\":18}";
        Student stu = JSON2Object(jsonStr);
        System.out.println(stu.getName());
    }

    public static String Object2JSON(Student stu){
        return JSON.toJSON(stu).toString();
    }

    public static Student JSON2Object(String jsonStr){
        return JSON.parseObject(jsonStr,Student.class);
    }
}
