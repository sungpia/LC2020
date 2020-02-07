package com.sungpi.solutions;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution1029 {
    public int twoCitySchedCost(int[][] costs) {
        if (costs.length == 0) return 0;
        // Preprocess to apply greedy.
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
                if (a.getKey() >= b.getKey()) return 1;
                else return -1;
            }
        });
        for (int i=0; i<costs.length; ++i) {
            pq.add(new Pair<>(costs[i][0] - costs[i][1], i));
        }

        int sum = 0;
        for (int i=0; i<costs.length; ++i) {
            Pair<Integer, Integer> p = pq.poll();
            if (i < costs.length/2) {
                sum += costs[p.getValue()][0];
            } else {
                sum += costs[p.getValue()][1];
            }
        }

        return sum;
    }
}
