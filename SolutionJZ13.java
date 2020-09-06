package com.company;

public class SolutionJZ13 {
    /**
     *
     * @param array
     */
    public void reOrderArray(int [] array) {
        int[] result=new int[array.length];
        for(int i=0;i<array.length;i++){
            result[i]=array[i];
        }
        int m=0;
        for(int i=0;i<array.length;i++){
            if(result[i]%2!=0)
                array[m++]=result[i];
        }
        for(int i=0;i<array.length;i++){
            if(result[i]%2==0)
                array[m++]=result[i];
        }
    }
}

