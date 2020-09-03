package com.company;

public class SolutionJZ58 {

    /*
    递归
    三种情况：
    1.都为空：return true
    2.一个为空或val不等：return false
    3.进行递归
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null)
            return true;
        return  check(pRoot.left,pRoot.right);
    }
    boolean check(TreeNode one,TreeNode two){
        if(one==null&&two==null){
            return true;
        }
        else if((one!=null)&&(two==null)||(one==null&&two!=null)||(one.val!=two.val)){
            return false;
        }
        else {
            return check(one.left,two.right)&&check(one.right,two.left);
        }
    }
}

/*
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

*/
