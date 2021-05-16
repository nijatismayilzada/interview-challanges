package com.thepot;

public class BinaryTreeMaximumPathSum {


    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);

        return max;




    }

    public int maxPathSumHelper(TreeNode root){

        if (root == null){
            return 0;
        }


        int left = Math.max(maxPathSumHelper(root.left), 0);
        int right = Math.max(maxPathSumHelper(root.right), 0);


        max = Math.max(max, left + root.val + right);

        return root.val + Math.max(left, right);



    }


}
