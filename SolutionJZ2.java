package com.company;

public class SolutionJZ2 {
    //方法一：使用库函数
    public String replaceSpace(StringBuffer str) {
        String result=str.toString().replace(" ","20%");

        return result;
    }
    //方法二：使用数组
    /*
        1.由后往前遍历记录空格总数
        2.依次替换空格
     */
    public String replaceSpace2(StringBuffer str) {
        int isr=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ')
                isr++;
        }
        int oldLength=str.length();
        int oldIndex=str.length()-1;
        int newLength=str.length()+2*isr;
        int newIndex=newLength-1;
        str.setLength(newLength);
        for(;oldIndex>=0&&oldLength<newLength;oldIndex--){
            if(str.charAt(oldIndex)!=' ')
                str.setCharAt(newIndex--,str.charAt(oldIndex));
            else{
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
            }
        }

        return str.toString();
    }
}
