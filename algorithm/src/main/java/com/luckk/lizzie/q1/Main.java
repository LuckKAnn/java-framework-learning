package com.luckk.lizzie.q1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Main {


    static Set<String> set = new HashSet<>();
    static int N = 0;
    static  String [] strs;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        // 这个题用dfs可以吗
        // 回溯
        strs = new String[N];
        for (int i = 0; i < N; i++) {
            strs[i] = scanner.next();
        }

        boolean[] visit = new boolean[26];
        dfs(0,visit,new StringBuilder());


        System.out.println(set.size());
    }

    public static void dfs(int idx,boolean []visit,StringBuilder sb){
        if (idx == N){
            // 到达最后的地方了
            set.add(sb.toString());
            return;
        }

        String str = strs[idx];

        for (char c : str.toCharArray()){
            if (!visit[c-'a']){
                // 没有访问过
                visit[c-'a'] = true;
                sb.append(c);
                dfs(idx+1, visit, sb);
                sb.deleteCharAt(sb.length()-1);
                visit[c-'a'] = false;
            }
        }


    }
}
