//package com.sungpi.solutions;
//
//public class Solution21 {
//    /**
//     * Definition for singly-linked list.
//     * public class ListNode {
//     *     int val;
//     *     ListNode next;
//     *     ListNode(int x) { val = x; }
//     * }
//     */
//
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode header = new ListNode(0);
//        ListNode ret = header;
//        while(true) {
//            int val;
//            if(l1 == null && l2 == null) break;
//            else if(l2 == null || (l1 != null && l1.val >= l2.val)) {
//                val = l1.val;
//                l1 = l1.next;
//            } else {
//                val = l2.val;
//                l2 = l2.next;
//            }
//            header.next = new ListNode(val);
//            header = header.next;
//        }
//        return ret.next;
//    }
//}
