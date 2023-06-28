package com.luckk.lizzie;

import org.apache.naming.TransactionRef;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author liukun.inspire
 * @Date 2023/3/25 20:06
 * @PackageName: com.luckk.lizzie
 * @ClassName: Main3
 * @Version 1.0
 */
public class Main3 {

    public void flatten(TreeNode root) {
        doFlatten(root);
    }

    private  void doFlatten(TreeNode root){
        if (root == null) return ;

        doFlatten(root.left);
        doFlatten(root.right);
        TreeNode tmp  = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode nowTmp = root;
        while (nowTmp.right != null){
            nowTmp = nowTmp.right;
        }
        nowTmp.right = tmp;
    }


}
