package com.sungpi.solutions;

import javafx.util.Pair;

import java.util.*;

// https://leetcode.com/problems/frog-jump/
public class Solution403 {
    public boolean canCross(int[] stones) {
        Set<Integer> stoneCache = new HashSet<>();
        for (int i=0; i<stones.length; ++i) {
            stoneCache.add(stones[i]);
        }
        if (!stoneCache.contains(0)) return false;

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(0, 0));

        while (!q.isEmpty()) {
            Pair<Integer, Integer> p = q.poll();
            int k = p.getValue();
            int pos = p.getKey();

            for (int jump = k-1; jump <= k+1; ++jump) {
                if (jump > 0) {
                    int newpos = pos + jump;
                    if (newpos == stones[stones.length-1]) return true;
                    if (stoneCache.contains(newpos)) {
                        q.add(new Pair<>(newpos, jump));
                    }
                }
            }
        }

        return false;

    }
}
