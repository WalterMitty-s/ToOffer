package com.company;

import com.sun.xml.internal.txw2.output.IndentingXMLFilter;

import java.util.*;


public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution46 solution46=new Solution46();
        int m=solution46.LastRemaining_Solution(0,0);
        System.out.println("return value is: "+m);
    }
}

class SolutionJZ1 {
    //方法一：暴力求解方法
    public static boolean Find(int target, int [][] array) {
        boolean tf=false;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                if(target<array[i][j])
                    break;
                else if(target==array[i][j])
                    tf=true;
                else
                    continue;
            }
        }
        return tf;
    }

    //方法二：选取第一个元素时为右上角(向左递减，向下递增），或左下角（向右递增，向上递增）
    public static boolean Find2(int target, int [][] array) {
        int col=array.length-1;
        int row=0;
        while(col>=0&&row<=array[0].length-1){
            if(array[col][row]>target)
                col--;
            else if(array[col][row]<target)
                row++;
            else
                return true;
        }
        return false;
    }
}

class Solution2 {
    //方法一：使用库函数
    public String replaceSpace(StringBuffer str) {
        String result=str.toString().replace(" ","20%");

        return result;
    }
    //方法二：使用数组
    /*
        1.由后往前遍历记录空格总数
        2.依次替换空格
     */
    public String replaceSpace2(StringBuffer str) {
        int isr=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ')
                isr++;
        }
        int oldLength=str.length();
        int oldIndex=str.length()-1;
        int newLength=str.length()+2*isr;
        int newIndex=newLength-1;
        str.setLength(newLength);
        for(;oldIndex>=0&&oldLength<newLength;oldIndex--){
            if(str.charAt(oldIndex)!=' ')
                str.setCharAt(newIndex--,str.charAt(oldIndex));
            else{
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
            }
        }

        return str.toString();
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}



