package com.luckk.lizzie;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author liukun.inspire
 * @Date 2023/3/25 20:06
 * @PackageName: com.luckk.lizzie
 * @ClassName: Main3
 * @Version 1.0
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            int num = scanner.nextInt();
            Train []arr = new Train[num+1];
            for (int j = 1; j <= num; j++) {
                arr[j] = new Train();
                arr[j].x = scanner.nextInt();
            }
            for (int j = 1; j <= num; j++) {
                int idx = scanner.nextInt();
                arr[idx].y = j;
                // arr[j].y = scanner.nextInt();
            }
            doProcess(arr);
        }

    }

    public static  void doProcess(Train [] arr){
        PriorityQueue<Train> p = new PriorityQueue<>((p1, p2) -> p1.y-p2.y);
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 1; i < arr.length; i++) {
            p.add(arr[i]);
            stack.add(arr[i].x);
        }


        while (!p.isEmpty()){
            if (p.peek().x == stack.peekLast()){
                 stack.removeLast();
                 p.poll();
            } else{
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}
