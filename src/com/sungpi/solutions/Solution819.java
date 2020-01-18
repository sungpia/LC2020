package com.sungpi.solutions;

import java.util.*;

public class Solution819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] strs = paragraph.replace(",", " ").replace(".", " ").replace("'", " ").replace("?", " ").replace(";", " ").replace("!"," ").split(" ");
        Map<String, Integer> wordCount = new HashMap<>();
        for (int i=0; i<strs.length; ++i) {
            if (!strs[i].equals(""))
            wordCount.put(strs[i].toLowerCase(), wordCount.getOrDefault(strs[i].toLowerCase(),0) + 1);
        }
        List<Map.Entry<String, Integer>> toSort = new LinkedList<>(wordCount.entrySet());
        Collections.sort(toSort, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                if (a.getValue() < b.getValue()) return 1;
                else if (a.getValue().equals(b.getValue())) return 0;
                else return -1;
            }
        });
        List<String> ss = new ArrayList<>(Arrays.asList(banned));
        for(int i=0; i<toSort.size(); ++i) {
            if(!ss.contains(toSort.get(i).getKey())) {
                return toSort.get(i).getKey();
            }
        }

        return strs[0];
    }
}
