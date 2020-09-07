package com.company;

import java.util.Stack;

public class SolutionJZ20 {
    Stack<Integer> normal=new Stack<>();
    Stack<Integer> minval=new Stack<>();

    public void push(int node) {
        if(normal.empty()){
            normal.push(node);
            minval.push(node);
        }
        else{
            normal.push(node);
            if(minval.peek()>node)
                minval.push(node);
            else
                minval.push(minval.peek());
        }
    }

    public void pop() {
        normal.pop();
        minval.pop();
    }

    public int top() {
        return normal.peek();
    }

    public int min() {
        return minval.peek();
    }
}

