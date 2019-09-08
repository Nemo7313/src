package com.cn.mylist;

public class MyList {
    private int size = 0;
    private Object[] elements = new Object[256];

    private void checkCapcity(){
        //检测容量，满则增倍，少于1/4则减半
        int elecount = this.elements.length;
        if(this.size == elecount){
            rebuid(elecount *2);
        }

        //检测是否空闲超过少于3/4
        if(this.size == elecount/4 && elecount>16){
            rebuid(elecount/2);
        }
    }

    private void rebuid(int n){
        Object[] t = new Object[n];
        for(int i=0; i<this.size; i++){
            t[i] = this.elements[i];
        }
        this.elements = t;
    }

}