class SolutionJZ3 {
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

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class SolutionJZ4 {
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

class SolutionJZ5 {
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
class SolutionJZ6 {
    public int minNumberInRotateArray(int [] array) {
        int head=0,tail=array.length-1;
        int mid=head;
        while(array[head]>=array[tail]){
            if(tail-head==1){
                mid=tail;
                break;
            }
            mid=(head+tail)/2;
            if(array[mid]==array[head]&&array[mid]==array[tail])
                return order(array,head,tail);
            if(array[mid]>=array[head])
                head=mid;
            else{
                tail=mid;
            }
        }
        return array[mid];
    }

    int order(int[] array,int head,int tail){
        int result=array[head];
        for(int m=head+1;m<=tail;m++){
            if(array[m]<result)
                result=array[m];
        }
        return result;
    }
}

class SolutionJZ7 {
    public int Fibonacci(int n) {
        if(n==0||n==1)
            return n;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
    //简洁实现
    public int Fibonacci2(int n) {
        if(n==0||n==1)
            return n;
        int sum=1,num=0;
        for(int i=2;i<n;i++){
            sum=sum+num;
            num=sum-num;
        }
        return sum;
    }

}

class SolutionJZ8 {
    public int JumpFloor(int target) {
        if(target==1||target==0)
            return target;
        return JumpFloor(target-1)+JumpFloor(target-2);

    }
}

class SolutionJZ11 {
    //方法一：
    public int NumberOf1(int n) {
        int num=0;
        while(n!=0){
            num++;
            n=n&(n-1);
        }
        return num;
    }

    //方法二：
    public int NumberOf2(int n) {
        int num=0;
        String nstring=Integer.toBinaryString(n);
        String[] strings=nstring.split("");
        for(int i=0;i<strings.length;i++){
            if(strings[i].equals("1"))
                num++;
        }
        return num;
    }
}
class SolutionJZ12 {
    /**
     * 暴力解法
     * @param base
     * @param exponent
     * @return result
     */
    public double Power(double base, int exponent) {
        if(exponent<0){
            base=1/base;
            exponent=-exponent;
        }
        double result=1.0;
        for(int i=0;i<exponent;i++){
            result=base*result;
        }
        return result;
    }

}

class SolutionJZ13 {
    /**
     *
     * @param array
     */
    public void reOrderArray(int [] array) {
        int[] result=new int[array.length];
        for(int i=0;i<array.length;i++){
            result[i]=array[i];
        }
        int m=0;
        for(int i=0;i<array.length;i++){
            if(result[i]%2!=0)
                array[m++]=result[i];
        }
        for(int i=0;i<array.length;i++){
            if(result[i]%2==0)
                array[m++]=result[i];
        }
    }
}

/*class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

class SolutionJZ14 {
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

class SolutionJZ15 {
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

class SolutionJZ16 {
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

class SolutionJZ18 {
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

class SolutionJZ19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return arrayList;
        //定义四个值up,down,left,right
        int up,down,left,right;
        up=0;
        down=matrix.length-1;
        left=0;
        right=matrix[0].length-1;
        while(true){
            //最上面一行
            for(int col=left;col<=right;col++){
                arrayList.add(matrix[up][col]);
            }
            //向下逼近
            up++;
            if(up>down)
                break;
            //最右面一行
            for(int row=up;row<=down;row++){
                arrayList.add(matrix[row][right]);
            }
            //向左逼近
            right--;
            if(left>right)
                break;
            //最下面一行
            for(int col=right;col>=left;col--){
                arrayList.add(matrix[down][col]);
            }
            //向上逼近
            down--;
            if(up>down)
                break;
            for(int row=down;row>=up;row--){
                arrayList.add(matrix[row][left]);
            }
            //向右逼近
            left++;
            if(left>right)
                break;
        }
        return arrayList;
    }
}

class SolutionJZ20 {
    Stack<Integer> normal=new Stack<>();
    Stack<Integer> minval=new Stack<>();

    public void push(int node) {
        if(normal.empty()){
            normal.push(node);
            minval.push(node);
        }
        else{
            normal.push(node);
            if(minval.peek()>node)
                minval.push(node);
            else
                minval.push(minval.peek());
        }
    }

    public void pop() {
        normal.pop();
        minval.pop();
    }

    public int top() {
        return normal.peek();
    }

    public int min() {
        return minval.peek();
    }
}

class SolutionJZ21 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack=new Stack<>();
        int i=0,j=0;
        while(i<pushA.length){
            if(pushA[i]!=popA[j]){
                stack.push(pushA[i++]);
            }
            else {
                ++i;
                ++j;
                while(!stack.empty()&&stack.peek()==popA[j]){
                    stack.pop();
                    ++j;
                }
            }
        }
        return stack.empty();
    }
}
class SolutionJZ22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>() ;
        ArrayList<Integer> arrayList=new ArrayList<>();
        if(root==null)
            return arrayList;
        TreeNode p=root;
        queue.offer(root);
        while(!queue.isEmpty()){
            p=queue.poll();
            arrayList.add(p.val);
            if(p.left!=null)
                queue.offer(p.left);
            if(p.right!=null)
                queue.offer(p.right);
        }
        return arrayList;
    }
}

class SolutionJZ23 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int len = sequence.length;
        if(len==0) return false;
        int root = sequence[len-1];
        int i=0;
        for(;i<len-1;i++){
            if(sequence[i]>root) break;
        }
        int j=i;
        for(;j<len-1;j++){
            if(sequence[j]<root) return false;
        }
        boolean left=true,right=true;
        if(i>0) left=VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,i));
        if(i<len-1)  right=VerifySquenceOfBST(Arrays.copyOfRange(sequence,i,len-1));
        return left && right;
    }
}

class SolutionJZ24 {
    private ArrayList<ArrayList<Integer>> result=new ArrayList<>();
    private ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root==null)
            return result;
        path.add(root.val);
        target=target-root.val;
        if(target==0&&root.left==null&&root.right==null)
            result.add(new ArrayList<Integer>(path));
        //因为在每一次的递归中，我们使用的是相同的result引用
        FindPath(root.left,target);
        FindPath(root.right,target);
        path.remove(path.size()-1);
        return result;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

class SolutionJZ25 {
    public RandomListNode Clone(RandomListNode pHead) {
        cloneNodes(pHead);
        connectSibling(pHead);
        return reconnectNode(pHead);
    }

    //将每个结点进行复制，并进行连接
    void cloneNodes(RandomListNode pHead){
        RandomListNode pNode=pHead;
        while (pNode!=null){
            RandomListNode pCloned=new RandomListNode(pNode.label);
            pCloned.label=pNode.label;
            pCloned.next=pNode.next;
            pCloned.random=null;

            pNode.next=pCloned;

            pNode=pCloned.next;
        }

    }
    //进行随机结点的拷贝，利用cloneNodes的链表
    void connectSibling(RandomListNode pHead){
        RandomListNode pNode=pHead;
        while(pNode!=null){
            RandomListNode pCloned=pNode.next;
            if(pNode.random!=null){
                pCloned.random=pNode.random.next;
            }
            pNode=pCloned.next;
        }
    }
    //将connectSibling的链表进行分离，奇数位置结点和偶数位置结点
    RandomListNode reconnectNode(RandomListNode pHead){
        RandomListNode pNode=pHead;//需进行分离的链表
        RandomListNode pClonedHead=null;//复制链表的头节点
        RandomListNode pClonedNode=null;//复制链表的临时结点（可以看作尾结点，进行尾插法）

        if(pNode!=null){
            pClonedHead=pClonedNode=pNode.next;
            pNode.next=pClonedNode.next;
            pNode=pNode.next;
        }

        while (pNode!=null){
            pClonedNode.next=pNode.next;
            pClonedNode=pClonedNode.next;
            pNode.next=pClonedNode.next;
            pNode=pNode.next;
        }
        return pClonedHead;
    }
}

class SolutionJZ26 {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        addList(pRootOfTree, list);
        return changeList(list);

    }
    //中序遍历，在list中按遍历顺序保存
    public void addList(TreeNode pRootOfTree, ArrayList<TreeNode> list){
        if(pRootOfTree.left != null){
            addList(pRootOfTree.left, list);
        }

        list.add(pRootOfTree);

        if(pRootOfTree.right != null){
            addList(pRootOfTree.right, list);
        }
    }
    //遍历list，修改指针
    public TreeNode changeList(ArrayList<TreeNode> list){
        for(int i = 0; i < list.size() - 1; i++){
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }
        return list.get(0);
    }

}

class SolutionJZ28 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int[] temp=new int[array.length];
        int i;
        for(i=0;i<temp.length;i++){
            temp[i]=0;
        }
        for(i=0;i<array.length;i++){
            temp[array[i]]++;
        }
        for(i=0;i<temp.length;i++){
            if(temp[i]>(array.length/2)){
                return i;
            }
        }
        return 0;

    }
}

/**
 * 未完成
 */
class SolutionJZ32 {
    public String PrintMinNumber(int [] numbers) {
        int length=numbers.length;
        String[] string=new String[length];
        int i;
        for(i=0;i<string.length;i++){
            string[i]=Integer.toString(numbers[i]);
        }
        Arrays.sort(string);
        String s=new String();
        for(i=string.length-1;i>=0;i--)
            s=s+string[i];
        return s;
    }
}
class SolutionJZ36 {
    /*
    暴力求解方法
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode h1=pHead1,h2=pHead2;
        while(h1!=null){
            while (h2!=null){
                if(h2==h1)
                    return h1;
                h2=h2.next;
            }
            h2=pHead2;
            h1=h1.next;
        }
        return null;
    }
    /*
    双指针法：可以看作将两个链表拼接起来,长度都为a+b
    leetcode160
     */
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode h1=pHead1,h2=pHead2;
        while(h1!=h2){
            h1=h1!=null?h1.next:pHead2;
            h2=h2!=null?h2.next:pHead1;
        }
        return h1;
    }
}
class SolutionJZ38 {
    public int TreeDepth(TreeNode root) {
        if(root==null)
            return 0;
        return (TreeDepth(root.left)>TreeDepth(root.right)?TreeDepth(root.left):TreeDepth(root.right))+1;

    }

}
class Solution46 {
    /**
     * 模拟法
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        int index=-1;
        for(int i=0;i<n;i++){
            arrayList.add(i);
        }
        if(arrayList.isEmpty())
            return -1;
        while (arrayList.size()!=1){
            for(int i=0;i<m;i++){
                index=index+1;
                if(index==arrayList.size())
                    index=0;
            }
            arrayList.remove(index);
            index=index-1;
        }
        return arrayList.get(0);
    }
}
class SolutionJZ47 {
    /*
    使用“递归”=for,“短路”=if
     */
    public int Sum_Solution(int n) {
        int sum=n;
        boolean t=(n>0)&&((sum+=Sum_Solution(n--))>0);
        return sum;
    }

}
class SolutionJZ48 {
    public int Add(int num1, int num2) {
        int sum, carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        while (num2 != 0);
        return sum;
    }
}
class Solution50 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    // 返回任意重复的一个值，赋值duplication[0]，这是题目要求
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (numbers[j] == numbers[i]) {
                    duplication[0] = numbers[i];
                    return true;
                }
            }
        }
        return false;
    }

}

