package com.luckk.lizzie.unionfind;

/**
 * @Author liukun.inspire
 * @Date 2023/3/6 20:40
 * @PackageName:com.luckk.lizzie.unionfind
 * @ClassName: UnionFind
 * @Version 1.0
 */
public class UnionFind {

    private int[] parent;

    private int count ;

    public UnionFind(int n) {
        parent = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }


    public void union(int i,int j){
        int ifather  = find(i);
        int jfather = find(j);
        if (ifather==jfather) return;
        parent[ifather] = jfather;
        count--;
    }

    public boolean isConnected(int i,int j){
        int ifather = find(i);
        int jfather = find(j);

        return ifather == jfather;

    }

    private int find(int x){

        if (parent[x] != x){
            int pparent = find(this.parent[x]);
            parent[x] = pparent;
        }
        return parent[x];
    }

    public int getCount() {
        return count;
    }
}
