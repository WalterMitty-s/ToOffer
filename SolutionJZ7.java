package com.company;

public class SolutionJZ7 {
    public int Fibonacci(int n) {
        if(n==0||n==1)
            return n;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
    //简洁实现
    public int Fibonacci2(int n) {
        if(n==0||n==1)
            return n;
        int sum=1,num=0;
        for(int i=2;i<n;i++){
            sum=sum+num;
            num=sum-num;
        }
        return sum;
    }

}
