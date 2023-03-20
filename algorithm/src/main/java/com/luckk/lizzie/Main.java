package com.luckk.lizzie;

import java.util.*;

public class Main {
    static int n;
    static int m;
    static int [][]board;

    static Map<Integer,List<int[]>> mp = new HashMap<>();

    static long min = Long.MAX_VALUE;

    static long [][]remeber;


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
         n = scanner.nextInt();
         m = scanner.nextInt();
         board = new int[n][m];
         remeber = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = scanner.nextInt();
                remeber[i][j]=-1;
                if (mp.containsKey(board[i][j])){
                    mp.get(board[i][j]).add(new int[]{i,j});
                } else{
                    ArrayList<int[]> list = new ArrayList<>();
                    list.add(new int[]{i,j});
                    mp.put(board[i][j],list);
                }
            }
        }

        boolean[][]visit = new boolean[n][m];
        dfs(0,0,0,visit,false);
        System.out.println(min);

    }


    public static void dfs(int i,int j,long time,boolean[][]visit,boolean hasTiao){

        if (i==n-1 && j==m-1){
            min = Math.min(min,time);
            return;
        }

        if (remeber[i][j]!=-1 && remeber[i][j]<=time && hasTiao){
            return;
        }
        remeber[i][j] = time;

        if (time>min) {
            return;
        }

        List<int[]> other = mp.get(board[i][j]);
        for (int k = 0; k < other.size() && !hasTiao; k++) {
            int[] node = other.get(k);
            if (node[0]!=i && node[1]!=j){
                hasTiao = true;
                visit[node[0]][node[1]]=true;
                dfs(node[0],node[1],time,visit,hasTiao);
                hasTiao = false;
                visit[node[0]][node[1]]=false;
            }
        }

        if (i>0){
            //向上走？
            if (!visit[i-1][j]){
                visit[i-1][j]= true;
                dfs(i-1,j,time+Math.abs(board[i][j]-board[i-1][j]),visit,hasTiao);
                visit[i-1][j]=false;
            }
        }

        if (i<n-1){
            //向上走？
            if (!visit[i+1][j]){
                visit[i+1][j]= true;
                dfs(i+1,j,time+Math.abs(board[i][j]-board[i+1][j]),visit,hasTiao);
                visit[i+1][j]=false;
            }
        }

        if (j>0){
            //向左走
            if (!visit[i][j-1]){
                visit[i][j-1]= true;
                dfs(i,j-1,time+Math.abs(board[i][j]-board[i][j-1]),visit,hasTiao);
                visit[i][j-1]=false;
            }
        }


        if (j<m-1){
            //向左走
            if (!visit[i][j+1]){
                visit[i][j+1]= true;
                dfs(i,j+1,time+Math.abs(board[i][j]-board[i][j+1]),visit,hasTiao);
                visit[i][j+1]=false;
            }
        }
    }
}
