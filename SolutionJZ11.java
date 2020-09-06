package com.company;

public class SolutionJZ11 {
    //方法一：
    public int NumberOf1(int n) {
        int num=0;
        while(n!=0){
            num++;
            n=n&(n-1);
        }
        return num;
    }

    //方法二：
    public int NumberOf2(int n) {
        int num=0;
        String nstring=Integer.toBinaryString(n);
        String[] strings=nstring.split("");
        for(int i=0;i<strings.length;i++){
            if(strings[i].equals("1"))
                num++;
        }
        return num;
    }
}
