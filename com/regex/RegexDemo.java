package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
//        Pattern pattern = Pattern.compile("h\\w+llo");
//        Matcher matcher = pattern.matcher("halllo");
        //全局匹配
//        if(matcher.matches()){
//            System.out.println(matcher.group());
//        }

        //部分查找匹配
//        Pattern pattern1 = Pattern.compile("h");
//        Matcher matcher1 = pattern1.matcher("h!alhloh");
//       while(matcher1.find()){
//           System.out.println(matcher1.group());
//       }

        //部分查找匹配
        Pattern pattern2 = Pattern.compile("ghj(k)ooi");
        Matcher matcher2 = pattern2.matcher("ghjkooi");
        while(matcher2.find()){
           System.out.println(matcher2.group(1));
        }

    }
}
