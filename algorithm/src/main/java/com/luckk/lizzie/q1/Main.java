package com.luckk.lizzie.q1;

import com.luckk.lizzie.TreeNode;

import java.sql.PreparedStatement;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;


public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<int[]> increasedQueue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            addNewVal(increasedQueue, nums[i], i);
        }
        int[] result = new int[nums.length - k + 1];
        result[0] = increasedQueue.peekFirst()[0];
        for (int i = k; i < nums.length; i++) {
            while (!increasedQueue.isEmpty() && increasedQueue.peekFirst()[1] <= i - k) {
                // 减少
                increasedQueue.removeFirst();
            }
            addNewVal(increasedQueue, nums[i], i);
            result[i - k + 1] = increasedQueue.peekFirst()[0];
        }
        return result;
    }

    private void addNewVal(LinkedList<int[]> list, int val, int idx) {
        while (!list.isEmpty()) {
            if (list.peekLast()[0] < val) {
                list.removeLast();
            } else {
                break;
            }
        }
        list.add(new int[]{val, idx});
    }

}
