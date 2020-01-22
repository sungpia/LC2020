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

//        int[] stones = {0,1,3,5,6,8,12,18};
//        Solution403 solution403 = new Solution403();
//        boolean ans = solution403.canCross(stones);
//        System.out.println(ans);

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] ls = {l1, l2, l3};
        Solution23 solution23 = new Solution23();
        ListNode ans = solution23.mergeKLists(ls);
        System.out.println(ans);

    }
}