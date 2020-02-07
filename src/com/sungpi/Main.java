package com.sungpi;

import com.sungpi.design.LRUCache;
import com.sungpi.solutions.*;

import java.util.*;

public class Main {


    public static void main(String[] args) {

        // TreeNode
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.right = new TreeNode(7);

        Solution450 solution450 = new Solution450();
        solution450.deleteNode(treeNode, 3);
        System.out.println(treeNode.left.val);



        // ArrayList
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

        // ListNode
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(5);
//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);
//        ListNode l3 = new ListNode(2);
//        l3.next = new ListNode(6);
//        ListNode[] ls = {l1, l2, l3};
//
//        Solution23 solution23 = new Solution23();
//        ListNode ans = solution23.mergeKLists(ls);
//        System.out.println(ans);


        //Normal
        String inp = "3[a]2[bc]";
        String inp2 = "3[a2[c]]";
        Solution394 solution394 = new Solution394();
        String ans3 = solution394.decodeString(inp);
        String ans4 = solution394.decodeString(inp2);
        System.out.println(ans3);
        System.out.println(ans4);

        Solution1029 solution1029 = new Solution1029();
        int[][] inp1029 = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        int ans = solution1029.twoCitySchedCost(inp1029);
        System.out.println(ans);

    }
}