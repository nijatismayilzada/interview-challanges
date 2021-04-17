package com.thepot;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {


        System.out.println(new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(
                new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)))));


    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }


        List<TreeNode> nodes = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        nodes.add(root);

        boolean zigzag = false;

        while (!nodes.isEmpty()) {

            List<TreeNode> nextLevel = new ArrayList<>();
            List<Integer> res = new ArrayList<>();

            for (TreeNode node : nodes) {
                res.add(node.val);

                if (node.left != null)
                    nextLevel.add(node.left);
                if (node.right != null)
                    nextLevel.add(node.right);

            }

            if (zigzag) {
                Collections.reverse(res);
                zigzag = false;
            } else {
                zigzag = true;
            }

            nodes = nextLevel;
            result.add(res);

        }

        return result;

    }
}
