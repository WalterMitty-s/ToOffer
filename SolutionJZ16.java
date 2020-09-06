package com.company;

public class SolutionJZ16 {
    /**
     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }
     */
    class SolutionJZ17 {
        public boolean HasSubtree(TreeNode root1,TreeNode root2) {
            boolean result= false;
            if(root1!=null&&root2!=null){
                if(equalNum(root1.val,root2.val)){
                    result=doesEqual(root1,root2);
                }
                if(!result){
                    result=HasSubtree(root1.left,root2);
                }
                if(!result){
                    result=HasSubtree(root1.right,root2);
                }

            }
            return result;
        }
        boolean doesEqual(TreeNode root1,TreeNode root2){
            if(root2==null)
                return true;
            if(root1==null)
                return false;
            if(!equalNum(root1.val,root2.val)){
                return false;
            }

            return doesEqual(root1.left,root2.left)&&doesEqual(root1.right,root2.right);
        }
        boolean equalNum(int num1,int num2){
            if(num1==num2)
                return true;
            else
                return false;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode p=new ListNode(0);
        ListNode temp=p;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                temp.next=list1;
                list1=list1.next;
            }
            else {
                temp.next=list2;
                list2=list2.next;
            }
            temp=temp.next;
        }
        if(list1==null){
            temp.next=list2;
        }
        else{
            temp.next=list1;
        }
        p=p.next;
        return p;
    }

}

