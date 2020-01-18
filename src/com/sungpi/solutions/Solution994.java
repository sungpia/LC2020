package com.sungpi.solutions;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Solution994 {
    public int orangesRotting(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int terminateCondition = 0;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        for (int i=0; i<x; ++i) {
            for (int j=0; j<y; ++j) {
                if (grid[i][j] == 2) {
                    q.add(new Pair<>(i, j));
                } else if (grid[i][j] == 1) {
                    terminateCondition++;
                }
            }
        }

        int[][] directions = {
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1}
        };

        while (!q.isEmpty()) {
            Pair<Integer, Integer> pos = q.poll();
            int px = pos.getKey();
            int py = pos.getValue();
            int nx;
            int ny;
            for (int i=0; i<4; ++i) {
                nx = px + directions[i][0];
                ny = py + directions[i][1];

                if (nx < 0 || nx >=  x || ny < 0 || ny >= y) {
                    continue;
                }

                if (grid[nx][ny] == 0) {
                    continue;
                }

                if (grid[nx][ny] == 1) {
                    grid[nx][ny] = 2;
                    terminateCondition--;
                    q.add(new Pair<>(nx, ny));
                }

                if (terminateCondition <= 0) {

                }
            }


        }
        return 0;
    }
}
