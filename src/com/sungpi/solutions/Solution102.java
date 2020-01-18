package com.sungpi.solutions;

import com.sungpi.TreeNode;
import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.*;

public class Solution102 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ret = new ArrayList<>();
        traverse(root, map, 1);
        System.out.println(map);
        for (Map.Entry entry : map.entrySet()) {
            int lv = (int) entry.getKey();
            if (lv % 2 == 0) Collections.reverse((ArrayList) entry.getValue());
            ret.add((ArrayList) entry.getValue());
        }
        return ret;
    }

    public void traverse(TreeNode node, Map<Integer, List<Integer>> map, int lv) {
        if (node == null ) return;

        map.putIfAbsent(lv, new ArrayList<>());
        map.get(lv).add(node.val);

        if (node.left != null) {
            traverse(node.left, map, lv+1);
        }

        if (node.right != null) {
            traverse(node.right, map, lv+1);
        }
    }
}
