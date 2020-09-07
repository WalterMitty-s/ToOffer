package com.company;

public class SolutionJZ18 {
    public void Mirror(TreeNode root) {
        TreeNode temp=null;
        if(root!=null){
            temp=root.left;
            root.left=root.right;
            root.right=temp;
            Mirror(root.left);
            Mirror(root.right);
        }
    }
}

