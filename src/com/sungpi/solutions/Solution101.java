package com.sungpi.solutions;

import com.sungpi.TreeNode;

import java.util.ArrayList;
import java.util.Collections;

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> r = new ArrayList<>();
        if (root.left != null) {
            l = traverse(root.left);
        }

        if (root.right != null) {
            r = traverse(root.right);
        }
        Collections.reverse(r);
        if (l.equals(r)) {
            return true;
        }
        return false;
    }

    public ArrayList<Integer> traverse(TreeNode node) {
        // if leaf node
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (node.left == null && node.right == null) {
            ret.add(node.val);
            return ret;
        }
        // in-order traversal

        if (node.left != null) {
            ArrayList<Integer> l = traverse(node.left);
            ret.addAll(0, l);
        } else {
            ret.add(0, null);
        }
        ret.add(node.val);
        if (node.right != null) {
            ArrayList<Integer> r = traverse(node.right);
            ret.addAll(r);
        } else {
            ret.add(null);
        }

        return ret;
    }
}
