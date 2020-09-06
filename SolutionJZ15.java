package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionJZ15 {
    public ListNode ReverseList(ListNode head) {
        ListNode p=head;
        Queue<ListNode> queue=new LinkedList<>();
        while(p!=null){
            queue.add(p);
            p=p.next;
        }
        p=null;
        while (!queue.isEmpty()){
            queue.peek().next=p;
            p=queue.peek();
            queue.poll();

        }
        return p;
    }
}
