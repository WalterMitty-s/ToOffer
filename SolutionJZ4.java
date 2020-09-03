package com.company;

import java.util.Arrays;

public class SolutionJZ4 {
    //使用递归
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0||in.length==0)
            return null;
        TreeNode treeNode=new TreeNode(pre[0]);
        for(int i=0;i<in.length;i++){
            //Arrays.copyOfRange()左闭右开
            if(in[i]==pre[0]){
                treeNode.left=reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                treeNode.right=reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                break;
            }
        }
        return treeNode;
    }
}

