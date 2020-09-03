package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class SolutionJZ3 {
    //使用栈
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        while(!stack.empty()){
            arrayList.add(stack.peek());
            stack.pop();
        }
        return arrayList;
    }
}