class SolutionJZ51 {
    /*
    方法：
    暴力求解
     */
    public int[] multiply(int[] A) {
        int len=A.length;
        int[] b=new int[len];
        int i;
        for(i=0;i<len;i++){
            b[i]=1;
        }
        for(i=1;i<len;i++){
            b[0]=b[0]*A[i];
        }

        for(i=0;i<len-1;i++){
            b[len-1]=b[len-1]*A[i];
        }

        for(i=1;i<len-1;i++){
            for(int j=0;j<len;j++){
                if(j==i)
                    continue;
                b[i]=b[i]*A[j];
            }
        }
        return b;
    }
    /*
    方法：把数组B看成一个矩阵来创建
     */

}
class SolutionJZ55 {

        public ListNode EntryNodeOfLoop(ListNode pHead) {
            ListNode fast=pHead,slow=pHead;
            while((fast!=null)&&(fast.next!=null)){
                fast=fast.next.next;
                slow=slow.next;
                if(fast==slow)
                    break;
            }
            if(fast==null||fast.next==null)
                return null;
            fast=pHead;
            while(fast!=slow){
                fast=fast.next;
                slow=slow.next;
            }
            return fast;
        }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
class SolutionJZ56 {
    public ListNode deleteDuplication(ListNode pHead) {

    }
}
class SolutionJZ57 {
    /*
    根据中序遍历的规则，当结点存在右子树的时候，中序遍历的下一个结点为右子树的最左节点。
    但是当节点不存在右子树的时候，中序遍历的下一个结点必定为该节点的父辈节点。但是究竟是
    哪一辈呢？根据中序遍历特性，左父结点一定已经被中序遍历访问过，所以下一个结点一定是在
    父节点路径上的第一个右父节点。
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode == null) return null;

        if(pNode.right != null){
            pNode = pNode.right;
            while(pNode.left != null);
                pNode = pNode.left;
            return pNode;
        }

        while(pNode.next != null){
            if(pNode.next.left == pNode)
                return pNode.next;
            pNode = pNode.next;
        }
        return null;
    }
}
class Solution59 {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        TreeNode head=pRoot;
        int level=0;
        Queue<TreeNode> q=new LinkedList<>();
        if(head!=null)
            q.add(head);
        while(!q.isEmpty()){
            int sz=q.size();
            TreeNode treeNode;
            ArrayList<Integer> temp=new ArrayList<>();
            while(sz!=0){
                treeNode=q.peek();
                q.poll();
                temp.add(treeNode.val);

                if(treeNode.left!=null)
                    q.add(treeNode.left);
                if(treeNode.right!=null)
                    q.add(treeNode.right);
                sz--;
            }
            if(level%2!=0)
                Collections.reverse(temp);
            result.add(temp);
            level++;
        }
        return result;
    }

}
class SolutionJZ60 {
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
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
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