package com.company;

public class SolutionJZ6 {
    public int minNumberInRotateArray(int [] array) {
        int head=0,tail=array.length-1;
        int mid=head;
        while(array[head]>=array[tail]){
            if(tail-head==1){
                mid=tail;
                break;
            }
            mid=(head+tail)/2;
            if(array[mid]==array[head]&&array[mid]==array[tail])
                return order(array,head,tail);
            if(array[mid]>=array[head])
                head=mid;
            else{
                tail=mid;
            }
        }
        return array[mid];
    }

    int order(int[] array,int head,int tail){
        int result=array[head];
        for(int m=head+1;m<=tail;m++){
            if(array[m]<result)
                result=array[m];
        }
        return result;
    }
}
