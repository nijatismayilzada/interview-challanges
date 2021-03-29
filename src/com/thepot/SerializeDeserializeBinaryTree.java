package com.thepot;

import java.util.ArrayList;
import java.util.List;

public class SerializeDeserializeBinaryTree {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return "";
        }

        List<TreeNode> nodes = new ArrayList<>();

        StringBuilder res = new StringBuilder();

        nodes.add(root);

        boolean cont = true;

        while (cont) {
            cont = false;

            List<TreeNode> nextNodes = new ArrayList<>();

            for (TreeNode node : nodes) {
                res.append(node.val).append(',');

                if (node.val == -1001) {
                    continue;
                }

                if (node.left != null) {
                    cont = true;
                    nextNodes.add(node.left);
                } else {
                    nextNodes.add(new TreeNode(-1001));
                }

                if (node.right != null) {
                    cont = true;
                    nextNodes.add(node.right);
                } else {
                    nextNodes.add(new TreeNode(-1001));
                }


            }

            nodes.clear();
            nodes.addAll(nextNodes);


        }
        return res.toString();


    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] nodes = data.split(",");

        if (data.equals("")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        List<TreeNode> tNodes = new ArrayList<>();
        tNodes.add(root);

        boolean cont = false;

        if (nodes.length > 1) {
            cont = true;
        }
        int i = 1;
        while (cont) {

            List<TreeNode> nextGen = new ArrayList<>();

            for (TreeNode treeNode : tNodes) {
                TreeNode lNode = new TreeNode(Integer.parseInt(nodes[i]));
                i++;
                TreeNode rNode = new TreeNode(Integer.parseInt(nodes[i]));
                i++;

                if (lNode.val != -1001) {
                    treeNode.left = lNode;
                    nextGen.add(lNode);
                }
                if (rNode.val != -1001) {
                    treeNode.right = rNode;
                    nextGen.add(rNode);
                }

            }
            tNodes.clear();
            tNodes.addAll(nextGen);

            if (i >= nodes.length) {
                cont = false;
            }

        }

        return root;

    }


}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
