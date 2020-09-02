package com.company;

public class SolutionJZ1 {
    //方法一：暴力求解方法
    public static boolean Find(int target, int [][] array) {
        boolean tf=false;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                if(target<array[i][j])
                    break;
                else if(target==array[i][j])
                    tf=true;
                else
                    continue;
            }
        }
        return tf;
    }

    //方法二：选取第一个元素时为右上角(向左递减，向下递增），或左下角（向右递增，向上递增）
    public static boolean Find2(int target, int [][] array) {
        int col=array.length-1;
        int row=0;
        while(col>=0&&row<=array[0].length-1){
            if(array[col][row]>target)
                col--;
            else if(array[col][row]<target)
                row++;
            else
                return true;
        }
        return false;
    }
}
