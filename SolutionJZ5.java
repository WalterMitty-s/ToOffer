package com.company;

import java.util.Stack;

public class SolutionJZ5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int num=0;
        if(!stack2.empty()){
            num=stack2.peek();
            stack2.pop();
        }
        else {
            if(!stack1.empty()){
                while(!stack1.empty()){
                    stack2.push(stack1.peek());
                    stack1.pop();
                }
                num=stack2.peek();
                stack2.pop();
            }
        }
        return num;
    }
}
