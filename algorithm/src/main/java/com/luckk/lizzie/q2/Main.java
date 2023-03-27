package com.luckk.lizzie.q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author liukun.inspire
 * @Date 2023/3/26 16:37
 * @PackageName: com.luckk.lizzie.q2
 * @ClassName: Main
 * @Version 1.0
 */
public class Main {

    static int min = 0;
    static boolean[] visit;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int []A = new int[N];
        int []B = new int[N];
        visit = new boolean[N+1];
        List<Integer> zero = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = scanner.nextInt();
            if (B[i] == 0) zero.add(i);
            else if (B[i]==1) one.add(i);
            else  two.add(i);
        }

        // 把数字分为了三分，那么N必要要能够
        // findFor(zero, A, 1, zero.size());
        // findFor(one,A,zero.size()+1,zero.size()+ one.size());
        // findFor(two, A,zero.size()+one.size()+1, N);

        caculate(zero, A, 1, zero.size());
        caculate(one,A,zero.size()+1,zero.size()+ one.size());
        caculate(two, A,zero.size()+one.size()+1, N);

        System.out.println(min);
    }

    public static void caculate(List<Integer> list,int [] A,int low,int high){
        int real = 0;
        for (int i = low; i <=high; i++) {
            real+=i;
        }
        int aSum = 0;
        for (int idx : list){
            aSum+=A[idx];
        }

        min+=Math.abs(real-aSum);
    }

    public static void findFor(List<Integer> list,int []A,int low,int high){
        int maxVal = list.size();
        for (int i = 0; i < maxVal; i++) {
            int idx = list.get(i);
            int val = findVal(high, low, A[idx]);
            min += Math.abs(A[idx]-val);
        }
    }

    public static int findVal(int high,int low, int target){
        int idx = 0;
        if (target>= high){
            // 从顶往下找一个
            idx = high;
            while (visit[idx]){
                idx--;
            }
            visit[idx] = true;
            return idx;
        } else if (target<= low){
            // 从底部开始找
            idx = low;
            while (visit[idx]){
                idx++;
            }
            visit[idx] = true;
            return idx;
        } else{
            // 在中间，先找一样的数，不行再分别网上或者往下找
            idx = target;
            if (!visit[idx]){
                visit[idx] = true;
                return idx;
            }
            int idxLow = idx -1;
            int idxHigh = idx+1;
            while (visit[idxLow] && visit[idxHigh]){
                idxLow--;
                idxHigh++;
            }
            if (!visit[idxLow]) {
                visit[idxLow] = true;
                return idxLow;

            }
            if (!visit[idxHigh]){
                visit[idxHigh] = true;
                return idxHigh;
            }
        }

return -1;
    }

}
