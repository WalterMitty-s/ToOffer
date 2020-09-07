package com.company;

import java.util.ArrayList;

public class SolutionJZ19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return arrayList;
        //定义四个值up,down,left,right
        int up,down,left,right;
        up=0;
        down=matrix.length-1;
        left=0;
        right=matrix[0].length-1;
        while(true){
            //最上面一行
            for(int col=left;col<=right;col++){
                arrayList.add(matrix[up][col]);
            }
            //向下逼近
            up++;
            if(up>down)
                break;
            //最右面一行
            for(int row=up;row<=down;row++){
                arrayList.add(matrix[row][right]);
            }
            //向左逼近
            right--;
            if(left>right)
                break;
            //最下面一行
            for(int col=right;col>=left;col--){
                arrayList.add(matrix[down][col]);
            }
            //向上逼近
            down--;
            if(up>down)
                break;
            for(int row=down;row>=up;row--){
                arrayList.add(matrix[row][left]);
            }
            //向右逼近
            left++;
            if(left>right)
                break;
        }
        return arrayList;
    }
}

