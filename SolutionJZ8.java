package com.company;

public class SolutionJZ8 {
    public int JumpFloor(int target) {
        if(target==1||target==0)
            return target;
        return JumpFloor(target-1)+JumpFloor(target-2);

    }
}
