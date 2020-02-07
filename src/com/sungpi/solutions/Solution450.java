package com.sungpi.solutions;

import com.sungpi.TreeNode;
import javafx.util.Pair;

public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {

        // Search TreeNode, until key==val.
        //  Hold information of parent of TreeNode.
        TreeNode foundNode = binarySearchTreeNode(root, null, key);

        // For found TreeNode foundNode and parentNode, we can perform three possible deletion on Node.
        // 1) If there's no child, delete foundNode.
        if (foundNode.left == null && foundNode.right == null) foundNode = null;
        // 2) If there's both child. foundNode.val = foundNode.right.leftmost.val, delete foundNode.right.leftmost.
        if (foundNode.left != null && foundNode.right != null) {
            TreeNode rightsLeftMost = leftMost(foundNode.right);
            foundNode.val = rightsLeftMost.val;
            rightsLeftMost = null;
        }
        // 3) If there's one child, parentNode.left(right) = foundNode.left(right).
        if (foundNode.left != null) {
            foundNode = foundNode.left;
        } else {
            foundNode = foundNode.right;
        }
        return root;
    }

    private TreeNode binarySearchTreeNode(TreeNode node, TreeNode parent, int key) {
        if (node == null) return null;
        if (key == node.val) return node;
        else if (key < node.val) {
            if (node.left != null) {
                return binarySearchTreeNode(node.left, node, key);
            }
        } else {
            if (node.right != null) {
                return binarySearchTreeNode(node.right, node, key);
            }
        }
        return null;
    }

    private TreeNode leftMost(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return leftMost(node.left);
    }
}
