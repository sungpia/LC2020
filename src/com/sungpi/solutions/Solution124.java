package com.sungpi.solutions;

import com.sungpi.TreeNode;

public class Solution124 {
    public int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return max;
    }

    public int traverse(TreeNode node) {
        if (node.left == null && node.right == null) {
            if (node.val > max) max = node.val;
            return node.val;
        }
        int l = 0, r = 0;
        if (node.left != null) {
            l = traverse(node.left);
        }

        if (node.right != null) {
            r = traverse(node.right);
        }

        if (l + r + node.val > max) {
            max = l + r + node.val;
        }

        if ( Math.max(l, r) + node.val > max) {
            max = Math.max(l, r) + node.val;
        }

        if (node.val > max) {
            max = node.val;
        }
        return Math.max(Math.max(l, r) + node.val, node.val);
    }
}
