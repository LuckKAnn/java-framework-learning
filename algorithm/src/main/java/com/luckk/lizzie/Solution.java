package com.luckk.lizzie;

/**
 * @Author liukun.inspire
 * @Date 2023/3/23 19:03
 * @PackageName: com.luckk.lizzie
 * @ClassName: Solution
 * @Version 1.0
 */
import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }
}
public class Solution {


    int sum = 0;

    int halfSum = 0;
    List<Integer> c;

    List<TreeNode> jiList =  new ArrayList<>();

    List<TreeNode> ouList = new ArrayList<>();

    Set<Integer> set = new HashSet<>();

    int n ;
    public TreeNode fun (TreeNode root) {
        // write code here
        // 从n个数里面选择k个数，使得两部分的差值绝对值小于1

        bfs(root);
        int num = jiList.size()+ouList.size();
        n = num;
        findNum(ouList.size(),num);

        if (c == null  || c.size() ==0) return null;

        // 设置值
        int idx = 0;
        for (int i = 1; i <= num; i++) {
            if (!c.contains(i)){
                jiList.get(idx).val = i;
                idx++;
            }
        }
        idx = 0;
        for(TreeNode ou : ouList){
            ou.val = c.get(idx);
            idx++;
        }

        return root;
    }

    public  void bfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode poll = queue.poll();
                if ((depth&1)==0){
                    ouList.add(poll);
                }else{
                    jiList.add(poll);
                }
                if (poll.left!=null) queue.add(poll.left);
                if (poll.right!=null) queue.add(poll.right);
            }
            depth++;
        }
    }

    public void findNum(int k,int n){
        // 总共1-n
        // 10的五次方
        sum = ((1+n)*n)/2;
        halfSum = sum/2;
        dfs(new ArrayList<>(),0,n,k);
        // for (int i = n; i >= k; i--) {
        //     if (huadong(0,k,i-k+1,i,n)){
        //         c= new ArrayList<>();
        //         for (int j = i-k+1; j <= i; j++) {
        //             c.add(j);
        //         }
        //         return;
        //         // System.out.println((i-k)+""+i);
        //     }
        // }
    }


    public boolean huadong (int hua,int k,int start ,int end ,int n){


        // n个数，
        int preSum = ((1+(end)) * (end))/2;
        int preStartSum = ((1+(start-1)) * (start-1))/2;

        int tmpNow = preSum - preStartSum;
        int left = sum - tmpNow;
        if (Math.abs(tmpNow-left)<=1){
            return true;
        }
        return false;
    }
    public  void dfs(List<Integer> chose,int tmp,int idx,int left){

        if (set.contains(tmp)){
            return;
        }
        if (idx<(n)/2 ){
            return;
        }

        if (idx<0) {
            return;
        }
        if (c != null && c.size()!=0){
            return;
        }

        if (left == 0){
            if ((sum&1)==0){
                if (tmp == halfSum){
                    c=new ArrayList<>(chose);
                    return;
                }
            }else{
                if (tmp == halfSum || tmp==halfSum+1){
                    c=new ArrayList<>(chose);
                    return;
                }
            }
            return;
        }
        if (tmp > (halfSum+1)){
            return;
        }


        if(left>0){
            chose.add(idx);
            dfs(chose,tmp+idx,idx-1,left-1);
            chose.remove(chose.size()-1);
            dfs(chose,tmp,idx-1,left);
        }

    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        // boolean huadong = solution.huadong(0, 2, 5, 6, 6);
        // System.out.println(huadong);

        // solution.findNum(2,5);
        solution.findNum(2,6);
        // solution.findNum(10,1000);
        // solution.findNum(1,4);
        // System.out.println(solution.c.toString());

    }
}
