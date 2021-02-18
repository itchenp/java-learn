package com.ithub.source.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    static int[][] graph;
    static List<Node> arr = new ArrayList<>();
    static int[] parent;
    static int[] rank;
    static int ans = 0;

    public static void main(String[] args) {
        parent = new int[6];
        rank = new int[6];
        Arrays.fill(parent, -1);
        Arrays.fill(rank, 0);
        graph = new int[][]{
                {0, 6, 1, 5, 0, 0},
                {0, 0, 5, 0, 3, 0},
                {0, 0, 0, 5, 6, 4},
                {0, 0, 0, 0, 0, 2},
                {0, 0, 0, 0, 0, 6},
                {0, 0, 0, 0, 0, 0}
        };
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (graph[i][j] != 0) {
                    arr.add(new Node(i, j, graph[i][j]));
                }
            }
        }
        Collections.sort(arr);
        System.out.println(arr);
        for (int i = 0; i < arr.size(); i++) {
            Node node = arr.get(i);
            union_root(node);
        }
        System.out.println(ans);
    }

    //合并根
    private static void union_root(Node node) {
        int x_root = find_root(node.x);
        int y_root = find_root(node.y);
        //如果在同一棵树上,则不做任何操作
        if (x_root == y_root) {
            return;
        } else {
            //rank数组优化
            if (rank[x_root] > rank[y_root]) {
                parent[y_root] = x_root;
            } else if (rank[x_root] < rank[y_root]) {
                parent[x_root] = y_root;
            } else {
                parent[x_root] = y_root;
                rank[y_root]++;
            }
            ans += node.val;
        }
    }

    //合并根(路径压缩递归版)
    private static int find_root(int x) {
        if (parent[x] == -1) return x;
        return parent[x] = find_root(parent[x]);
    }

    //合并根(路径压缩非递归版)
    /*private static int find_root(int x) {
        int root = x;
        while (parent[root] != -1){
            root = parent[root];
        }
        while (parent[x] != -1){
            int r = parent[x];
            parent[x] = root;
            x = r;
        }
        return root;
    }*/

}

class Node implements Comparable<Node> {
    int x;
    int y;
    int val;

    public Node(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Node o) {
        return this.val - o.val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                ", val=" + val +
                '}';
    }
}
