package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SolutionJZ60 {
    /*
    BFS的模板为：
    1.如果不需要确定当前遍历到了哪一层，模板如下：
    void bfs() {
        vis[] = {0}; // or set
        queue<int> pq(start_val);

        while (!pq.empty()) {
            int cur = pq.front(); pq.pop();
            for (遍历cur所有的相邻节点nex) {
                if (nex节点有效 && vis[nex]==0){
                    vis[nex] = 1;
                    pq.push(nex)
                }
            } // end for
        } // end while
    }
    2.如果需要确定遍历到哪一层，模板如下：
    void bfs() {
        int level = 0;
        vis[] = {0}; // or set
        queue<int> pq(original_val);
        while (!pq.empty()) {
            int sz = pq.size();

            while (sz--) {
                int cur = pq.front(); pq.pop();
                for (遍历cur所有的相邻节点nex) {
                    if (nex节点有效 && vis[nex] == 0) {
                        vis[nex] = 1;
                        pq.push(nex)
                    }
                } // end for
            } // end inner while
            level++;

        } // end outer while
    }
    */
    /*
    使用队列进行层序遍历
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        TreeNode head=pRoot;
        Queue<TreeNode> queue=new LinkedList<>();
        ArrayList<ArrayList<Integer>> result=new ArrayList<>(); //保存结果
        if(head!=null)
            queue.add(head);
        while (!queue.isEmpty()){
            int sz= queue.size();                               //记录栈的深度：每一行元素个数
            ArrayList<Integer> temp=new ArrayList<>();          //保存每一行结果
            while(sz!=0){
                TreeNode node=queue.peek();
                queue.poll();
                temp.add(node.val);

                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
                sz--;
            }
            result.add(temp);

        }
        return result;
    }

}
