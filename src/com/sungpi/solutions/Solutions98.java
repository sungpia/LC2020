package com.sungpi.solutions;

import com.sungpi.TreeNode;

public class Solutions98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        int[] res = traverse(root);
        if (res[2] == 1) return true;
        return false;

    }

    public int[] traverse(TreeNode node) {
        // [0] = min, [1] = max, [2] = bool
        if (node.left == null && node.right == null) {
            //if leaf node,
            int[] ret = {node.val, node.val, 1};
            return ret;
        }
        int[] minmax = {-1, -1, 1};
        // traverse left
        if (node.left != null) {
            int[] lvals = traverse(node.left);
            if (lvals[2] == 0) {
                int[] ret = {node.val, node.val, 0};
                return ret;
            } else {
                if (lvals[1] < node.val) {
                    minmax[0] = lvals[0];
                } else {
                    int[] ret = {node.val, node.val, 0};
                    return ret;
                }
            }
        } else {
            minmax[0] = node.val;
        }

        if (node.right != null) {
            int[] rvals = traverse(node.right);
            if (rvals[2] == 0) {
                int[] ret = {node.val, node.val, 0};
                return ret;
            } else {
                if (node.val < rvals[0]) {
                    minmax[1] = rvals[1];
                } else {
                    int[] ret = {node.val, node.val, 0};
                    return ret;
                }
            }
        } else {
            minmax[1] = node.val;
        }

        return minmax;
    }
}
