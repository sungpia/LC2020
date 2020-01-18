package com.sungpi.solutions;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution200 {
    Set<Pair<Integer, Integer>> s;
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        if (m == 0) return 0;
        Map<Pair<Integer, Integer>, Pair<Integer, Integer>> map = new HashMap<>();
        int[][] directions = {
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
        };
        s = new HashSet<>();
        for (int i=0; i<n; ++i) {
            for(int j=0; j<m; ++j) {
                if (grid[i][j] == '1') map.put(new Pair<>(i, j), new Pair<>(i, j));
            }
        }
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                if (grid[i][j] == '1') {
                    for (int d=0; d<4; ++d) {
                        int[] dr = directions[d];
                        int[] next = {i + dr[0], j + dr[1]};
                        if (isValid(next, n, m) && grid[next[0]][next[1]] == '1') {
                            union(new Pair<>(i, j), new Pair<>(next[0], next[1]), map);
                        }
                    }
                }
            }
        }
        for (Map.Entry<Pair<Integer, Integer>, Pair<Integer, Integer>> entry : map.entrySet()) {
            s.add(find(entry.getValue(), map));
        }
        return s.size();
    }

    boolean isValid(int[] p, int n, int m) {
        if (p[0] < 0 || p[0] >= n) return false;
        if (p[1] < 0 || p[1] >= m) return false;
        return true;
    }
    void union(Pair<Integer, Integer> parent, Pair<Integer, Integer> child, Map<Pair<Integer, Integer>, Pair<Integer, Integer>> map) {
        Pair<Integer, Integer> p = find(parent, map);
        Pair<Integer, Integer> c = find(child, map);

        if (p.equals(c)) {
            // already an union
        } else {
            // make it union
//            s.add(parent);
            map.put(c, p);
        }
    }

    Pair<Integer, Integer> find(Pair<Integer, Integer> point, Map<Pair<Integer, Integer>, Pair<Integer, Integer>> map) {
        while(map.containsKey(point)) {
            if (point.equals(map.get(point))) break;
            point = map.get(point);
        }
        return point;
    }


}
