package com.sungpi.solutions;

import com.sungpi.ListNode;
import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/merge-k-sorted-lists/
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        // initialize priority queue:
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                if (a.val >= b.val) return 1;
                else return -1;
            }
        });

        for (int i=0; i<lists.length; ++i) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }

        ListNode ret = new ListNode(-1);
        ListNode a = ret;
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            if (curr.next != null) {
                pq.add(curr.next);
            }
            ret.next = new ListNode(curr.val);
            ret = ret.next;
        }

        return a.next;
        // val, index of ListNode[]

        // 1-> 4-> 5,
        // 1-> 3-> 4,
        // 2-> 6

        // (1, 0)
        // (1, 1)
        // (2, 2)

        // poll from priority queue, add it to our return list, add next element from (index) to our priority queue.
        // until it's null(-1),



    }
}
