package com.sungpi.solutions;

        import javafx.util.Pair;

        import java.util.*;

public class Solution5 {
    public String longestPalindrome(String s) {
        if (s.equals("")) return "";
        int sl = s.length();
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for (int i=0; i<s.length(); ++i) {
            q.add(new Pair<>(i, i));
        }

        // til q is empty, inspect palindrome to (left, right);
        // case: "aa" is also a palindrome.
        int maxLength = 0;
        String ret = null;
        Set<Pair<Integer, Integer>> cache = new HashSet<>();
        int cnt = 0;
        while (!q.isEmpty()) {
            Pair<Integer, Integer> pop = q.poll();
            int start = pop.getKey();
            int end = pop.getValue();
            cnt++;
            System.out.println(start + " , " + end + ": " + cnt);

            cache.add(new Pair<>(start, end));

            if (end-start >= maxLength) {
                maxLength = end-start;
                ret = s.substring(start, end+1);
            }
            if (validate(start-1, end+1, sl)) {
                if (s.charAt(start-1) == s.charAt(end+1) && !cache.contains(new Pair<>(start-1, end+1))) {
                    q.add(new Pair<>(start-1, end+1));
                    cache.add(new Pair<>(start-1, end+1));
                }

            }
            if (validate(start, end+1, sl)) {
                if (start == end && s.charAt(start) == s.charAt(end+1) && !cache.contains(new Pair<>(start, end+1))) {
                    q.add(new Pair<>(start, end+1));
                    cache.add(new Pair<>(start, end+1));
                }
            }
        }
        return ret;
    }

    boolean validate(int a, int b, int sl) {
        if (a < 0 || b > sl-1) return false;
        return true;
    }
}
