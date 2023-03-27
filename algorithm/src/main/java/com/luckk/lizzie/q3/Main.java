package com.luckk.lizzie.q3;


import java.util.*;

/**
 * @Author liukun.inspire
 * @Date 2023/3/26 17:56
 * @PackageName: com.luckk.lizzie.q3
 * @ClassName: Main
 * @Version 1.0
 */public class Main {
    public static void main(String[] args) {
        // 用前缀和？
        // 异或也具有前缀和的思想
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int []arr = new int[num+1];
        int [] nub = new int[num+1];
        int count = 1;
        for (int i = 1; i <=num; i++) {
            arr[i]= scanner.nextInt();
            if (arr[i] == 1){
                nub[i] = nub[i-1];
            }else{
                nub[i] = count++;
            }
        }

        int res = num;
        for (int i = 1; i <= num-1; i++) {
            for (int j = i+1; j <= num; j++) {
                if (nub[j]-nub[i] == 0){
                    res++;
                }
            }
        }
        System.out.println(Arrays.toString(nub));
        System.out.println(res);
    }

    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     int num = scanner.nextInt();
    //     int []arr = new int[num];
    //     for (int i = 0; i < num; i++) {
    //         arr[i]= scanner.nextInt();
    //     }
    //
    //     int res = num;
    //     long c = 0;
    //     int yihuo = 0;
    //     for (int i = 0; i < num; i++) {
    //         c = arr[i];
    //         yihuo = arr[i];
    //         for (int j = i+1; j < num; j++) {
    //             c = c* arr[j];
    //             yihuo = yihuo^arr[j];
    //
    //             if (c== yihuo){
    //                 res++;
    //             }
    //         }
    //     }
    //     System.out.println(res);
    // }
}
