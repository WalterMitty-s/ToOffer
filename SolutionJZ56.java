package com.company;

public class SolutionJZ56 {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead==null || pHead.next==null){
            return pHead;
        }
        ListNode h=new ListNode(-1);
        h.next=pHead;
        ListNode h1=h;
        ListNode h2=h.next;
        while(h2!=null){
            if(h2.next!=null&&h2.val==h2.next.val){
                while(h2.next!=null&&h2.val==h2.next.val){
                    h2=h2.next;
                }
                h2=h2.next;
                h1.next=h2;
            }
            else {
                h1=h2;
                h2=h2.next;

            }
        }
        return h.next;
    }
}
