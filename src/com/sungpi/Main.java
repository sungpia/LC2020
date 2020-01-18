package com.sungpi;

import com.sungpi.design.LRUCache;
import com.sungpi.solutions.*;

import java.util.*;

public class Main {


    public static void main(String[] args) {
	// write your code here
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(-1);
        treeNode.right = new TreeNode(-2);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);

        ArrayList<List<Integer>> group = new ArrayList<List<Integer>>();
//        group.add(Arrays.asList(1, 2, 2, 1));
//        group.add(Arrays.asList(3, 1, 2));
//        group.add(Arrays.asList(1, 3, 2));
//        group.add(Arrays.asList(2, 4));
//        group.add(Arrays.asList(3, 1, 2));
//        group.add(Arrays.asList(1, 3, 1, 1));
        group.add(Arrays.asList(1));
        group.add(Arrays.asList(1));
        group.add(Arrays.asList(1));


        Solution554 solution554 = new Solution554();
        int ans = solution554.leastBricks(group);
        System.out.println(ans);
    }
}