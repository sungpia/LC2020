package com.sungpi.solutions;

import javafx.util.Pair;

import java.util.*;

public class Solution937 {
    public String[] reorderLogFiles(String[] logs) {
        List<String> ret = new ArrayList<>();
        List<Pair<String, String>> toSort = new ArrayList<>();
        for(String log : logs) {
            String[] words = log.split(" ");
            String id = words[0];
            String tail = String.join(" ", Arrays.copyOfRange(words, 1, words.length));

            // TODO: check if tail contains ![0-9]
            boolean flag = true;
            for (char c : tail.toCharArray()) {
                if (c < '0' || c > '9' ) {
                    if (c == ' ') continue;
                    toSort.add(new Pair<>(id, tail));
                    flag = false;
                }
            }
            if (flag) {
                ret.add(id + " " + tail);
            }
        }
        Collections.sort(toSort, (a, b) -> a.getValue().compareTo(b.getValue()));
        for (Pair<String, String> p : toSort) {
            ret.add(0, p.getKey() + " " + p.getValue());
        }
        String[] r = ret.toArray(new String[ret.size()]);
        return r;

    }
}
/*
Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 */