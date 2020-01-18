package com.sungpi.solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution973 {
    public int[][] kClosest(int[][] points, int K) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                int e1 = eucideanDistance(p1);
                int e2 = eucideanDistance(p2);
                if (e1 > e2) return 1;
                else if (e1 == e2) return 0;
                else return -1;
            }
        });
        for (int i=0; i<n; ++i) {
            pq.add(points[i]);
        }

        int[][] ret = new int[K][2];
        for (int i=0; i<K; ++i) {
            int[] p = pq.poll();
            ret[i][0] = p[0];
            ret[i][1] = p[1];
        }
        return ret;
    }

    int eucideanDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
