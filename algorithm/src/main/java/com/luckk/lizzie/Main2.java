package com.luckk.lizzie;

import java.util.*;

/**
 * @Author liukun.inspire
 * @Date 2023/3/16 19:55
 * @PackageName:com.luckk.lizzie
 * @ClassName: Main2
 * @Version 1.0
 */

class Train{
    public int x;
    public int y;

    Train(){

    }
    Train(int xx,int yy){
        this.x = xx;
        this.y = yy;
    }
}
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        List<Train[]> trains = new ArrayList<>();
        for (int i = 0; i < cases; i++) {
            int num = scanner.nextInt();
            Train []arr = new Train[num+1];
            for (int j = 1; j <= num; j++) {
                arr[j] = new Train();
                arr[j].x = scanner.nextInt();
            }
            for (int j = 1; j <= num; j++) {
                int index = scanner.nextInt();
                arr[index].y = j;
            }
            trains.add(arr);
        }

        for (int i = 0; i < trains.size(); i++) {
            boolean flag = doProcess(trains.get(i));
            if (flag){
                System.out.println("Yes");

            }else{
                System.out.println("No");
            }
        }

    }

    public static  boolean doProcess(Train [] arr){
        PriorityQueue<Train> p = new PriorityQueue<>((p1,p2) -> p1.y-p2.y);

        for (int i = 1; i < arr.length; i++) {
            p.add(arr[i]);
        }

        LinkedList<Integer> stack = new LinkedList<>();
        int idx = 1;
        while (!p.isEmpty() ){
            if (idx == arr.length && (stack.isEmpty() || p.peek().x != stack.peekLast()) ){
                return false;
            }
            else if (stack.isEmpty() ){
                if (idx<arr.length){
                    stack.addLast(arr[idx].x);
                    idx++;
                }
            } else if (p.peek().x == stack.peekLast()){
                stack.removeLast();
                p.poll();
            } else if (stack.peekLast() != p.peek().x){
                if (idx<arr.length){
                    stack.addLast(arr[idx].x);
                    idx++;
                }
            } else {
                return false;
            }
// {            while (!stack.isEmpty() && !p.isEmpty()){
//                 // if (p.peek().x == peek && (stack.size()==1 || idx == arr.length)){
//                 if (p.peek().x == stack.peekLast()){
//                     stack.removeLast();
//                     p.poll();
//                 } else{
//                     break;
//                 }
//             }

        }

        return true;

    }


}
