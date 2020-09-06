package com.company;

public class SolutionJZ14 {
    /**
     * 快慢指针，只需要遍历一次链表
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k==0)
            return null;
        ListNode p=head;
        ListNode q=null;
        for(int i=0;i<k-1;i++){
            if(p.next!=null){
                p=p.next;
            }
            else {
                return null;
            }
        }
        q=head;
        while(p.next!=null){
            p=p.next;
            q=q.next;
        }
        return q;
    }
}

