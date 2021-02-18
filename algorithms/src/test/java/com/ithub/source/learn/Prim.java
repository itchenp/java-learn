package com.ithub.source.learn;

import java.util.ArrayList;
import java.util.List;

public class Prim {
    static int[][] graph;
    //存放已经加入到最小生成树的边
    static List<Integer> arr = new ArrayList<>();
    static boolean[] vis;

    public static void main(String[] args) {
        vis = new boolean[6];
        //邻接矩阵
        graph = new int[][]{
                {0, 6, 1, 5, 0, 0},
                {6, 0, 5, 0, 3, 0},
                {1, 5, 0, 5, 6, 4},
                {5, 0, 5, 0, 0, 2},
                {0, 3, 6, 0, 0, 6},
                {0, 0, 4, 2, 6, 0}
        };
        int ans = prim(0);
        System.out.println(ans);
    }

    private static int prim(int start) {
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            //将该节点加入到集合中
            arr.add(start);
            //标记
            vis[start] = true;
            int val = Integer.MAX_VALUE;
            //寻找最小边
            for (int row : arr) {
                for (int j = 0; j < 6; j++) {
                    if (!vis[j]) {
                        if (graph[row][j] < val && graph[row][j] > 0) {
                            start = j;
                            val = graph[row][j];
                        }
                    }
                }
            }
            ans += val;
        }
        return ans;
    }
}
