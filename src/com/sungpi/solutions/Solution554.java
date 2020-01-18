package com.sungpi.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution554 {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null) return 0;
        List<List<Integer>> p = new ArrayList<>();
        // pre-process data
        int length = 0;
        for (List<Integer> list : wall) {
            List<Integer> a = new ArrayList<>();
            a.add(list.get(0));
            for (int i = 1; i <list.size(); ++i) {
//                System.out.println(list.get(i-1) + " " + list.get(i));
                a.add(a.get(i-1) + list.get(i));
                length = a.get(i-1) + list.get(i);
            }
            p.add(a);
            System.out.println(a);
        }
//        System.out.println(p);
        // // count occurences
        Map<Integer, Integer> oc = new HashMap<>();
        System.out.println(length);
        for (List<Integer> list : p) {
            for (int i=0; i<list.size(); ++i) {
                if(i == list.size()-1) continue;
                oc.putIfAbsent(list.get(i), 0);
                oc.put(list.get(i), oc.get(list.get(i)) + 1);
            }
        }
        System.out.println(oc);
        // // # of input - max(occurences)
        int max = -1;
        for (Map.Entry<Integer, Integer> entry : oc.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        if (max == -1) return wall.size();
        return wall.size() - max;
    }
}
