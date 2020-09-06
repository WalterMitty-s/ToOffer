package com.company;

public class SolutionJZ12 {
    /**
     * 暴力解法
     * @param base
     * @param exponent
     * @return result
     */
    public double Power(double base, int exponent) {
        if(exponent<0){
            base=1/base;
            exponent=-exponent;
        }
        double result=1.0;
        for(int i=0;i<exponent;i++){
            result=base*result;
        }
        return result;
    }

}
