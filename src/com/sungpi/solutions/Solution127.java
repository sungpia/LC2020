package com.sungpi.solutions;

import javafx.util.Pair;

import java.util.*;

public class Solution127 {
    int min = Integer.MAX_VALUE;
    boolean changed = false;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        //Initialize queue for BFS
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(beginWord, 1));

        //
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while(!q.isEmpty()) {
            Pair<String, Integer> p = q.poll();
            String word = p.getKey();
            Integer depth = p.getValue();

            for (String str : wordList) {
                if (wordDiff(str, word) == 1 && !visited.contains(str)) {
                    if(str.equals(endWord)) return depth+1;
                    visited.add(str);
                    q.add(new Pair<>(str, depth+1));
                }
            }
        }
        return 0;
    }

    public int wordDiff(String a, String b) {
        int cnt = 0;
        for (int i=0; i<a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}
