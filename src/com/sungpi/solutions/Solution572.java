package com.sungpi.solutions;

public class Solution572 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        String ss = inOrder(s);
        String tt = inOrder(t);

        if (ss.contains(tt)) return true;
        return false;
    }

    private String inOrder(TreeNode n) {
        if (n == null) return "";

        String ret = "";
        ret += inOrder(n.left);
        ret += n.val;
        ret += inOrder(n.right);
        return ret;
    }
}
