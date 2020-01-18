package com.sungpi.solutions;

import javafx.util.Pair;

import java.util.*;

public class Solution126 {
    public class Trace {
        public String str;
        public Integer depth;
        public List<String> trace;
        public Trace(String str, Integer depth, List<String> trace) {
            this.str = str;
            this.depth = depth;
            this.trace = trace;
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ret = new ArrayList<>();
        if (!wordList.contains(endWord)) return ret;
        //Initialize queue for BFS
        Queue<Object[]> q = new LinkedList<>();
        Object[] objs = {beginWord, 1, new ArrayList<>(Arrays.asList(beginWord))};
        q.add(objs);
        Map<String, Integer> visited = new HashMap<>();
        visited.put(beginWord, 1);
        //
        int foundDepth = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            Object[] trace = q.poll();
            String word = (String) trace[0];
            Integer depth = (Integer) trace[1];
            if (depth > foundDepth) {
                break;
            }

            for (String str : wordList) {
                if (wordDiff(str, word) == 1 && ((visited.containsKey(str) && visited.get(str) >= depth) || !visited.containsKey(str))) {
                    List<String> tr = new ArrayList<>((ArrayList) trace[2]);
                    if(!tr.contains(str)) {
                        tr.add(str);
                        if(str.equals(endWord)) {
                            ret.add(tr);
                            foundDepth = depth;
                        }
                        visited.put(str, depth);
                        Object[] o = {str, depth+1, tr};
                        q.add(o);
                    }
                }
            }
        }
        return ret;
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
