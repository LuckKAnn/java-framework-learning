package com.luckk.lizzie.q1;

import java.util.List;

/**
 * @Author liukun.inspire
 * @Date 2023/3/26 20:08
 * @PackageName: com.luckk.lizzie.q1
 * @ClassName: Solution
 * @Version 1.0
 */
class ListNode{
    int val;
    ListNode next = null;
}
public class Solution {

    ListNode realHead ;
    public ListNode reorderList (ListNode head) {
        // write code here
        // ListNode hair = new ListNode();
        // hair.next = head;
        ListNode pre = null;
        ListNode tmp = head;
        realHead = head;

        while (tmp!=null){
            ListNode lastHead = tmp;
            ListNode firstNext = lastHead.next;

            ListNode secondHead = null;
            if (firstNext!=null){
                secondHead = firstNext.next;
            }
            ListNode next = doProcess(lastHead, secondHead, pre);
            tmp = next;
            pre = firstNext;
        }

        return realHead;
    }

    public ListNode doProcess(ListNode lastHead,ListNode nextHead,ListNode pre){
        if (nextHead == null){
            return  null;
        }
        ListNode firstEnd = lastHead.next;
        ListNode secondEnd  = nextHead.next;
        ListNode next = null;
        if (secondEnd != null){
            next = secondEnd.next;
        }
        if (pre == null){
            realHead = nextHead;
        } else{
            pre.next = nextHead;
        }
        if (secondEnd!=null){
            secondEnd.next = lastHead;
        } else {
            nextHead.next = lastHead;
        }
        firstEnd.next = next;
        return next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
