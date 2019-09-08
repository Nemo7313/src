package com.fastjsonDemo.lib;

import java.util.List;

public class Student {
    private String name="";
    private int age = 18;
    private List<String> Skills;

    public Student(String name, int age, List<String> skills) {
        this.name = name;
        this.age = age;
        Skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getSkills() {
        return Skills;
    }

    public void setSkills(List<String> skills) {
        Skills = skills;
    }
}
