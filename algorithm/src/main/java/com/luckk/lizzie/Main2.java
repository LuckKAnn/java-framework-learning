package com.luckk.lizzie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author liukun.inspire
 * @Date 2023/3/16 19:55
 * @PackageName:com.luckk.lizzie
 * @ClassName: Main2
 * @Version 1.0
 */
public class Main2 {

    public static void main(String[] args) {

        find_factor(110,10000);
    }

    static List<Integer> list1 = new ArrayList<>();

    public static void find_factor(int sum,int n){
        //递归出口
        if (n <= 0 || sum <= 0)
            return;
        //输出找到的数
        if (sum == n)
        {
          for (Integer l : list1){
              System.out.print(l+" ");
          }
            System.out.println();
        }
        list1.add(n);
        find_factor(sum - n, n - 1);//n放在里面
        list1.remove(list1.size()-1);
        find_factor(sum, n - 1);//n不放在里面
    }
}
