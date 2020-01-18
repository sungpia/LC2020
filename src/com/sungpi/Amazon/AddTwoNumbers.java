package com.sungpi.Amazon;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//class AddTwoNumbers {
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        add(l1, l2, 0, ret);
        return ret;
    }

    public void add(ListNode a, ListNode b, int carry, ListNode ret) {

        if (a != null) {
            ret.val += a.val;
            a = a.next;
        }
        if (b != null) {
            ret.val += b.val;
            b = b.next;
        }
        ret.val += carry;
        if (ret.val >= 10) {
            ret.val -= 10;
            carry = 1;
        } else {
            carry = 0;
        }

        if ( a == null && b == null && carry == 0) return;
        else if ( a == null && b == null) {
            ret.next = new ListNode(carry);
            return;
        }
        else ret.next = new ListNode(0);
        add(a, b, carry, ret.next);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}